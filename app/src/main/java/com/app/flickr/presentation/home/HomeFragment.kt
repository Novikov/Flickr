package com.app.flickr.presentation.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.app.flickr.R
import com.app.flickr.databinding.FragmentHomeBinding
import com.app.flickr.presentation.home.adapter.PhotosAdapter
import com.app.flickr.utils.const.GRID_IMAGES_COUNT
import com.app.flickr.utils.ext.appComponent
import com.app.flickr.utils.pagination.RecyclerPagination
import javax.inject.Inject

class HomeFragment : Fragment(R.layout.fragment_home) {

    @Inject
    lateinit var photosAdapter: PhotosAdapter

    private var viewBinding: FragmentHomeBinding? = null

    private val viewModel: HomeViewModel by lazy {
        requireContext().appComponent.factory.create(HomeViewModel::class.java)
    }

    override fun onAttach(context: Context) {
        requireContext().appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getMostInterestingPhotoList()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        initListeners()
        setObservers()
    }

    private fun initRecycler() {
        viewBinding?.photoRecycler?.layoutManager = GridLayoutManager(context, GRID_IMAGES_COUNT)
        viewBinding?.photoRecycler?.adapter = photosAdapter
    }

    private fun initListeners() {
        viewBinding?.toolbar?.root?.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_search -> {
                    // TODO: Igor think how to add basic navigation cases
                    findNavController().navigate(R.id.searchFragment)
                    true
                }
                else -> {
                    Toast.makeText(requireContext(), "saved photos", Toast.LENGTH_SHORT).show()
                    false
                }
            }
        }
    }

    private fun setObservers() {
        viewModel.photosLiveData.observe(viewLifecycleOwner) { content ->
            photosAdapter.setItems(content)
            addPaginationListener()
        }
    }

    private fun addPaginationListener() {
        RecyclerPagination.scroll(
            viewBinding?.photoRecycler,
            viewModel::getMostInterestingPhotoList
        )
    }

    override fun onDestroyView() {
        viewBinding = null
        RecyclerPagination.removeListener()
        super.onDestroyView()
    }
}
