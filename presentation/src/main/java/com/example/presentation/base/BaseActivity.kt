package com.example.sample.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.presentation.BR
import com.example.presentation.R
import com.example.sample.ext.repeatOnStarted
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes private val layoutResId: Int
) : AppCompatActivity() {

    protected lateinit var binding: B

    private val viewModelClass = ((javaClass.genericSuperclass as ParameterizedType?)
        ?.actualTypeArguments
        ?.get(1) as Class<VM>).kotlin

    protected open val viewModel by ViewModelLazy(
        viewModelClass,
        { viewModelStore },
        { defaultViewModelProviderFactory },
        { defaultViewModelCreationExtras },
    )

    private val loadingDialog by lazy {
        AppCompatDialog(this).apply {
            setContentView(R.layout.dialog_progress)
            setCancelable(false)
            window?.setDimAmount(0.2f)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.e("onCreate BaseActivity")
        setupUi()
        setupObserve()
        setupObserver()
    }

    private fun setupUi() {
        binding = DataBindingUtil.setContentView(this, layoutResId)
        with(binding) {
            setVariable(BR.vm, viewModel)
            lifecycleOwner = this@BaseActivity
        }
    }

    private fun setupObserve() {
        repeatOnStarted {
            viewModel.baseEventFlow.collect {
                handleEvent(it)
            }
        }
    }

    private fun handleEvent(event: BaseViewModel.Event) {
        when(event) {
            is BaseViewModel.Event.ShowToast -> Toast.makeText(
                this,
                event.message,
                Toast.LENGTH_LONG
            )

            is BaseViewModel.Event.ShowToastRes -> Toast.makeText(
                this,
                getString(event.message),
                Toast.LENGTH_LONG
            )

            is BaseViewModel.Event.ShowLoading -> loadingDialog.show()
            is BaseViewModel.Event.HideLoading -> loadingDialog.dismiss()
        }
    }

    abstract fun setupObserver()

}