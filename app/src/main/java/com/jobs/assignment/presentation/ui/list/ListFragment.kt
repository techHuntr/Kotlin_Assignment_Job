package com.jobs.assignment.presentation.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.jobs.assignment.R
import com.jobs.assignment.domain.model.Job
import com.jobs.assignment.presentation.BaseApplication
import com.jobs.assignment.presentation.components.LoadingJobShimmer
import com.jobs.assignment.util.snack
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment : Fragment(), StateHandler {

    @Inject
    lateinit var application: BaseApplication

    private lateinit var toolBar: Toolbar

    private val viewModel: ListViewModel by viewModels()

    @ExperimentalCoroutinesApi
    @ExperimentalFoundationApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val jobs = viewModel.jobs.value
                val loading = viewModel.loading.value

                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        if (loading) {
                            LoadingJobShimmer(imageHeight = 250.dp)
                        } else {
                            LazyColumn {
                                val grouped = jobs.groupBy { it.stickyDate }

                                grouped.forEach { (initial, jobs) ->
                                    stickyHeader {
                                        Text(
                                            initial!!,
                                            Modifier
                                                .fillMaxWidth()
                                                .background(Color.White)
                                                .padding(8.dp),
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                    items(jobs) { job ->
                                        CardView(job = job, onClick = {
                                            val bundle = Bundle()
                                            bundle.putString("Id", job.id!!)
                                            findNavController().navigate(
                                                R.id.action_listFragment_to_itemFragment,
                                                bundle
                                            )
                                        })
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.stateHandler = this
        toolBar = requireActivity().findViewById(R.id.mainToolBar)
        toolBar.navigationIcon = null
        toolBar.title = getString(R.string.jobs)

        backCallBack()
    }

    private fun backCallBack() {

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this as LifecycleOwner, callback)
    }

    override fun onSuccess(job: Job) {
        TODO("since using lazy loading success callBack is not needed")
    }

    override fun onFailure() {
        requireView().snack(
            getString(R.string.error),
            R.string.ok,
            Snackbar.LENGTH_LONG,
            R.color.white,
            R.color.red
        ) {
            this.setAction(getString(R.string.ok)) {
                this.dismiss()
            }
        }
    }
}