package com.example.extract_icoded.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Detail : Serializable {

    @SerializedName("overdue_days")
    var overdueDays: String? = null
    @SerializedName("overdue_date")
    var overdueDate: String? = null
    @SerializedName("original_value")
    var originalValue: String? = null
    @SerializedName("value_diff")
    var valueDiff: String? = null
    @SerializedName("total_value")
    var totalValue: String? = null
    @SerializedName("store")
    var store: String? = null

    constructor(
        overdueDays: String?,
        overdueDate: String?,
        originalValue: String?,
        valueDiff: String?,
        totalValue: String?,
        store: String?
    ) {
        this.overdueDays = overdueDays
        this.overdueDate = overdueDate
        this.originalValue = originalValue
        this.valueDiff = valueDiff
        this.totalValue = totalValue
        this.store = store
    }
}