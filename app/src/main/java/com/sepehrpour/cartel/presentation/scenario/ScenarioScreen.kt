package com.sepehrpour.cartel.presentation.scenario

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScenarioScreen(
    scenarioId: String,
    onBack: () -> Unit
) {
    val scenario = ScenarioRepository.getScenarioById(scenarioId)

    if (scenario == null) {
        Text("سناریو یافت نشد")
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(scenario.title) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "بازگشت")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text(
                    text = "معرفی سناریو",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            item {
                Text(
                    text = scenario.description,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            item {
                Text(
                    text = "نقش‌ها",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            items(scenario.roles) { role ->
                RoleItem(role)
            }
        }
    }
}

@Composable
private fun RoleItem(role: com.sepehrpour.cartel.data.model.Role) {
    Card {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = role.name,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = role.description,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            AssistChip(
                onClick = {},
                label = { Text(role.team.name) }
            )
        }
    }
}