package com.canonal.movie.ui.favoriteMovie

import androidx.fragment.app.viewModels
import com.canonal.movie.databinding.FragmentFavoriteMovieBinding
import com.canonal.movie.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteMovieFragment :
    BaseFragment<FragmentFavoriteMovieBinding>(FragmentFavoriteMovieBinding::inflate) {

    private val favoriteMovieViewModel: FavoriteMovieViewModel by viewModels()

    override fun initUi() {

    }


}