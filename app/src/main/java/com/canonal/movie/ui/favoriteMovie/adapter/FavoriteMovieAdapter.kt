package com.canonal.movie.ui.favoriteMovie.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.canonal.movie.data.local.entity.FavoriteMovie
import com.canonal.movie.databinding.ItemFavoriteMovieBinding

class FavoriteMovieAdapter :
    ListAdapter<FavoriteMovie, FavoriteMovieViewHolder>(FavoriteMovieDiffUtil()) {

    private lateinit var binding: ItemFavoriteMovieBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieViewHolder {
        binding =
            ItemFavoriteMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteMovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteMovieViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}