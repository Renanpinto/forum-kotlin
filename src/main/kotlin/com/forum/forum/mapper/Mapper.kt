package com.forum.forum.mapper

interface Mapper<T, U> {
    fun map(topic: T): U
}
