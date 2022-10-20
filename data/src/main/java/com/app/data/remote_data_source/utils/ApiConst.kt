package com.app.data.remote_data_source.utils

object ApiConst {
    const val CONSUMER_KEY = "b06556858b6a7cefb7363e0deaaac1cd"
    const val CONSUMER_SECRET = "0d09176efdfc301c"

    const val API_BODY =
        "&oauth_consumer_key=" + CONSUMER_KEY +
            "&oauth_signature_method=HMAC-SHA1" +
            "&oauth_version=1.0" +
            "&format=json" +
            "&nojsoncallback=1"

    const val INTERESTING_PHOTO_METHOD = "?method=flickr.interestingness.getList"
    const val PHOTO_SEARCH_METHOD = "?method=flickr.photos.search"

    const val PHOTO_LOAD_BASE_URL = "https://live.staticflickr.com/"
}
