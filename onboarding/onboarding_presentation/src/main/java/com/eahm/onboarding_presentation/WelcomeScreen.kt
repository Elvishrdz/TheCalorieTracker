package com.eahm.onboarding_presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.eahm.core.R
import com.eahm.core_ui.LocalSpacing

@Composable
fun WelcomeScreen(
    onContinue: () -> Unit,
) {
    val spacing = LocalSpacing.current

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = stringResource(id = R.string.welcome_title),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1,
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        Text(
            text = stringResource(id = R.string.welcome_description),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h2,
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        AppActionButton(
            text = stringResource(id = R.string.cta_continue),
            onClick = onContinue,
        )
    }
}

@Preview
@Composable
private fun PreviewWelcomeScreen() {
    WelcomeScreen(
        onContinue = {},
    )
}