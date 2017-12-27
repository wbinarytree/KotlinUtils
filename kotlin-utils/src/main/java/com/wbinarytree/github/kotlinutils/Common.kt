package com.wbinarytree.github.kotlinutils

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by yaoda on 12/27/17.
 */
/**Safe cast a type to Another Type. And apply some action into it
 *  T.safeCast<R>{
 *      //You get your R type here
 *  }
 *
 */
inline fun <reified T> Any.safeCast(action: T.() -> Unit) {
    if (this is T) {
        this.action()
    }
}

inline fun <reified T> List<T>?.toNonNullList(): List<T> {
    return this ?: emptyList()
}

fun Disposable.addTo(disposable: CompositeDisposable) {
    disposable.add(this)
}