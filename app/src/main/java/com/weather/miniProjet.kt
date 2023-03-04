package com.weather

fun main() {

//    var html = RequestUtils.sendGet("https://www.google.fr")
//    println("res=$html")


//    val weather = RequestUtils.loadWeather("nice")
//    println("Il fait ${weather.main.temp}° à ${weather.name} avec un vent de ${weather.wind.speed} km/h")

    val pokemon = RequestUtils.loadRandomPokemon()
    println("${pokemon.name} à comme type ${pokemon.type}")
}