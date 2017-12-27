package com.wbinarytree.github.kotlinutilsrecyclerview

import android.support.annotation.LayoutRes

/**
 * The ViewModel for [GenericMultiItemAdapter]. To indicate each item's layout resource file,
 * data and the bind action
 *
 * Notice that the type should be unique in the list or may produce a [NullPointerException] to the View you're using
 * @property type the type of ViewModel. an unique integer number
 *
 * @property resId the layout resource file
 *
 * @property data the data of the item
 *
 * @property bind the bind action of item
 * * */

data class ViewModel<T>(
    val type: Int,
    @LayoutRes
    val resId: Int,
    val data: T,
    inline val bind: InnerHolder.(position: Int, data: T) -> Unit
)