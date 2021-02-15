package com.jydev.pagingexample

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView
import com.jydev.pagingexample.util.dp


class ItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        outRect.set(0,0,0,10.dp)
    }
}