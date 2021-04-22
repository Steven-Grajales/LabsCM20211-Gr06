package co.edu.udea.compumovil.gr06_20211.lab1.models

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("error") var error: String,
    @SerializedName("msg") var msg: String,
    @SerializedName("data") var citiesList: List<String>
)