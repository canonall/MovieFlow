package com.canonal.movie.ui.favoriteMovie.adapter

import androidx.recyclerview.widget.RecyclerView
import com.canonal.movie.data.local.entity.FavoriteMovie
import com.canonal.movie.databinding.ItemFavoriteMovieBinding

class FavoriteMovieViewHolder(
    private val binding: ItemFavoriteMovieBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(favoriteMovie: FavoriteMovie) {
        binding.tvMovieTitle.text = favoriteMovie.name
    }
}