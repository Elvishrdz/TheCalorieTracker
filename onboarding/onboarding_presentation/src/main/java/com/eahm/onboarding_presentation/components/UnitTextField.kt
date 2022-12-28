package com.eahm.onboarding_presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.eahm.core_ui.LocalSpacing

@Composable
fun UnitTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    unit: String,
    textStyle: TextStyle = TextStyle(
        color = MaterialTheme.colorScheme.secondary,
        fontSize = 70.sp,
    ),
) {
    val spacing = LocalSpacing.current
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
    ) {
        BasicTextField(
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .alignBy(LastBaseline),
            value = value,
            onValueChange = onValueChange,
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
            ),
            singleLine = true,
        )
        Spacer(modifier = Modifier.width(spacing.spaceSmall))
        Text(
            modifier = Modifier
                .alignBy(LastBaseline),
            text = unit,
        )
    }
}

@Preview
@Composable
fun PreviewUnitTextField() {
    UnitTextField(
        value = "30",
        onValueChange = {},
        unit = "kg",
    )
}