package com.forum.forum.service

import com.forum.forum.dto.TopicForm
import com.forum.forum.dto.TopicView
import com.forum.forum.dto.UpdateTopicForm
import com.forum.forum.exception.NotFoundException
import com.forum.forum.mapper.TopicFormMapper
import com.forum.forum.mapper.TopicViewMapper
import com.forum.forum.model.Course
import com.forum.forum.model.Topic
import com.forum.forum.model.UserForum
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic>,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {

    init {
        val topic1 = Topic(
            id = 1,
            title = "titulo",
            message = "message",
            course = Course(
                id = 1,
                name = "Nome",
                category = "Categoria"
            ),
            author = UserForum(
                id = 1,
                name = "Nome",
                email = "email"
            )
        )

        val topic2 = Topic(
            id = 2,
            title = "titulo",
            message = "message",
            course = Course(
                id = 1,
                name = "Nome",
                category = "Categoria"
            ),
            author = UserForum(
                id = 1,
                name = "Nome",
                email = "email"
            )
        )

        val topic3 = Topic(
            id = 3,
            title = "titulo",
            message = "message",
            course = Course(
                id = 1,
                name = "Nome",
                category = "Categoria"
            ),
            author = UserForum(
                id = 1,
                name = "Nome",
                email = "email"
            )
        )
        topics = listOf(topic1, topic2, topic3)
    }

    fun list(): List<TopicView> {
        return topics.stream().map { topic ->
            topicViewMapper.map(topic)
        }.collect(Collectors.toList());
    }

    fun findById(id: Long): TopicView {
        val topic = topics.stream().filter { topic -> topic.id == id }.findFirst()
            .orElseThrow { NotFoundException("not found") }
        return topicViewMapper.map(topic)
    }

    fun create(topicForm: TopicForm): TopicView {
        val topic = topicFormMapper.map(topicForm)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun update(form: UpdateTopicForm): TopicView {
        val oldTopic = topics.first { topic -> topic.id == form.id }
        val topic = Topic(
            id = oldTopic.id,
            title = form.title,
            author = oldTopic.author,
            message = form.message,
            course = oldTopic.course,
            response = oldTopic.response,
            status = oldTopic.status,
            createdDate = oldTopic.createdDate
        )
        topics.minus(oldTopic).plus(topic)
        return topicViewMapper.map(topic)
    }

    fun delete(id: Long) {
        topics.minus(
            topics.stream().filter { topic -> topic.id == id }.findFirst()
                .orElseThrow { NotFoundException("not found") }
        )
    }
}
