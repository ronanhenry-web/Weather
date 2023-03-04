package com.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.weather.R
import com.weather.databinding.ActivityWeatherBinding

class WeatherActivity : AppCompatActivity() {
    //Instantiation
    val binding by lazy { ActivityWeatherBinding.inflate(layoutInflater) }
    val model by lazy { ViewModelProvider(this).get(WeatherViewModel::class.java) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        observe()

        binding.btLoad.setOnClickListener {
            val city = binding.etCityName.text.toString()
            model.loadData(city)
        }
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
            //Affichage des données
            binding.tv.text = it?.name ?: "-"
            binding.tvWind.text = it?.wind?.speed?.toString() ?: "-"
            binding.tvTemp.text = "${it?.main?.temp ?: "-"}°"
            binding.tvMinMax.text = "(${it?.main?.temp_min ?: "-"}° / ${it?.main?.temp_max ?: "-"}°)"

            if (!it?.weather.isNullOrEmpty()) {
                binding.tvDesc.text = it?.weather?.get(0)?.description ?: "-"
                Picasso.get().load("https://openweathermap.org/img/wn/${it?.weather?.get(0)?.icon}@4x.png")
                    .placeholder(R.drawable.baseline_whatshot_24)
                    .error(R.drawable.baseline_delete_forever_24)
                    .into(binding.ivTemp)
            }
        }
    }

}