package com.app.flickr.presentation.search.model

import com.app.flickr.presentation.base.UIContent

data class PhotoSearchDataUI(
    val photoId: String,
    val serverId: String,
    val secret: String,
    val size: String
) : UIContent
