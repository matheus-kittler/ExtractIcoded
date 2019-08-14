package com.example.extract_icoded.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Data : Serializable {

    @SerializedName("name")
    var name: String? = null
    @SerializedName("total_overdue")
    var totalOverdue: String? = null
    @SerializedName("total_due")
    var totalDue: String? = null
    @SerializedName("installments")
    var installments: List<Installment> = ArrayList<Installment>()
    @SerializedName("limits")
    var limits: Limit? = null

    constructor(
        name: String?,
        totalOverdue: String?,
        totalDue: String?,
        installments: List<Installment>,
        limits: Limit?
    ) {
        this.name = name
        this.totalOverdue = totalOverdue
        this.totalDue = totalDue
        this.installments = installments
        this.limits = limits
    }
}