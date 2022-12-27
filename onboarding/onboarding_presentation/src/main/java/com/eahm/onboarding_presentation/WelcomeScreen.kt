package com.eahm.onboarding_presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.eahm.core_ui.LocalSpacing

@Composable
fun WelcomeScreen() {
    val spacing = LocalSpacing.current

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Welcome",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1,
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        Text(
            text = "To start we need some information",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h2,
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        AppActionButton(
            text = "Continue",
            onClick = {},
        )
    }
}

@Preview
@Composable
private fun PreviewWelcomeScreen() {
    WelcomeScreen()
}