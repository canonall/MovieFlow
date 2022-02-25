package com.canonal.movie.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

fun <T : RecyclerView.ViewHolder?> initializeRecyclerView(
    recyclerView: RecyclerView,
    adapter: RecyclerView.Adapter<T>,
    layoutManager: RecyclerView.LayoutManager,
    topSpace: Int = 10,
    bottomSpace: Int = 10,
    hasFixedSize: Boolean = false
) {
    recyclerView.apply {
        this.adapter = adapter
        this.layoutManager = layoutManager
        setHasFixedSize(hasFixedSize)
        addItemDecoration(getItemDecoration(topSpace, bottomSpace))
    }
}

//You can give different spaces for top, bottom and in between elements
private fun getItemDecoration(topSpace: Int, bottomSpace: Int): RecyclerView.ItemDecoration =
    object : RecyclerView.ItemDecoration() {
        val topItemCustomSpace = 10
        val bottomItemCustomSpace = 10
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.apply {
                when {
                    //top item
                    parent.getChildAdapterPosition(view) == 0 -> {
                        top = topItemCustomSpace
                        bottom = bottomSpace

                    }
                    //bottom item
                    parent.getChildAdapterPosition(view) == parent.adapter?.itemCount?.minus(1) -> {
                        top = topSpace
                        bottom = bottomItemCustomSpace
                    }
                    //in between items
                    else -> {
                        top = topSpace
                        bottom = bottomSpace
                    }
                }
            }
        }
    }

