package com.canonal.movie.ui.movieHome.adapter

import androidx.recyclerview.widget.RecyclerView
import com.canonal.movie.databinding.ItemPopularMovieBinding
import com.canonal.movie.model.Movie

class PopularMovieViewHolder(
    private val binding: ItemPopularMovieBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        binding.tvMovieTitle.text = movie.title
    }
}