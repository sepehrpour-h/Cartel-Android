package com.sepehrpour.cartel.presentation.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreen (onSplashFinished: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(2000)
        onSplashFinished()
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        color = MaterialTheme.colorScheme.primary
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "Cartel",
                style = MaterialTheme.typography.displayMedium.copy(
                    color = MaterialTheme.colorScheme.onPrimary
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}