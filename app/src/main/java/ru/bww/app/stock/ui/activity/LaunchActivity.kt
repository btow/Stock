package ru.bww.app.stock.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.bww.app.stock.R
import ru.bww.app.stock.presentation.presenter.LaunchPresenter
import ru.bww.app.stock.presentation.view.LaunchView


class LaunchActivity : MvpAppCompatActivity(), LaunchView {
    companion object {
        const val TAG = "LaunchActivity"
    }

    @InjectPresenter
    lateinit var mLaunchPresenter: LaunchPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        object : CountDownTimer(3000, 3000) {
            override fun onFinish() {
                val i = Intent(applicationContext, MainActivity::class.java)
                startActivity(i)
                finish()
            }

            override fun onTick(l: Long) {}
        }.start()
    }
}
