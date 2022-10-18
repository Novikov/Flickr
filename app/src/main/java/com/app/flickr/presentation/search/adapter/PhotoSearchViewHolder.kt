package com.app.flickr.presentation.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.flickr.databinding.PhotoListItemBinding
import com.app.flickr.presentation.home.model.PhotoDataUI
import com.app.flickr.utils.view_helpers.PhotoUrlBuilder
import com.bumptech.glide.Glide

class PhotoSearchViewHolder(val binding: PhotoListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun onCreate(
            parent: ViewGroup
        ): PhotoSearchViewHolder {
            return PhotoSearchViewHolder(
                PhotoListItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    fun bind(photoDataUI: PhotoDataUI) {
        val photoUrl = PhotoUrlBuilder.buildPhotoUrl(
            photoDataUI.serverId,
            photoDataUI.photoId,
            photoDataUI.secret
        )

        Glide.with(binding.root.context)
            .load(photoUrl)
            .centerCrop()
            .into(binding.photo)
    }
}
