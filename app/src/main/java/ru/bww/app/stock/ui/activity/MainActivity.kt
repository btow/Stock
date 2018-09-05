package ru.bww.app.stock.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_main.*
import ru.bww.app.stock.R
import ru.bww.app.stock.model.ReqwestCurrency
import ru.bww.app.stock.model.RvCurrencyAdapter
import ru.bww.app.stock.presentation.presenter.MainPresenter
import ru.bww.app.stock.presentation.view.MainView


class MainActivity : MvpAppCompatActivity(), MainView {

    companion object {
        const val TAG = "MainActivity"
        fun getIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
    }

    @InjectPresenter
    lateinit var mMainPresenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        rvCurrency.layoutManager = LinearLayoutManager(this)
        mMainPresenter.getStock()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return if (menu != null){
            MenuInflater(this).inflate(R.menu.tt_menu, menu)
            true
        } else
            false
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item!!.itemId){
            R.id.reset -> {
                rvCurrency.adapter = RvCurrencyAdapter( ArrayList<ReqwestCurrency>())
                mMainPresenter.getStock()
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun resetRvStock(result: ArrayList<ReqwestCurrency>) {
        rvCurrency.adapter = RvCurrencyAdapter(result)
        mMainPresenter.startTimer()
    }
}
