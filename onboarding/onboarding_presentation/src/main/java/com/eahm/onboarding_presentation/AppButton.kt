package com.eahm.onboarding_presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.eahm.core_ui.LocalSpacing

@Composable
fun AppActionButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    textStyle: TextStyle = MaterialTheme.typography.button,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
    ) {
        Text(
            modifier = Modifier
                .padding(LocalSpacing.current.spaceSmall),
            text = text,
            style = textStyle,
            color = MaterialTheme.colors.onPrimary,
        )
    }
}