package com.example.fasol

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

/*
    Main models
 */

data class Category(
    val id: Int,
    val name: String,
    val representation: String
)

data class Subcategory(
    val id: Int,
    val category: String,
    val name: String
)

data class PhonePasswordModel(
    val phone:String,
    val password:String
)

data class RegisterUserResponce(
    @SerializedName("user") var user : User,
    @SerializedName("message") var message : String
)

data class RefreshModel(
    @SerializedName("refresh") var refresh: String
)

@Serializable
data class TokenResponce (
    @SerializedName("refresh") var refresh : String,
    @SerializedName("access") var access : String
){
    fun toJson(): String {
        return Gson().toJson(this)
    }
}

/*
    Submodels
 */

data class UserWithoutId (
    @SerializedName("phone") var phone : String,
    @SerializedName("first_name") var firstName : String,
    @SerializedName("last_name") var lastName : String,
    @SerializedName("address") var address : String
)

@Serializable
data class User (

    @SerializedName("id") var id : Int,
    @SerializedName("phone") var phone : String,
    @SerializedName("first_name") var firstName : String,
    @SerializedName("last_name") var lastName : String,
    @SerializedName("address") var address : String
)
{
    fun toJson(): String {
        return Gson().toJson(this)
    }
}
