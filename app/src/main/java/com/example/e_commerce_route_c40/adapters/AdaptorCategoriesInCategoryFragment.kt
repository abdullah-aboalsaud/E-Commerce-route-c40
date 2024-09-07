package com.example.e_commerce_route_c40.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.api.categoryResponse.dataItemResponse.CategoryItemResponse
import com.example.e_commerce_route_c40.base.BaseAdapter
import com.example.e_commerce_route_c40.databinding.ItemCategoryInCategoriesBinding
import com.example.e_commerce_route_c40.ui.fragments.category.OnItemClickListener

class AdaptorCategoriesInCategoryFragment :
    BaseAdapter<CategoryItemResponse?, ItemCategoryInCategoriesBinding>() {

    private var selectedPosition = 0

    var onItemClickListener: OnItemClickListener? = null

    override fun getBinding(parent: ViewGroup, viewType: Int): ItemCategoryInCategoriesBinding =
        ItemCategoryInCategoriesBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

    override fun bindData(
        binding: ItemCategoryInCategoriesBinding,
        item: CategoryItemResponse?,
        position: Int
    ) {

        binding.tvItemCategoryInCategories.text = item?.name
        handleSelectedView(binding, position)

        binding.root.setOnClickListener {
            updateSelectedPosition(position)
            onItemClickListener?.onClick(position)
        }
    }


    private fun handleSelectedView(binding: ItemCategoryInCategoriesBinding, position: Int) {
        if (position == selectedPosition) {
            binding.selectedView.visibility = View.VISIBLE
            binding.root.setBackgroundResource(R.color.white)
            onItemClickListener?.onClick(position)
        } else {
            binding.selectedView.visibility = View.GONE
            binding.root.setBackgroundResource(R.color.transparent)
        }
    }

    private fun updateSelectedPosition(position: Int) {
        val previousPosition = selectedPosition
        selectedPosition = position
        notifyItemChanged(previousPosition)
        notifyItemChanged(selectedPosition)
    }
}
