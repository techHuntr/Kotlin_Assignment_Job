package com.jobs.assignment.repository

import com.jobs.assignment.domain.model.Job

interface JobRepository {
    suspend fun get(): List<Job>
    suspend fun getItem(id: String): Job
}