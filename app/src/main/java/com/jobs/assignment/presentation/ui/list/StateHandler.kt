package com.jobs.assignment.presentation.ui.list

import com.jobs.assignment.domain.model.Job

interface StateHandler {
    fun onSuccess(job: Job)
    fun onFailure()
}