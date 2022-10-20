package com.app.data.remote_data_source.utils

import java.net.URI

interface Endpoint {
    val title: String
    val url: URI
}

object Endpoints {
    val DEV: Endpoint =
        EndpointImpl(
            title = "Dev",
            url = URI.create("https://www.flickr.com/")
        )
}

private data class EndpointImpl(
    override val title: String,
    override val url: URI
) : Endpoint
