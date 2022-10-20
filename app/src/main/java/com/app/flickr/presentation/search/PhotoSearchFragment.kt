package com.app.flickr.presentation.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.app.data.remote_data_source.data_source_impl.base.Result
import com.app.flickr.R
import com.app.flickr.databinding.FragmentSearchBinding
import com.app.flickr.presentation.search.adapter.PhotoSearchAdapter
import com.app.flickr.presentation.search.model.FoundPhotosList
import com.app.flickr.utils.const.GRID_IMAGES_COUNT
import com.app.flickr.utils.ext.appComponent
import com.app.flickr.utils.ext.hideKeyboard
import com.app.flickr.utils.ext.onClick
import com.app.flickr.utils.ext.showKeyboard
import com.app.flickr.utils.view_helpers.OutsideTouchHelper
import javax.inject.Inject

class PhotoSearchFragment : Fragment(R.layout.fragment_search) {

    @Inject
    lateinit var photoSearchViewModelFactory: PhotoSearchViewModel.Factory.NestedFactory

    private val viewModel: PhotoSearchViewModel by viewModels {
        photoSearchViewModelFactory.create()
    }

    private var viewBinding: FragmentSearchBinding? = null

    private var photoSearchAdapter: PhotoSearchAdapter? = null

    override fun onAttach(context: Context) {
        requireContext().appComponent.inject(this)
        super.onAttach(context)
    }

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
        initAdapter()
        initRecycler()
        initSearchView()
        initListeners()
        setOutsideTouchHelper()
        setObservers()
    }

    private fun initAdapter() {
        photoSearchAdapter = PhotoSearchAdapter()
    }

    private fun initRecycler() {
        viewBinding?.foundPhotoRecycler?.layoutManager =
            GridLayoutManager(context, GRID_IMAGES_COUNT)
        viewBinding?.foundPhotoRecycler?.adapter = photoSearchAdapter
    }

    private fun initSearchView() {
        viewBinding?.flickrInputTextView?.makeActive()
//        showKeyboard()
    }

    private fun initListeners() {
        viewBinding?.backButton?.onClick {
            findNavController().navigateUp()
        }
        viewBinding?.flickrInputTextView?.addCustomTextAndFocusChangedListener { query ->
            viewModel.searchPhoto(query = query)
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

    private fun setObservers() {
        viewModel.photosLiveData.observe(viewLifecycleOwner) { content ->
            when (content) {
                is Result.Success<FoundPhotosList> -> {
                    photoSearchAdapter?.setItems(content.result.data)
                    viewBinding?.errorMessage?.visibility = View.GONE
                    viewBinding?.loader?.visibility = View.GONE
                }
                is Result.Error -> {
                    viewBinding?.loader?.visibility = View.GONE
                    viewBinding?.errorMessage?.visibility = View.VISIBLE
                }
                is Result.Loading -> {
                    viewBinding?.errorMessage?.visibility = View.GONE
                    viewBinding?.loader?.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }

    override fun onDestroy() {
        photoSearchAdapter = null
        super.onDestroy()
    }
}
