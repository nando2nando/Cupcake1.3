package com.example.cupcake.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CreditCardScreen(
    onDoneClicked: () -> Unit
) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        // Credit Card Information
        Text(
            "Credit Card Information",
            modifier = Modifier.padding(vertical = 16.dp)
        )
        TextField(
            value = "", // TODO: Add the appropriate state for credit card name
            onValueChange = {}, // TODO: Add the appropriate state update for credit card name
            label = { Text("Name on Card") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = "", // TODO: Add the appropriate state for card number
            onValueChange = {}, // TODO: Add the appropriate state update for card number
            label = { Text("Card Number") },
            modifier = Modifier.fillMaxWidth()
        )
        // TODO: Add the input fields for expiration date and security code

        // Shipping Address
        Text(
            "Shipping Address",
            modifier = Modifier.padding(vertical = 16.dp)
        )
        TextField(
            value = "", // TODO: Add the appropriate state for shipping address
            onValueChange = {}, // TODO: Add the appropriate state update for shipping address
            label = { Text("Address") },
            modifier = Modifier.fillMaxWidth()
        )
        // TODO: Add the input fields for city, state, and ZIP code

        Button(
            onClick = onDoneClicked,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Done")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun CreditCardScreenPreview() {
    CreditCardScreen({})
}

