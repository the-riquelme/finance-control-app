package com.riquelme.financecontrolapp.model

data class Order(
    val id: Int,
    val name: String,
    val price: Double,
    val date: String,
    val entryOrExit: Long) {
}