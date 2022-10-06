package com.app.flickr.utils.ext

import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment

fun Fragment.showKeyboard(view: View) {
    ContextCompat
        .getSystemService(this.requireContext(), InputMethodManager::class.java)
        ?.toggleSoftInput(InputMethodManager.SHOW_FORCED, EMPTY_FLAGS)
}

fun Fragment.hideKeyboard() {
    ContextCompat
        .getSystemService(this.requireContext(), InputMethodManager::class.java)
        ?.hideSoftInputFromWindow(this.view?.windowToken, EMPTY_FLAGS)
}

fun View.showKeyboard() {
    val inputMethodManager = getSystemService(this.context, InputMethodManager::class.java)
    inputMethodManager?.showSoftInput(this, InputMethodManager.SHOW_FORCED)
}

fun View.hideKeyboard() {
    val inputMethodManager = getSystemService(this.context, InputMethodManager::class.java)
    inputMethodManager?.hideSoftInputFromWindow(this.windowToken, EMPTY_FLAGS)
}

private const val EMPTY_FLAGS = 0
