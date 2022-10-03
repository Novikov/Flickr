package com.app.flickr.presentation.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.app.flickr.presentation.home.model.PhotoDataUI

class PhotosDiffUtilsCallback : DiffUtil.ItemCallback<PhotoDataUI>() {
    override fun areItemsTheSame(oldItem: PhotoDataUI, newItem: PhotoDataUI): Boolean {
        return oldItem.photoId == newItem.photoId
    }

    override fun areContentsTheSame(oldItem: PhotoDataUI, newItem: PhotoDataUI): Boolean {
        return oldItem.photoId == newItem.photoId
    }
}
