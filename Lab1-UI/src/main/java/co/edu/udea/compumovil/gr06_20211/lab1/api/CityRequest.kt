package co.edu.udea.compumovil.gr06_20211.lab1.api

import co.edu.udea.compumovil.gr06_20211.lab1.models.City
import co.edu.udea.compumovil.gr06_20211.lab1.models.Country
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface CityRequest {


    @POST("countries/cities")
    suspend fun getCities(@Body country:Country): Response<City>
}
