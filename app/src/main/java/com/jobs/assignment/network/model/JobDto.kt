package com.jobs.assignment.network.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class JobDto(
    val availability: String? = null,
    val category: String? = null,
    val description: String? = null,
    val cost: String? = null,
    val id: String? = null,
    val images: List<String>? = null,
    val service: String? = null,
    val stickyDate: String? = null
): Parcelable