package com.app.flickr.presentation.home.mapper

import com.app.domain.models.galleries.response.Photo
import com.app.flickr.presentation.home.model.PhotoDataUI
import com.app.flickr.utils.const.IMAGE_THUMBNAIL_SUFFIX
import javax.inject.Inject

class PhotosUIMapper @Inject constructor() {

    fun toPhotoDataUI(photoResponse: Photo): PhotoDataUI = with(photoResponse) {
        return PhotoDataUI(
            photoId = id,
            serverId = server,
            secret = secret,
            size = IMAGE_THUMBNAIL_SUFFIX
        )
    }
}
