package ru.bww.app.stock.presentation.view

import com.arellomobile.mvp.MvpView
import ru.bww.app.stock.model.ReqwestCurrency

interface MainView : MvpView {
    fun resetRvStock(result: ArrayList<ReqwestCurrency>)

}
