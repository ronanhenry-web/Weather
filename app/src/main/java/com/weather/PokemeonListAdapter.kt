package com.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.weather.PokemonBean
import com.weather.databinding.RowPokemonBinding

class PokemonListAdapter : ListAdapter<PokemonBean, PokemonListAdapter.ViewHolder>(Comparator()) {

    class ViewHolder(val binding : RowPokemonBinding) : RecyclerView.ViewHolder(binding.root)

    class Comparator : DiffUtil.ItemCallback<PokemonBean>() {
        override fun areItemsTheSame(oldItem: PokemonBean, newItem: PokemonBean) = oldItem === newItem

        override fun areContentsTheSame(oldItem: PokemonBean, newItem: PokemonBean)= oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
     = ViewHolder(RowPokemonBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.binding.tvville.text = currentItem.name
        holder.binding.tvtemp.text = currentItem.type.toString()
        holder.binding.main.setOnClickListener {
            Toast.makeText(holder.binding.imageView.context, currentItem.name, Toast.LENGTH_LONG).show()
        }
    }

}