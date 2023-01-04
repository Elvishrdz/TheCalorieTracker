package com.eahm.onboarding_presentation.age

import androidx.compose.foundation.layout.*
import androidx.compose.material.ScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.eahm.core.R
import com.eahm.core.UiEvent
import com.eahm.core_ui.LocalSpacing
import com.eahm.onboarding_presentation.components.AppActionButton
import com.eahm.onboarding_presentation.components.UnitTextField

@Composable
fun AgeScreen(
    scaffoldState: ScaffoldState,
    onNextClick: () -> Unit,
    viewModel: AgeViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.OnSuccess -> {
                    onNextClick()
                }
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.uiText.toString(context)
                    )
                }
                else -> Unit
            }
        }
    }

    AgeScreenDesign(
        age = viewModel.age,
        onAgeEnter = viewModel::onAgeEnter,
        onNextClicked = viewModel::onNextClicked,
    )

}

@Composable
private fun AgeScreenDesign(
    age: String,
    onAgeEnter: (String) -> Unit,
    onNextClicked: () -> Unit,
) {
    val spacing = LocalSpacing.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = R.string.whats_your_age),
                style = MaterialTheme.typography.displayMedium,
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = age,
                onValueChange = onAgeEnter,
                unit = stringResource(id = R.string.years),
            )
        }
        AppActionButton(
            text = stringResource(id = R.string.next),
            onClick = onNextClicked,
            modifier = Modifier.align(Alignment.BottomEnd),
        )
    }
}

@Preview
@Composable
private fun PreviewAgeScreen() {
    AgeScreenDesign(
        age = "20",
        onAgeEnter = {},
        onNextClicked = {},
    )
}