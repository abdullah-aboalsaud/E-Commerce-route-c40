package com.fady.myapplicationss.api

//import com.example.e_commerce_route_c40.ApiManger.responses.CategoryResponse.CategoryItemResponse
import com.example.e_commerce_route_c40.api.categoryResponse.dataItemResponse.CategoryItemResponse
import com.example.e_commerce_route_c40.api.categoryResponse.dataItemResponse.SubCategory
import com.fady.myapplicationss.api.categoryResponse.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.Objects

interface ServiceCategories {

    @GET("/api/v1/categories")
    fun getAllCategories(): Call<Response<CategoryItemResponse?>?>

    @GET("/api/v1/categories/{_id}")
    fun getSpecificCategory(@Path("_id") categoryId: String): Call<Response<CategoryItemResponse>>


    @GET("/api/v1/subcategories")
    fun getAllSubCategories(): Call<Response<Objects>>

    @GET("/api/v1/categories/{_id}/subcategories")
    fun getAllSubCategoriesOnCategory(@Path("_id") categoryId: String): Call<Response<SubCategory?>?>

    @GET("/api/v1/subcategories/{_id}")
    fun getSpecificSubCategory(@Path("_id") subcategoryId: String): Call<Response<Objects>>


}