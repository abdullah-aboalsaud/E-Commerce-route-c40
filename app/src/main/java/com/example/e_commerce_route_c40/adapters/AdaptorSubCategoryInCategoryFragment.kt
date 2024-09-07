package com.example.e_commerce_route_c40.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.api.categoryResponse.dataItemResponse.SubCategory
import com.example.e_commerce_route_c40.base.BaseAdapter
import com.example.e_commerce_route_c40.databinding.ItemSubCategoryInCategoriesBinding
import com.example.e_commerce_route_c40.ui.fragments.category.OnItemClickListener

class AdaptorSubCategoryInCategoryFragment :
    BaseAdapter<SubCategory?, ItemSubCategoryInCategoriesBinding>() {

    var onItemClickListener: OnItemClickListener? = null

    override fun getBinding(parent: ViewGroup, viewType: Int): ItemSubCategoryInCategoriesBinding =
        ItemSubCategoryInCategoriesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

    override fun bindData(
        binding: ItemSubCategoryInCategoriesBinding,
        item: SubCategory?,
        position: Int
    ) {
        binding.apply {
            irvSubCategoryCardImg.setImageResource(R.drawable.ic_launcher_foreground)
            irvSubCategoryTxt.text = item?.name
            root.setOnClickListener {
                onItemClickListener?.onClick(position)
            }
        }
    }
}
