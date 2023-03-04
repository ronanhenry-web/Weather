package com.weather

import com.google.gson.Gson

fun main() {
    val plane :PlaneBean? = null//PlaneBean("toto")

    println(plane.toJson())

}



fun Any?.toJson()  = if(this == null) "{}" else  Gson().toJson(this)