package com.sepehrpour.cartel.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sepehrpour.cartel.data.model.Scenario

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onScenarioClick: (String) -> Unit) {
    val scenarios = remember { ScenarioRepository.getScenarios() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("بازپرس") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(
                text = "انتخاب سناریو",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            ScenarioList(
                scenarios = scenarios,
                onScenarioClick = onScenarioClick
            )
        }
    }
}

@Composable
private fun ScenarioList(
    scenarios: List<Scenario>,
    onScenarioClick: (String) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(scenarios) { scenario ->
            ScenarioCard(
                scenario = scenario,
                onClick = { onScenarioClick(scenario.id) }
            )
        }
    }
}

@Composable
private fun ScenarioCard(
    scenario: Scenario,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = scenario.title,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = scenario.description,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2
            )
        }
    }
}