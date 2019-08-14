package com.example.extract_icoded.model

import com.example.extract_icoded.model.Detail
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Installment : Serializable {

    @SerializedName("past_due")
    var pastDue: String? = null
    @SerializedName("carnet")
    var carnet: String? = null
    @SerializedName("installment")
    var installment: String? = null
    @SerializedName("value")
    var value: String? = null
    @SerializedName("detail")
    var detail: Detail? = null

    var selected: Boolean? = null

    constructor(
        pastDue: String?,
        carnet: String?,
        installment: String?,
        value: String?,
        detail: Detail?,
        selected: Boolean?
    ) {
        this.pastDue = pastDue
        this.carnet = carnet
        this.installment = installment
        this.value = value
        this.detail = detail
        this.selected = selected
    }
}