package com.forum.forum.model

import java.time.LocalDateTime

data class ResponseForum(
    val id: Long? = null,
    val message: String,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val author: UserForum,
    val topic: Topic,
    val ok: Boolean
)
