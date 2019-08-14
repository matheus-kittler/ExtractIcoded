package com.example.extract_icoded.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Limit : Serializable {

    @SerializedName("total_due")
    var totalDue: String? = null
    @SerializedName("total")
    var total: String? = null
    @SerializedName("expent")
    var expent: String? = null
    @SerializedName("available")
    var available: String? = null

    constructor(totalDue: String?, total: String?, expent: String?, available: String?) {
        this.totalDue = totalDue
        this.total = total
        this.expent = expent
        this.available = available
    }
}