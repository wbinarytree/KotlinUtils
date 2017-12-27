package com.wbinarytree.github.kotlinutilsrecyclerview

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Generic Adapter that contain a single Type of layout resource
 *
 * The view binding responsibility leave to the user of the adapter.
 * One of the benefits of this is that the Adapter itself don't need to have the knowledge of the context.
 * For example we add a listener to the item which open a detail fragment/activity
 * Normally you need pass the Activity/Fragment itself as an interface to capsule the action
 * But using this adapter you can just bind your view inside your activity via the lambda you passing in.
 * This adapter require the Android Extension to be enabled to use the cached view in ViewHolder.
 *
 *  @param layoutId the layout resource for item
 *
 *  @param list the item list
 *
 *  @param bind the bind function apply to each item
 */
class GenericAdapter<in T>(
    @LayoutRes private val layoutId: Int,
    private var list: List<T>,
    inline private val bind: InnerHolder.(T, Int) -> Unit) : RecyclerView.Adapter<InnerHolder>() {
    override fun onBindViewHolder(holder: InnerHolder?, position: Int) {
        holder?.bind(list[position], position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): InnerHolder {
        val view = LayoutInflater.from(parent?.context)?.inflate(layoutId, parent, false)
        return InnerHolder(view)
    }

    override fun getItemCount(): Int = list.size

    /**
     * update the list of adapter
     * @param notify indicate whether call the [notifyDataSetChanged] or not
     *
     * @param list  the new list for adapter
     * */
    fun update(list: List<T>, notify: Boolean = true) {
        this.list = list
        if (notify) {
            notifyDataSetChanged()
        }
    }

}