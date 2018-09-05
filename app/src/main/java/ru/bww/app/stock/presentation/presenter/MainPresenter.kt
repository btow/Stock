package ru.bww.app.stock.presentation.presenter

import android.os.CountDownTimer
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.bww.app.stock.model.AppCoroutines
import ru.bww.app.stock.model.ReqwestCurrency
import ru.bww.app.stock.presentation.view.MainView

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    companion object {
        var mViewState: MainView? = null
        object timer : CountDownTimer(15000, 15000) {
            override fun onFinish() {
                AppCoroutines.getStocksList(mViewState)
                mViewState!!.resetRvStock(ArrayList<ReqwestCurrency>())
            }

            override fun onTick(l: Long) {}
        }
    }

    init {
        mViewState = viewState
    }

    fun getStock(): Boolean {
        timer.cancel()
        return AppCoroutines.getStocksList(viewState)
    }

    fun startTimer() {
        timer.start()
    }

}
