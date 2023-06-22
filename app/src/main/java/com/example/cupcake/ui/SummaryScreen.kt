package com.example.cupcake.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.cupcake.R
import com.example.cupcake.data.OrderUiState
import com.example.cupcake.ui.components.FormattedPriceLabel

@Composable
fun OrderSummaryScreen(
    orderUiState: OrderUiState,
    paymentType: String = "Credit Card", // Replace with the actual payment type value
    shippingAddress: String = "1234 Main St, City, State", // Replace with the actual shipping address value
    onCancelButtonClicked: () -> Unit = {},
    onSendButtonClicked: (String, String) -> Unit = { subject: String, summary: String -> },
    onCheckOutButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {


    Column(modifier = modifier) {
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            Text(text = stringResource(R.string.quantity).uppercase())
            Text(text = orderUiState.quantity.toString(), fontWeight = FontWeight.Bold)
            Divider()
            Text(text = stringResource(R.string.flavor).uppercase())
            Text(text = orderUiState.flavor, fontWeight = FontWeight.Bold)
            Divider()
            Text(text = stringResource(R.string.pickup_date).uppercase())
            Text(text = orderUiState.date, fontWeight = FontWeight.Bold)
            Divider()
            Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
            FormattedPriceLabel(
                subtotal = orderUiState.price,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
            Text(text = "Payment Type: $paymentType")
            Text(text = "Shipping Address: $shippingAddress")
        }

        Column(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_medium))
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { onSendButtonClicked("subject", "summary") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(R.string.send))
            }

            Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))

            Button(
                onClick = { onCheckOutButtonClicked() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(R.string.check_out))
            }

            Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))

            OutlinedButton(
                onClick = onCancelButtonClicked,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(R.string.cancel))
            }
        }
    }
}


@Preview
@Composable
fun OrderSummaryPreview() {
    OrderSummaryScreen(
        orderUiState = OrderUiState(12, "Vanilla", "June 19", "$30.00"),
        paymentType = "Credit Card",
        shippingAddress = "1234 Main St, City, State",
        onCancelButtonClicked = {},
        onSendButtonClicked = { subject: String, summary: String -> },
        onCheckOutButtonClicked = {} // Pass an empty lambda for now
    )
}
