package com.app.flickr.presentation.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.app.flickr.R
import com.app.flickr.databinding.FragmentLoginBinding
import com.app.flickr.utils.appComponent
import com.app.flickr.utils.ext.onClick
import javax.inject.Inject

class LoginFragment : Fragment(R.layout.fragment_login) {

    @Inject
    lateinit var loginViewModelFactory: LoginViewModel.Factory.NestedFactory

    private var viewBinding: FragmentLoginBinding? = null

    private val viewModel: LoginViewModel by viewModels {
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
        viewBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding?.button?.onClick {
            viewModel.getRequestToken()
        }
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }
}
