package com.example.e_commerce_route_c40.ui.fragments.product

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseFragment
import com.example.e_commerce_route_c40.databinding.FragmentProductBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ProductsFragment : BaseFragment<FragmentProductBinding, ProductViewModel>() {

    private val _viewModel: ProductViewModel by viewModels()

    @Inject
    lateinit var productsAdaptor: ProductsAdaptor

    override fun initViewModel()    : ProductViewModel = _viewModel

    override fun getLayoutId()      : Int = R.layout.fragment_product

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeLivedata()
        viewModel.getProducts()
    }

    private fun observeLivedata() {
        viewModel.productsLiveData.observe(viewLifecycleOwner) { products ->
            if (products != null) {
                productsAdaptor.changeData(products)
            }
        }
    }

    private fun initViews() {
        binding.rvProduct.adapter = productsAdaptor
    }


}