package com.example.githubusers.components

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.R

class RecyclerViewDecoration(ctx: Context) : RecyclerView.ItemDecoration() {
  private val space = ctx.resources.getDimensionPixelSize(R.dimen.s)

  override fun getItemOffsets(
    outRect: Rect,
    view: View,
    parent: RecyclerView,
    state: RecyclerView.State
  ) {
    outRect.top = space
    outRect.right = space
    outRect.bottom = space
    outRect.left = space
  }
}