package ru.bww.app.stock.model

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import retrofit2.Response
import ru.bww.app.stock.presentation.view.MainView

object AppCoroutines {

    fun getStocksList(viewState: MainView?) : Boolean {
        launch(UI) {
            val result = ArrayList<ReqwestCurrency>()
            var response: Response<JSONStock>? = null
            try {
                response = async(CommonPool) {
                    APIController.getAPI().getCurrency().execute()
                }.await()
            } catch (e: Throwable) {
                e.printStackTrace()
                return@launch
            }
            val body = response.body()
            if (body != null) {
                kotlin.run {
                    for (ob in body.stock) {
                        result.add(ReqwestCurrency(ob.name, ob.volume, ob.price.amount))
                    }
                }
            }
            viewState!!.resetRvStock(result)
        }
        return true
    }
}
