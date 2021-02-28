package com.jobs.assignment.repository

import com.jobs.assignment.domain.db.entities.JobDao
import com.jobs.assignment.domain.model.Job
import com.jobs.assignment.network.RetrofitService
import com.jobs.assignment.network.model.JobDtoMapper

class JobRepositoryImpl(
    private val retrofitService: RetrofitService,
    jobDao: JobDao,
    private val mapper: JobDtoMapper
) : JobRepository {
    override suspend fun get(): List<Job> {
        return mapper.toDomainList(retrofitService.get())
    }

    override suspend fun getItem(id: String): Job {
        return mapper.mapToDomainModel(retrofitService.getItem(id = id))
    }
}