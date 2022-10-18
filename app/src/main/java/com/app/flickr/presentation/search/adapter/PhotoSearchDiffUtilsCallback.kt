package com.app.flickr.presentation.search.adapter

import androidx.recyclerview.widget.DiffUtil
import com.app.flickr.presentation.home.model.PhotoDataUI

class PhotoSearchDiffUtilsCallback : DiffUtil.ItemCallback<PhotoDataUI>() {
    override fun areItemsTheSame(oldItem: PhotoDataUI, newItem: PhotoDataUI): Boolean {
        return oldItem.photoId == newItem.photoId
    }

    override fun areContentsTheSame(oldItem: PhotoDataUI, newItem: PhotoDataUI): Boolean {
        return oldItem.photoId == newItem.photoId
    }
}
