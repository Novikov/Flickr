package com.app.flickr.presentation.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.app.flickr.R
import com.app.flickr.databinding.FragmentHomeBinding
import com.app.flickr.utils.appComponent
import javax.inject.Inject

class HomeFragment : Fragment(R.layout.fragment_home) {
    @Inject
    lateinit var loginViewModelFactory: HomeViewModel.Factory.NestedFactory

    private var viewBinding: FragmentHomeBinding? = null

    private val viewModel: HomeViewModel by viewModels {
        loginViewModelFactory.create()
    }

    override fun onAttach(context: Context) {
        requireContext().appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }
}
