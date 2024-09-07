package com.fady.myapplicationss.api.categoryResponse

import com.google.gson.annotations.SerializedName

import kotlinx.parcelize.RawValue


data class Response<T>(

    @field:SerializedName("metadata")
    val metadata: Metadata? = null,

    @field:SerializedName("data")
    val data: @RawValue MutableList<T?>? = null,

    @field:SerializedName("results")
    val results: Int? = null
)