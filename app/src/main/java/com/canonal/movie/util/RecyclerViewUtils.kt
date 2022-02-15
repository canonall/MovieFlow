package com.canonal.movie.util

import androidx.recyclerview.widget.RecyclerView

fun <T : RecyclerView.ViewHolder?> initializeRecyclerView(
    recyclerView: RecyclerView,
    adapter: RecyclerView.Adapter<T>,
    layoutManager: RecyclerView.LayoutManager,
    hasFixedSize: Boolean = false,
) {
    recyclerView.apply {
        this.adapter = adapter
        this.layoutManager = layoutManager
        this.setHasFixedSize(hasFixedSize)
    }
}