package com.example.fasol

import retrofit2.Call
import retrofit2.http.*

interface Api {
    @GET("api/categories/")
    fun getCategory(): Call<List<Category>>

    @GET("api/subcategories/")
    fun getSubcategories(): Call<List<Subcategory>>

    @kotlinx.serialization.ImplicitReflectionSerializer
    @POST("api/token/")
    @Headers("Content-Type: application/json")
    fun getToken(@Body body:PhonePasswordModel):Call<TokenResponce>

    @kotlinx.serialization.ImplicitReflectionSerializer
    @POST("api/account/register/")
    @Headers("Content-Type: application/json")
    fun registerUser(@Body body:PhonePasswordModel):Call<RegisterUserResponce>

    @PATCH("api/account/user/")
    @Headers("Content-Type: application/json")
    fun changeUsername(@Body body:UserWithoutId, @Header("Authorization") Authorization: String):Call<User>

    @PATCH("api/account/user/")
    @Headers("Content-Type: application/json")
    fun getUser(@Header("Authorization") Authorization: String):Call<User>

    @kotlinx.serialization.ImplicitReflectionSerializer
    @POST("api/token/refresh/")
    @Headers("Content-Type: application/json")
    fun updateAccessToken(@Body body:RefreshModel):Call<TokenResponce>
}