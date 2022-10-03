package com.app.flickr.presentation.home.model

import com.app.flickr.presentation.base.UIContent

data class PhotoDataUI(
    val photoId: String,
    val serverId: String,
    val secret: String,
    val size: String
) : UIContent
