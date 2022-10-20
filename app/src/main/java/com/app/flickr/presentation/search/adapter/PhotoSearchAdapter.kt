package com.app.flickr.presentation.search.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.app.flickr.presentation.home.model.PhotoDataUI

class PhotoSearchAdapter :
    ListAdapter<PhotoDataUI, PhotoSearchViewHolder>(PhotoSearchDiffUtilsCallback()) {

    private val photoList = mutableListOf<PhotoDataUI>()

    fun setItems(photos: List<PhotoDataUI>) {
        photoList.clear()
        photoList.addAll(photos)
        submitList(photos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoSearchViewHolder {
        return PhotoSearchViewHolder.onCreate(parent)
    }

    override fun onBindViewHolder(holder: PhotoSearchViewHolder, position: Int) {
        val photoItem = photoList[position]
        holder.bind(photoItem)
    }
}
