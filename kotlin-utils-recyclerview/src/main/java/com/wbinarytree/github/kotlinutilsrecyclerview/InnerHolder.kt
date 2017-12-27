package com.wbinarytree.github.kotlinutilsrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.extensions.LayoutContainer

/**
 * View Holder of the [GenericAdapter] and [GenericMultiItemAdapter]
 * */
class InnerHolder(view: View?) : RecyclerView.ViewHolder(view), LayoutContainer {
    override val containerView: View? = view
}