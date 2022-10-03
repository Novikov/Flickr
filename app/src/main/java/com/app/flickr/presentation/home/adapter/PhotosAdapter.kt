package com.app.flickr.presentation.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.app.flickr.presentation.home.model.PhotoDataUI

class PhotosAdapter : ListAdapter<PhotoDataUI, PhotosViewHolder>(PhotosDiffUtilsCallback()) {

    private val photoList = mutableListOf<PhotoDataUI>()

    fun setItems(photos: List<PhotoDataUI>) {
        photoList.clear()
        photoList.addAll(photos)
        submitList(photoList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        return PhotosViewHolder.onCreate(parent)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val photoItem = photoList[position]
        holder.bind(photoItem)
    }
}
