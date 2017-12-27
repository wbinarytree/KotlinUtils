package com.wbinarytree.github.kotlinutilsrecyclerview

import android.support.v7.widget.RecyclerView.Adapter
import android.util.SparseIntArray
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Generic Adapter that contain multi-type of layout resource indicated by [ViewModel]
 *
 * The view binding responsibility leave to the user of the adapter.
 * One of the benefits of this is that the Adapter itself don't need to have the knowledge of the context.
 * For example we add a listener to the item which open a detail fragment/activity
 * Normally you need pass the Activity/Fragment itself as an interface to capsule the action
 * But using this adapter you can just bind your view inside your activity via the lambda you passing in.
 * This adapter require the Android Extension to be enabled to use the cached view in ViewHolder.
 **
 *  @param list the item list
 **/
class GenericMultiItemAdapter<T>(val list: MutableList<ViewModel<T>>) : Adapter<InnerHolder>() {
    private val typeHolder = SparseIntArray()
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): InnerHolder {
        val itemView = LayoutInflater.from(parent?.context)?.inflate(typeHolder[viewType],
            parent,
            false)
        return InnerHolder(itemView)
    }

    override fun onBindViewHolder(holder: InnerHolder?, position: Int) {
        val item = list[position]
        if (holder != null) {
            item.bind(holder, position, item.data)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        val type = list[position].type
        if (typeHolder[type] == 0) {
            //register the resID for type
            typeHolder.put(type, list[position].resId)
        }
        return type
    }
}

