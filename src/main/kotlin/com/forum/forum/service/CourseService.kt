package com.forum.forum.service

import com.forum.forum.model.Course
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(var courses: List<Course>) {
    init {
        val course = Course(
            id = 1,
            name = "kotlin",
            category = "Category"
        )
        courses = Arrays.asList(course)
    }

    fun findById(courseId: Long): Course {
        return courses.first { course -> course.id == courseId }
    }
}
