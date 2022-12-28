package com.app.domain.models.common

import com.app.domain.const.ModelConst.DATE
import com.app.domain.const.ModelConst.FIRST_PAGE
import com.app.domain.const.ModelConst.OAUTH_NONCE
import com.app.domain.const.ModelConst.OAUTH_SIGNATURE
import com.app.domain.const.ModelConst.OAUTH_TIMESTAMP
import com.app.domain.const.ModelConst.OAUTH_TOKEN
import com.app.domain.const.ModelConst.PER_PAGE

data class PhotoListFilter(
    val page: Int = FIRST_PAGE,
    val perPage: Int = PER_PAGE,
    val date: String = DATE,
    val oauthToken: String = OAUTH_TOKEN,
    val oauthTimestamp: String = OAUTH_TIMESTAMP,
    val oauthNonce: String = OAUTH_NONCE,
    val oauthSignature: String = OAUTH_SIGNATURE,
    val isLastPage: Boolean = false
)
