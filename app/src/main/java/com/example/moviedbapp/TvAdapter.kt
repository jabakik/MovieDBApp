package com.example.moviedbapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedbapp.databinding.LayoutSerialItemsBinding
import com.example.moviedbapp.models.TvItem

class TvAdapter: RecyclerView.Adapter<TvAdapter.TvViewHolder>() {
    private val tvItems = mutableListOf<TvItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val binding =
            LayoutSerialItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvViewHolder(binding)
    }
    fun updateAll(tv:List<TvItem>){
        tvItems.addAll(tv)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val tvItem = tvItems[position]
        tvItem.apply {
            holder.binding.movTitle.text = originalName
            holder.binding.movRelDate.text = firstAirDate
            holder.binding.movRating.text = voteAverage.toString()
            val posterUrl ="$IMAGE_PATH$posterPath"
            Glide.with(holder.binding.root.context).load(posterUrl)
                .into(holder.binding.movPoster)
        }
    }
    companion object {
        const val IMAGE_PATH = "https://image.tmdb.org/t/p/w500"

    }


    override fun getItemCount(): Int {
        return tvItems.size
    }

    class TvViewHolder(val binding: LayoutSerialItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}
