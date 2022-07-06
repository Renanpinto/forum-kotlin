package com.forum.forum.mapper

import com.forum.forum.dto.TopicView
import com.forum.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {
    override fun map(topic: Topic): TopicView {
        return TopicView(
            id = topic.id,
            title = topic.title,
            message = topic.message,
            creationDate = topic.createdDate,
            status = topic.status
        )
    }
}