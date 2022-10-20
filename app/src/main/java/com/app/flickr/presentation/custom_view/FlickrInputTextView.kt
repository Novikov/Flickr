package com.app.flickr.presentation.custom_view

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.util.SparseArray
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.app.flickr.R
import com.app.flickr.databinding.FlickrInputTextViewBinding
import com.app.flickr.utils.const.DEFAULT_STYLE_ATTRS
import com.app.flickr.utils.const.EMPTY_STRING
import com.app.flickr.utils.const.SINGLE_LINE_TEXT
import com.app.flickr.utils.ext.logErrorIfDebug
import com.app.flickr.utils.ext.onClick
import com.app.flickr.utils.ext.showKeyboard

class FlickrInputTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = DEFAULT_STYLE_ATTRS
) : FrameLayout(context, attrs, defStyleAttr) {
    private val binding =
        FlickrInputTextViewBinding.inflate(LayoutInflater.from(context), this, true)

    var hint
        get() = binding.input.hint.toString()
        set(value) {
            binding.input.hint = value
        }

    init {
        addDefaultTextChangedListener()
        addListeners()
        context.obtainStyledAttributes(attrs, R.styleable.FlickrInputTextView).apply {
            try {
                hint = getString(R.styleable.FlickrInputTextView_android_hint).orEmpty()
                binding.input.apply {
                    inputType = getInt(
                        R.styleable.FlickrInputTextView_android_inputType,
                        SINGLE_LINE_TEXT
                    )
                    maxLines =
                        getInt(
                            R.styleable.FlickrInputTextView_android_maxLines,
                            maxLines
                        )
                }
            } catch (throwable: Throwable) {
                logErrorIfDebug(throwable)
            } finally {
                recycle()
            }
        }
    }

    private fun addDefaultTextChangedListener() {
        binding.input.addTextChangedListener {
            binding.deleteTextButton.isVisible = it != null && it.isNotEmpty()
        }
    }

    private fun addListeners() {
        binding.deleteTextButton.onClick {
            binding.input.setText(EMPTY_STRING)
        }
    }

    fun addCustomTextAndFocusChangedListener(listener: ((String) -> Unit)? = null) =
        with(binding.input) {
            addTextChangedListener { listener?.invoke(it.toString()) }
        }

    override fun dispatchSaveInstanceState(container: SparseArray<Parcelable>) {
        dispatchFreezeSelfOnly(container)
    }

    override fun dispatchRestoreInstanceState(container: SparseArray<Parcelable>) {
        dispatchThawSelfOnly(container)
    }

    fun makeActive() {
        binding.input.requestFocus()
        binding.input.showKeyboard()
    }
}
