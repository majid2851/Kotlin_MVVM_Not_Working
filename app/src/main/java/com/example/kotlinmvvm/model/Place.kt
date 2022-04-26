package com.example.kotlinmvvm.model


import com.google.gson.annotations.SerializedName

data class Place(
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("place name")
    val placeName: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("state abbreviation")
    val stateAbbreviation: String
)