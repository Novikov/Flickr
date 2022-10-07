package com.app.flickr.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.flickr.R
import com.app.flickr.databinding.FragmentSearchBinding
import com.app.flickr.utils.ext.hideKeyboard
import com.app.flickr.utils.ext.onClick
import com.app.flickr.utils.view_helpers.OutsideTouchHelper

class SearchFragment : Fragment(R.layout.fragment_search) {

    private var viewBinding: FragmentSearchBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSearchBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        setOutsideTouchHelper()
    }

    private fun initListeners() {
        viewBinding?.backButton?.onClick {
            findNavController().navigateUp() // TODO: Igor think how to implement navigation
        }
    }

    private fun setOutsideTouchHelper() {
        viewBinding?.let { binding ->
            val outsideTouchHelper = OutsideTouchHelper
                .onViews(binding.flickrInputTextView)
                .whenOutside { hideKeyboard() }
            binding.coordinatorLayout.addOnDispatchTouchEventListener(outsideTouchHelper)
        }
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }
}
