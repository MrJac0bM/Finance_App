package com.example.financeapp.Domain

import kotlinx.serialization.Serializable

class BudgetDomain (
    val title: String = "",
    val price: Double = 0.0,
    val percent:Double = 0.0
    )