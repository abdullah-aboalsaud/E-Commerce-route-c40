package com.example.e_commerce_route_c40.ui.fragments.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_commerce_route_c40.api.ApiModule
import com.example.e_commerce_route_c40.api.categoryResponse.dataItemResponse.CategoryItemResponse
import com.example.e_commerce_route_c40.api.categoryResponse.dataItemResponse.SubCategory
import com.fady.myapplicationss.api.categoryResponse.Response
import retrofit2.Call
import retrofit2.Callback

class ViewModelFragmentCategory : ViewModel() {
    var categoriesLiveData = MutableLiveData<MutableList<CategoryItemResponse?>?>()

    var subCategoriesLiveData = MutableLiveData<MutableList<SubCategory?>?>()

    fun getCategories() {
        ApiModule
            .getCategoryService()
            .getAllCategories()
            .enqueue(object : Callback<Response<CategoryItemResponse?>?> {
                override fun onResponse(
                    p0: Call<Response<CategoryItemResponse?>?>,
                    p1: retrofit2.Response<Response<CategoryItemResponse?>?>
                ) {
                    if (p1.isSuccessful)
                        categoriesLiveData.value = p1.body()?.data ?: mutableListOf()
                }

                override fun onFailure(p0: Call<Response<CategoryItemResponse?>?>, p1: Throwable) {
                    return
                }
            })
    }

    fun getSubCategoriesOnCategory(id: String) {
        ApiModule
            .getCategoryService()
            .getAllSubCategoriesOnCategory(id)
            .enqueue(object : Callback<Response<SubCategory?>?> {
                override fun onResponse(
                    p0: Call<Response<SubCategory?>?>,
                    p1: retrofit2.Response<Response<SubCategory?>?>
                ) {
                    if (p1.isSuccessful)
                        subCategoriesLiveData.value = p1.body()?.data ?: mutableListOf()
                }

                override fun onFailure(p0: Call<Response<SubCategory?>?>, p1: Throwable) {
                    return
                }
            })
    }
}
