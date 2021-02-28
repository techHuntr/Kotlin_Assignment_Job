package com.jobs.assignment.domain.model
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
@Entity(
    tableName = "Job"
)
@Parcelize
data class Job(
    val availability: String? = null,
    val category: String? = null,
    val description: String? = null,
    val cost: String? = null,
    val id: String? = null,
    val images: List<String>? = null,
    val service: String? = null,
    val stickyDate: String? = null
): Parcelable{
    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = false)
    var jobId: Int = 0
}