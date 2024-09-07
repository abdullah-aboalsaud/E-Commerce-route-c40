package com.example.e_commerce_route_c40.ui.fragments.category

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.e_commerce_route_c40.adapters.AdaptorCategoriesInCategoryFragment
import com.example.e_commerce_route_c40.adapters.AdaptorSubCategoryInCategoryFragment
import com.example.e_commerce_route_c40.base.BaseFragment
import com.example.e_commerce_route_c40.databinding.FragmentCategoryBinding

class CategoryFragment : BaseFragment<FragmentCategoryBinding>() {

    // Adaptors
    private lateinit var rvCategoryAdaptor: AdaptorCategoriesInCategoryFragment
    private lateinit var rvSubCategoryAdaptor: AdaptorSubCategoryInCategoryFragment

    // ViewModel
    private lateinit var viewModelCategoryFragment: ViewModelFragmentCategory

    // Events
    private lateinit var onCategoryClickListener: OnItemClickListener
    private lateinit var onSubCategoryClickListener: OnItemClickListener

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCategoryBinding = FragmentCategoryBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initAdaptors()
        observeViewModelLifeData()
        initEvents()
        viewModelCategoryFragment.getCategories()

    }

    private fun initViewModel() {
        viewModelCategoryFragment =
            ViewModelProvider.create(this)[ViewModelFragmentCategory::class.java]
    }

    private fun initAdaptors() {
        rvCategoryAdaptor = AdaptorCategoriesInCategoryFragment()
        rvSubCategoryAdaptor = AdaptorSubCategoryInCategoryFragment()
        //
        binding.rvCategory.adapter = rvCategoryAdaptor
        binding.rvSubCategory.adapter = rvSubCategoryAdaptor
    }

    private fun initEvents() {
        onCategoryClickListener = OnItemClickListener { position ->
            binding.titleCategory.text = rvCategoryAdaptor.getItem(position)?.name

            binding.layoutImg.titleCategoryInCardView.text =
                rvCategoryAdaptor.getItem(position)?.name


            Glide.with(binding.layoutImg.imgCategoryInCardView)
                .load(rvCategoryAdaptor.getItem(position)?.image)
                .centerCrop()
                .into(binding.layoutImg.imgCategoryInCardView)
            rvCategoryAdaptor.getItem(position)?.image?.let { Log.e("im", it) }

//            rvCategoryAdaptor.getItem(position)?.id?.let {
//                Log.e("id",rvCategoryAdaptor.getItem(position)?.id.toString())
//                viewModelCategoryFragment.getSubCategoriesOnCategory(it)
//            }
        }

        rvCategoryAdaptor.onItemClickListener = onCategoryClickListener

//        onSubCategoryClickListener = OnItemClickListener { position ->
//            Log.e("onSubCategoryClickListener", position.toString())
    }
//        rvSubCategoryAdaptor.onItemClickListener = onSubCategoryClickListener
//    }

    private fun observeViewModelLifeData() {
        viewModelCategoryFragment.categoriesLiveData.observe(viewLifecycleOwner) { data ->
            if (data != null) rvCategoryAdaptor.summitList(data)
        }
//        viewModelCategoryFragment.subCategoriesLiveData.observe(viewLifecycleOwner) { data ->
//            if (!data.isNullOrEmpty()) rvSubCategoryAdaptor.summitList(data)
//        }
    }
}

