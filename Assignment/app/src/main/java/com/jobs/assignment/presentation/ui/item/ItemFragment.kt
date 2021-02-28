package com.jobs.assignment.presentation.ui.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.jobs.assignment.R
import com.jobs.assignment.domain.model.Job
import com.jobs.assignment.presentation.ui.list.StateHandler
import com.jobs.assignment.util.snack
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ItemFragment : Fragment(), StateHandler {

    private val viewModel: ItemViewModel by viewModels()

    private lateinit var bottomNavigationView: BottomNavigationView

    private lateinit var toolBar: Toolbar

    lateinit var imageView: SliderView
    lateinit var availability: TextView
    lateinit var description: TextView
    lateinit var category: TextView
    lateinit var cost: TextView
    lateinit var service: TextView
    lateinit var fabIcon: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.item_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.stateHandler = this

        viewModel.id = requireArguments().getString("Id")
        viewModel.getItem()

        bottomNavigationView = requireActivity().findViewById(R.id.bottomNavigation)
        bottomNavigationView.visibility = View.GONE

        imageView = requireView().findViewById(R.id.imageView)
        availability = requireView().findViewById(R.id.availableTxt)
        description = requireView().findViewById(R.id.descriptionTxt)
        category = requireView().findViewById(R.id.categoryTxt)
        cost = requireView().findViewById(R.id.PriceTxt)
        service = requireView().findViewById(R.id.serviceTxt)
        fabIcon = requireView().findViewById(R.id.floating_action_button)

        toolBar = requireActivity().findViewById(R.id.mainToolBar)
        toolBar.title = getString(R.string.jobDetail)
        toolBar.navigationIcon = ResourcesCompat.getDrawable(
            requireActivity().resources,
            R.drawable.ic_baseline_arrow_back_24,
            null
        )

        toolBar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_itemFragment_to_listFragment)
        }

        fabIcon.setOnClickListener {
            Toast.makeText(requireContext(), "Make reservation", Toast.LENGTH_SHORT).show()
        }

        backCallBack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bottomNavigationView.visibility = View.VISIBLE
    }

    private fun backCallBack() {

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.action_itemFragment_to_listFragment)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this as LifecycleOwner, callback)
    }

    override fun onSuccess(job: Job) {
        CoroutineScope(Main).launch {
            imageView.setIndicatorAnimation(IndicatorAnimationType.WORM)
            imageView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
            imageView.setSliderAdapter(
                ImageSliderAdapter(
                    requireContext(),
                    job.images as ArrayList<String>
                )
            )

            availability.text = "Available At ${job.availability}"
            category.text = job.category
            cost.text = job.cost
            service.text = job.service
            description.text = job.description
        }
    }

    override fun onFailure() {
        CoroutineScope(Main).launch {
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
}