package com.app.flickr.presentation.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.app.flickr.R
import com.app.flickr.databinding.FragmentDetailBinding
import com.app.flickr.presentation.detail.di.DetailViewModelAssistedFactory
import com.app.flickr.utils.ext.appComponent
import javax.inject.Inject

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var viewBinding: FragmentDetailBinding? = null

    val args: DetailFragmentArgs by navArgs()

    @Inject
    lateinit var assistedFactory: DetailViewModelAssistedFactory

    val viewModel: DetailViewModel by viewModels {
        DetailViewModel.Factory(assistedFactory, args.photoId)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }
}
