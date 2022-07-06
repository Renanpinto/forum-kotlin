package com.forum.forum.controller

import com.forum.forum.dto.TopicForm
import com.forum.forum.dto.TopicView
import com.forum.forum.dto.UpdateTopicForm
import com.forum.forum.service.TopicService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class ForumController(private val crud: TopicService) {


    @GetMapping
    fun findAll(): List<TopicView> {
        return crud.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicView {
        return crud.findById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid form: TopicForm): TopicView {
        return crud.create(form)
    }

    @PutMapping
    fun update(@RequestBody @Valid form: UpdateTopicForm): TopicView {
        return crud.update(form)
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        crud.delete(id)
    }
}