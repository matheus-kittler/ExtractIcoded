package com.example.extract_icoded.model

import com.example.extract_icoded.model.Data

class Extract {

    var code: Int? = null
    var status: String? = null
    var data: Data? = null

    constructor(code: Int?, status: String?, data: Data) {
        this.code = code
        this.status = status
        this.data = data
    }
}