package com.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.weather.databinding.ActivityWeatherAroundBinding

class WeatherAroundActivity : AppCompatActivity() {

    //Instantiation
    val binding by lazy { ActivityWeatherAroundBinding.inflate(layoutInflater) }
    val model by lazy {
        ViewModelProvider(this).get(WeatherAroundViewModel::class.java)
    }

    val adapter = PokemonListAdapter()

    var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btAdd.setOnClickListener {
            model.list.add(0, PokemonBean("Salameche$count", arrayListOf("Feu")))
            count++
            //OIn prévient que les données ont changé
            adapter.submitList(model.list.toList())
        }

        binding.btDelete.setOnClickListener {
            model.list.removeFirstOrNull()
            //OIn prévient que les données ont changé
            adapter.submitList(model.list.toList())
        }

        //reglage recyclerView
        binding.rv.adapter = adapter
        binding.rv.layoutManager = GridLayoutManager(this, 2)

    }
}