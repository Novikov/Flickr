package com.app.flickr.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.app.flickr.databinding.PhotoListItemBinding
import com.app.flickr.presentation.home.HomeFragmentDirections
import com.app.flickr.presentation.home.model.PhotoDataUI
import com.app.flickr.utils.ext.onClick
import com.app.flickr.utils.view_helpers.PhotoUrlBuilder
import com.bumptech.glide.Glide

class PhotosViewHolder(val binding: PhotoListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun onCreate(
            parent: ViewGroup
        ): PhotosViewHolder {
            return PhotosViewHolder(
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
        binding.root.onClick {
            val directions =
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(photoDataUI.photoId)
            Navigation.findNavController(binding.root).navigate(directions)
        }
    }
}
