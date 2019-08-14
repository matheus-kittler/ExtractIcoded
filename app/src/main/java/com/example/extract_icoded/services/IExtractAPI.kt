package com.example.extract_icoded.services


import com.example.extract_icoded.model.Extract
import retrofit2.http.GET
import retrofit2.http.Query

interface IExtractAPI {

    @GET("api/extract.php")
    fun getExtract (@Query("pwd") pwd: String) : retrofit2.Call<Extract>
}