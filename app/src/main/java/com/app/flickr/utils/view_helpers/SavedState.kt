package com.umbrella.utils.utils.view_helpers

import android.os.Parcel
import android.os.Parcelable
import android.util.SparseArray
import android.view.View

class SavedState(superState: Parcelable?) : View.BaseSavedState(superState) {
    var childrenStates: SparseArray<Parcelable>? = null

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        childrenStates?.let {
            out.writeSparseArray(it)
        }
    }
}
