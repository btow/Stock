package ru.bww.app.stock.model

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.bww.app.stock.BuildConfig

object APIController {

    private val LOG_TAG = "APIController"

    fun getAPI(): APIInterface {
        val gson: Gson = GsonBuilder()
                .setLenient()
                .create()
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor { message: String -> Log.i(LOG_TAG, message) }
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(interceptor)
        }

        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(builder.build())
                .build()
                .create(APIInterface::class.java)
    }
}
