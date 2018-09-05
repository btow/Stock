package ru.bww.app.stock.model

data class JSONOb (
        val name : String,
        val price : JSONPrice,
        val percent_change : Float,
        val volume : Int,
        val symbol : String
)
