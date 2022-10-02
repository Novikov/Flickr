package com.app.data.remote_data_source.mappers

import com.app.data.remote_data_source.api_service.galleries.models.PhotoResponse
import com.app.data.remote_data_source.api_service.galleries.models.PhotosResponse
import com.app.domain.models.galleries.response.Photo
import com.app.domain.models.galleries.response.Photos
import javax.inject.Inject

class GalleriesMapper @Inject constructor() {
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
            isfamily = isfamily,
            ownername = ownername,
            realname = realname,
            iconserver = iconserver,
            iconfarm = iconfarm,
            countFaves = countFaves,
            countComments = countComments
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
