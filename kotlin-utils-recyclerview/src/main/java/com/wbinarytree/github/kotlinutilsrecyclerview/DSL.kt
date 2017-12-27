package com.wbinarytree.github.kotlinutilsrecyclerview

import android.support.annotation.LayoutRes

/**
 * Created by yaoda on 12/27/17.
 */

@DslMarker
annotation class ViewModelDsl

@ViewModelDsl
class ViewModelBuilder<T> {
    var type: Int = -1
    @LayoutRes
    var resId: Int = 0
    var data: T? = null
    var bind: InnerHolder.(position: Int, data: T) -> Unit = { _, _ -> }

    fun build(): ViewModel<T>? {
        data?.let {
            return ViewModel(type, resId, it, bind)
        } ?: kotlin.run {
            return null
        }
    }
}

@ViewModelDsl
class ViewModelList : ArrayList<ViewModel<*>>()

@ViewModelDsl
inline fun viewModelList(init: ViewModelList.() -> Unit): ViewModelList {
    val viewModelList = ViewModelList()
    viewModelList.init()
    return viewModelList
}

inline fun <T> ViewModelList.viewModel(init: ViewModelBuilder<T>.() -> Unit) {
    val viewModelBuilder = ViewModelBuilder<T>()
    viewModelBuilder.init()
    val element = viewModelBuilder.build()
    if (element != null) {
        this.add(element)
    }
}