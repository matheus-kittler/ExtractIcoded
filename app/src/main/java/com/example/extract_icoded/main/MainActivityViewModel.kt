package com.example.extract_icoded.main

import com.example.extract_icoded.model.Extract
import com.example.extract_icoded.model.Login
import com.example.extract_icoded.services.IExtractAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityViewModel {

    lateinit var interaction: MainActivityInteraction

    constructor(interaction: MainActivityInteraction) {
        this.interaction = interaction
    }

    fun checkLogin(name: String, password: String) {
        if (name.isEmpty()) {
            interaction.onError("Nome está vazio!")
        } else if (password.isEmpty()) {
            interaction.onError("Senha está vazia!")
        } else if (name != "Matheus" && password != "123456") {
            interaction.onError("Login inválido!")
        } else {
            interaction.onLoginSuccess(Login(name, password))
        }
    }

    fun loadExtract(login: Login) {

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://www.icoded.com.br/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()).build()

        retrofit.create(IExtractAPI::class.java).getExtract(login.password).enqueue(object: Callback<Extract> {
            override fun onFailure(call: retrofit2.Call<Extract>?, t: Throwable?) {
                interaction.onError("Objeto está nulo")
            }

            override fun onResponse(call: retrofit2.Call<Extract>?, response: Response<Extract>?) {
                if (response?.body()?.data != null) {
                    interaction.onExtractLoaded(response.body().data!!)
                } else {
                    interaction.onError("Erro, extrato nulo")
                }

            }
        })
    }
}