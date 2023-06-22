package com.example.cupcake.data

data class OrderUiState(
    val quantity: Int = 0,
    val flavor: String = "",
    val date: String = "",
    val price: String = "",
    val pickupOptions: List<String> = listOf(),
    var paymentDetails: List<String> = listOf(),
    var cardName: String = "",
    var cardNumber: String = "",
    var shippingAddress: String = "",
    var paymentType: String = ""
)
