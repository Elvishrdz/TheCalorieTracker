package com.eahm.onboarding_presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.eahm.core_ui.LocalSpacing

@Composable
fun AppActionButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    textStyle: TextStyle = MaterialTheme.typography.titleSmall,
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
            color = MaterialTheme.colorScheme.onPrimary,
        )
    }
}