package com.canonal.movie.ui.favoriteMovie.adapter

import androidx.recyclerview.widget.DiffUtil
import com.canonal.movie.data.local.entity.FavoriteMovie

class FavoriteMovieDiffUtil : DiffUtil.ItemCallback<FavoriteMovie>() {
    override fun areItemsTheSame(oldItem: FavoriteMovie, newItem: FavoriteMovie): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: FavoriteMovie, newItem: FavoriteMovie): Boolean =
        oldItem == newItem
}