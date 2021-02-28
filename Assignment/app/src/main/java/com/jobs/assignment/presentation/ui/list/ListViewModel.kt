package com.jobs.assignment.presentation.ui.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jobs.assignment.domain.model.Job
import com.jobs.assignment.repository.JobRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ListViewModel @ViewModelInject constructor(
    private val jobRepository: JobRepository,
) : ViewModel() {
    val jobs: MutableState<List<Job>> = mutableStateOf(ArrayList())

    var stateHandler: StateHandler? = null

    val loading = mutableStateOf(false)

    init {
        getList()
    }

    private fun getList() {
        viewModelScope.launch {
            loading.value = true

            delay(500)
            try {
                val result = jobRepository.get()
                jobs.value = result
            } catch ( e: Exception ) {
                stateHandler!!.onFailure()
            }

            loading.value = false

        }
    }

}