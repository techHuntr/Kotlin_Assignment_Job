package com.jobs.assignment.network.model

import com.jobs.assignment.domain.model.Job
import com.jobs.assignment.domain.util.DomainMapper

class JobDtoMapper : DomainMapper<JobDto, Job> {
    override fun mapToDomainModel(model: JobDto): Job {
        return Job(
            availability = model.availability,
            category = model.category,
            description = model.description,
            cost = model.cost,
            id = model.id,
            images = model.images,
            service = model.service,
            stickyDate = model.stickyDate
        )
    }

    override fun mapFromDomainModel(domainModel: Job): JobDto {
        return JobDto(
            availability = domainModel.availability,
            category = domainModel.category,
            description = domainModel.description,
            cost = domainModel.cost,
            id = domainModel.id,
            images = domainModel.images,
            service = domainModel.service,
            stickyDate = domainModel.stickyDate
        )
    }

    fun toDomainList(initial: List<JobDto>): List<Job> {
        return initial.map { mapToDomainModel(it) }
    }
}