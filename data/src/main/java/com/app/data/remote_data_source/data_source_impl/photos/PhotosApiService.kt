package com.app.data.remote_data_source.data_source_impl.photos

import com.app.data.remote_data_source.data_source_impl.photos.models.PhotosSearchResponse
import com.app.data.remote_data_source.utils.ApiConst
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosApiService {
    @GET("/services/rest${ApiConst.PHOTO_SEARCH_METHOD}${ApiConst.API_BODY}")
    fun getPhotoSearch(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 100,
        @Query("text") query: String,
        @Query("date") date: String = "",
        @Query("oauth_token") oauthToken: String = "",
        @Query("oauth_timestamp") oauthTimestamp: String = "",
        @Query("oauth_nonce") oauthNonce: String = "",
        @Query("oauth_signature") oauthSignature: String = ""
    ): Single<PhotosSearchResponse>
}
