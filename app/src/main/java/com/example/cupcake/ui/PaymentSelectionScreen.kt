package com.example.cupcake.ui

import OrderViewModel
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cupcake.R


@Composable
fun PaymentSelectionScreen(
    onPaymentSelected: (String) -> Unit,
    onNextClicked: () -> Unit,
    viewModel: OrderViewModel
) {
    var selectedPaymentType by rememberSaveable { mutableStateOf("") }

    val paymentOptions = listOf("Credit Card", "PayPal", "Google Pay") // Replace with your actual payment options

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        // Payment Options
        Text(
            "Select Payment Type",
            modifier = Modifier.padding(vertical = 16.dp)
        )

        paymentOptions.forEach { paymentType ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        selectedPaymentType = paymentType
                        onPaymentSelected(paymentType)
                    }
                    .padding(vertical = 8.dp)
            ) {
                RadioButton(
                    selected = paymentType == selectedPaymentType,
                    onClick = {
                        selectedPaymentType = paymentType
                        onPaymentSelected(paymentType)
                    }
                )
                Text(
                    text = paymentType,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }

        Button(
            onClick = onNextClicked,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Next")
        }
    }
}




@Preview(showBackground = true)
@Composable
fun PaymentSelectionScreenPreview() {
    val viewModel = OrderViewModel()
    PaymentSelectionScreen({}, {}, viewModel = viewModel)
}
