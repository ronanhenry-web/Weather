package com.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.weather.databinding.ActivityPokemonBinding

class PokemonActivity : AppCompatActivity() {

    //Instantiation
    val binding by lazy { ActivityPokemonBinding.inflate(layoutInflater) }
    val model by lazy { ViewModelProvider(this).get(PokemonViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btLoad.setOnClickListener {
            model.loadData()
        }

        observe()

    }

    fun observe() {
        //j'écoute la donnée de l'errorMessage
        //Chaque postValue sur errorMessage va déclancher l'observateur
        //Le fait également à l'abonnement
        model.errorMessage.observe(this) {
            if (it.isNotBlank()) {
                binding.tvError.text = it
                binding.tvError.isVisible = true
            }
            else {
                binding.tvError.isVisible = false
            }
        }

        //observation du traitement
        model.runInProgress.observe(this) {
            binding.progressBar.isVisible = it
        }

        //Observation des données
        model.data.observe(this) {
            binding.tv.text = it?.name ?: "-"
        }
    }
}