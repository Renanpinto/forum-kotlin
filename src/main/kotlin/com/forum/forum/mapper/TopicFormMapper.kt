package com.forum.forum.mapper

import com.forum.forum.dto.TopicForm
import com.forum.forum.model.Topic
import com.forum.forum.service.CourseService
import com.forum.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val course: CourseService,
    private val user: UserService
) : Mapper<TopicForm, Topic> {
    override fun map(topic: TopicForm): Topic {
        return Topic(
            title = topic.title,
            message = topic.message,
            course = course.findById(topic.courseId),
            author = user.findById(topic.authorId)
        )
    }
}