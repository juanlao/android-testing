package com.example.android.architecture.blueprints.todoapp.pages

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.data.Task

class AddTaskPage: Page() {
    override fun verify(): AddTaskPage {
        Espresso.onView(withId(R.id.add_task_title_edit_text))
            .check(ViewAssertions.matches(isDisplayed()))
        return this
    }

    fun addTask(task: Task):AddTaskPage{
        onView(withId(R.id.add_task_title_edit_text))
            .perform(clearText(), typeText(task.title))
        onView(withId(R.id.add_task_description_edit_text))
            .perform(clearText(), typeText(task.description))
        onView(withId(R.id.save_task_fab)).perform(click())
        return this
    }
}