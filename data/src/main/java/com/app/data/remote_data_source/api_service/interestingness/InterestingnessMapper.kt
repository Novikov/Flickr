package com.app.data.remote_data_source.api_service.interestingness

import com.app.data.remote_data_source.api_service.interestingness.models.PhotoResponse
import com.app.data.remote_data_source.api_service.interestingness.models.PhotosResponse
import com.app.domain.models.interestingness.response.Photo
import com.app.domain.models.interestingness.response.Photos
import javax.inject.Inject

class InterestingnessMapper @Inject constructor() {
    private fun toPhoto(photoResponse: PhotoResponse): Photo = with(photoResponse) {
        return Photo(
            id = id,
            owner = owner,
            secret = secret,
            server = server,
            farm = farm,
            title = title,
            ispublic = ispublic,
            isfriend = isfriend,
            isfamily = isfamily
        )
    }

    fun toPhotos(photosResponse: PhotosResponse): Photos = with(photosResponse) {
        return Photos(
            page = page,
            pages = pages,
            perpage = perpage,
            total = total,
            photo = photo.map(::toPhoto)
        )
    }
}
