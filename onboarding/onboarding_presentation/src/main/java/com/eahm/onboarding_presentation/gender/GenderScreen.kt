package com.eahm.onboarding_presentation.gender

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.eahm.core.UiEvent
import com.eahm.core.domain.model.Gender
import com.eahm.core_ui.LocalSpacing
import com.eahm.onboarding_presentation.components.AppActionButton
import com.eahm.onboarding_presentation.components.SelectableButton

@Composable
fun GenderScreen(
    onNextClick: () -> Unit,
    viewModel: GenderViewModel? = hiltViewModel(),
) {
    val spacing = LocalSpacing.current
    LaunchedEffect(key1 = true) {
        viewModel?.uiEvent?.collect { event ->
            when (event) {
                is UiEvent.OnSuccess -> onNextClick()
                else -> Unit
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = com.eahm.core.R.string.whats_your_gender),
                style = MaterialTheme.typography.displayMedium,
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row {
                SelectableButton(
                    text = stringResource(id = com.eahm.core.R.string.male),
                    isSelected = viewModel?.selectedGender is Gender.Male,
                    color = MaterialTheme.colorScheme.secondary,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel?.onGenderClicked(Gender.Male)
                    },
                    textStyle = MaterialTheme.typography.displaySmall,
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = com.eahm.core.R.string.female),
                    isSelected = viewModel?.selectedGender is Gender.Female,
                    color = MaterialTheme.colorScheme.secondary,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel?.onGenderClicked(Gender.Female)
                    },
                    textStyle = MaterialTheme.typography.displaySmall,
                )
            }
        }
        AppActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd),
            text = stringResource(id = com.eahm.core.R.string.next),
            onClick = {
                viewModel?.onNextClicked()
            },
        )
    }
}

@Preview
@Composable
private fun PreviewGenderScreen() {
    GenderScreen(
        onNextClick = {},
        viewModel = null,
    )
}