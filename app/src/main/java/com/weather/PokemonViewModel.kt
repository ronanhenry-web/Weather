package com.weather

import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.picasso.Picasso
import kotlin.concurrent.thread

class PokemonViewModel : ViewModel() {
    var errorMessage = MutableLiveData("")
    var data = MutableLiveData<PokemonBean?>()
    //thread en cours ou non -> pour la progressBar
    var runInProgress = MutableLiveData(false)

    fun loadData(){
        //déclanche l'observateur
        errorMessage.postValue("")
        data.postValue(null)
        runInProgress.postValue(true)

        thread {
            try {
                //Requêtes
                data.postValue(RequestUtils.loadRandomPokemon())
            }
            catch (e: Exception) {
                //J'affiche le detail de l'erreur dans la console
                e.printStackTrace()
                errorMessage.postValue(e.message ?: "Une erreur est survenue")
            }
            runInProgress.postValue(false)
        }
    }
}