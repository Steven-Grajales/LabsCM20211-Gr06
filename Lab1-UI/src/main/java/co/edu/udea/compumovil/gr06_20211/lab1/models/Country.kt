package co.edu.udea.compumovil.gr06_20211.lab1.models

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("country") var country: String
)
