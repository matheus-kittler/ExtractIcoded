package com.example.extract_icoded.model

import java.io.Serializable

class Login : Serializable {

    var name: String? = null
    var password: String = "123456"

    constructor(name: String?, password: String) {
        this.name = name
        this.password = password
    }
}
