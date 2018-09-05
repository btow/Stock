package ru.bww.app.stock.model

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("/stocks.json")
    fun getCurrency(): Call<JSONStock>

}