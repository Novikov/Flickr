package com.app.data.remote_data_source.data_source_impl.interestingness

import com.app.data.remote_data_source.data_source_impl.interestingness.models.PhotoResponse
import com.app.data.remote_data_source.data_source_impl.interestingness.models.PhotosResponse
import com.app.domain.models.interestingness.response.Photo
import com.app.domain.models.interestingness.response.Photos
import javax.inject.Inject

class InterestingnessMapper @Inject constructor() {
    private fun toPhoto(photoResponse: PhotoResponse): Photo = with(photoResponse) {
        return Photo(
            id = id,
            owner = owner,
            title = title,
            secret = secret,
            server = server
        )
    }

    fun toPhotos(photosResponse: PhotosResponse): Photos = with(photosResponse) {
        return Photos(
            page = page.toInt(),
            pages = pages.toInt(),
            perpage = perpage.toInt(),
            total = total.toInt(),
            photo = photo.map(::toPhoto)
        )
    }
}
