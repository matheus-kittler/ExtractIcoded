package com.example.extract_icoded.main

import com.example.extract_icoded.model.Data
import com.example.extract_icoded.model.Login

interface MainActivityInteraction {

    fun onExtractLoaded(data: Data)
    fun onError(msg: String)
    fun onLoginSuccess(login: Login)
}

