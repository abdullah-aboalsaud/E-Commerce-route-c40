package com.example.e_commerce_route_c40.api.categoryResponse.dataItemResponse

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SubCategory(
    @field:SerializedName("category")
    val categoryId: String? = null
) : CategoryItemResponse(), Parcelable
