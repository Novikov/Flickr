package com.app.flickr.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.flickr.R
import com.app.flickr.databinding.FragmentLoginBinding
import com.app.flickr.utils.ext.appComponent
import com.app.flickr.utils.ext.onClick

class LoginFragment : Fragment(R.layout.fragment_login) {

    private var viewBinding: FragmentLoginBinding? = null

    private val viewModel: LoginViewModel by lazy {
        requireContext().appComponent.factory.create(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: Igor replace navigation
        viewBinding?.button?.onClick {
            findNavController().navigate(R.id.homeFragment)
        }
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }
}
