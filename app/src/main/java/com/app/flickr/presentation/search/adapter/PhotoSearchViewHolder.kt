package com.app.flickr.presentation.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.data.remote_data_source.utils.ApiConst.PHOTO_LOAD_BASE_URL
import com.app.data.remote_data_source.utils.NetworkConst.SLASH
import com.app.data.remote_data_source.utils.NetworkConst.UNDERSCORE
import com.app.flickr.databinding.PhotoListItemBinding
import com.app.flickr.presentation.home.model.PhotoDataUI
import com.app.flickr.utils.const.IMAGE_THUMBNAIL_SUFFIX
import com.app.flickr.utils.const.JPG_FORMAT
import com.bumptech.glide.Glide

class PhotoSearchViewHolder(val binding: PhotoListItemBinding) : RecyclerView.ViewHolder(binding.root) {

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
        // TODO: Igor think how to remove getting photoUrl from here
        val photoUrl =
            "$PHOTO_LOAD_BASE_URL${photoDataUI.serverId}$SLASH${photoDataUI.photoId}$UNDERSCORE${photoDataUI.secret}$UNDERSCORE$IMAGE_THUMBNAIL_SUFFIX$JPG_FORMAT"

        Glide.with(binding.root.context)
            .load(photoUrl)
            .centerCrop()
            .into(binding.photo)
    }
}
