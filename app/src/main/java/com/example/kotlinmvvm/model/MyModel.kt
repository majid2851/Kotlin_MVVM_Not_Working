package com.example.kotlinmvvm.model


import com.google.gson.annotations.SerializedName

data class MyModel(
    @SerializedName("country")
    val country: String,
    @SerializedName("country abbreviation")
    val countryAbbreviation: String,
    @SerializedName("places")
    val places: List<Place>,
    @SerializedName("post code")
    val postCode: String
)