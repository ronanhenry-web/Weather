package com.weather

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

const val URL_API_WEATHER = "https://api.openweathermap.org/data/2.5/weather?appid=b80967f0a6bd10d23e44848547b26550&units=metric&lang=fr&q="
const val URL_API_POKEMONN3 = "https://www.amonteiro.fr/api/pokemonN3"

fun main() {
}

//Requete web
object RequestUtils {

    val client = OkHttpClient()
    val gson = Gson()

    fun loadRandomPokemon(): PokemonBean {
        //Controle
        //Requête web
        val json = sendGet(URL_API_POKEMONN3)
        //Parsing
        return gson.fromJson(json, PokemonBean::class.java)
    }

    fun loadWeather(city: String): WeatherBean {
        //Controle
        //Requête web
        val json = sendGet(URL_API_WEATHER + city)
        //Parsing
        return gson.fromJson(json, WeatherBean::class.java)
    }


    //Méthode qui prend en entrée une url, execute la requête
    //Retourne le code HTML/JSON reçu
    fun sendGet(url: String): String {
        println("url : $url")
        //Création de la requête
        val request = Request.Builder().url(url).build()
        //Execution de la requête
        return client.newCall(request).execute().use { //it:Response
            //use permet de fermer la réponse qu'il y ait ou non une exception
            //Analyse du code retour
            if (!it.isSuccessful) {
                //On regarde s'il n'y a pas un JSON de le message d'erreur
//                val json = it.body.string()
//                if(json.isNotBlank() && json.contains("{") && json.contains("}")) {
//                    val error = gson.fromJson(json, WeatherErrorBean::class.java)
//                    throw Exception("Réponse du serveur incorrect : ${error.message}")
//                }
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            //Résultat de la requête
            it.body.string()
        }
    }

}