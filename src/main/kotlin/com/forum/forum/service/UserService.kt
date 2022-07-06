package com.forum.forum.service

import com.forum.forum.model.UserForum
import org.springframework.stereotype.Service

@Service
class UserService(var users: List<UserForum>) {
    init {
        val userForum = UserForum(
            id = 1,
            name = "Renan",
            email = "email"
        )
        users = listOf(userForum)
    }

    fun findById(courseId: Long): UserForum {
        return users.first { userForum -> userForum.id == courseId }
    }
}
