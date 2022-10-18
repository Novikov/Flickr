package com.app.flickr.utils.view_helpers

import com.app.data.remote_data_source.utils.ApiConst
import com.app.data.remote_data_source.utils.NetworkConst
import com.app.flickr.utils.const.IMAGE_THUMBNAIL_SUFFIX
import com.app.flickr.utils.const.JPG_FORMAT

object PhotoUrlBuilder {
    fun buildPhotoUrl(serverId: String, photoId: String, secret: String): String {
        return "${ApiConst.PHOTO_LOAD_BASE_URL}${serverId}${NetworkConst.SLASH}${photoId}${NetworkConst.UNDERSCORE}${secret}${NetworkConst.UNDERSCORE}$IMAGE_THUMBNAIL_SUFFIX$JPG_FORMAT"
    }
}
