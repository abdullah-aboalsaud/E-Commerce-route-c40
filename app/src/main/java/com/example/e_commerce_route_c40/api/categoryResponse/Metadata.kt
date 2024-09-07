package com.fady.myapplicationss.api.categoryResponse

import com.google.gson.annotations.SerializedName

data class Metadata(

    @field:SerializedName("numberOfPages")
    val numberOfPages: Int? = null,

    @field:SerializedName("limit")
    val limit: Int? = null,

    @field:SerializedName("currentPage")
    val currentPage: Int? = null
)