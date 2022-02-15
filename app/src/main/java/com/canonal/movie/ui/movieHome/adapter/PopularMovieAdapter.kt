package com.canonal.movie.ui.movieHome.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canonal.movie.databinding.ItemPopularMovieBinding
import com.canonal.movie.model.Movie

class PopularMovieAdapter(
    private val movieList: List<Movie>

) : RecyclerView.Adapter<PopularMovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        val binding =
            ItemPopularMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularMovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size
}