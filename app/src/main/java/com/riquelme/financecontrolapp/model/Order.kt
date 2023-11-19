package com.riquelme.financecontrolapp.model

data class Order(
    val name: String,
    val price: Double,
    val date: String,
    val entryOrExit: Int) {
}