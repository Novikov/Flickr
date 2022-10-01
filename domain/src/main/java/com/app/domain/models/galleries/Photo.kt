package com.app.domain.models.galleries

data class Photo(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Long,
    val title: String,
    val ispublic: Long,
    val isfriend: Long,
    val isfamily: Long,
    val ownername: String,
    val realname: String? = null,
    val iconserver: String,
    val iconfarm: Long,
    val countFaves: String,
    val countComments: String
)
