package com.example.android.architecture.blueprints.todoapp.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.data.Task

class TasksPage : Page() {
    override fun verify(): Page {
        onView(withId(R.id.tasks_container_layout))
            .check(matches(isDisplayed()))
        return this
    }

    fun tapOnAddButton(): TasksPage {
        onView(withId(R.id.add_task_fab)).perform(ViewActions.click())
        return this
    }


    fun tapOnEditTask(): TasksPage {
        onView(withId(R.id.edit_task_fab)).perform(ViewActions.click())
        return this
    }

    fun checkAddedTask(testTask: Task): TasksPage {
        onView(withText(testTask.title))
        return this
    }
}