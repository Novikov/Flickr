package com.app.data.network_const

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
}
