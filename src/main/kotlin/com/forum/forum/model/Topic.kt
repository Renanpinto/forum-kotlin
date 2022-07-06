package com.forum.forum.model

import java.time.LocalDateTime

data class Topic(
    var id: Long? = null,
    val title: String,
    val message: String,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: UserForum,
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,
    val response: List<ResponseForum> = ArrayList()
)
