package com.sepehrpour.cartel.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sepehrpour.cartel.data.model.FooterMenuItem
import com.sepehrpour.cartel.data.model.Scenario
import com.sepehrpour.cartel.presentation.components.CartelFooterMenu
import com.sepehrpour.cartel.presentation.components.CartelHeader
import com.sepehrpour.cartel.presentation.components.CartelLayout

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onScenarioClick: (String) -> Unit) {
    val scenarios = remember { ScenarioRepository.getScenarios() }
    val footerItems = remember {
        listOf(
            FooterMenuItem("home", "خانه", Icons.Default.Home),
            FooterMenuItem("scenarios", "سناریوها", Icons.Default.Menu),
            FooterMenuItem("roles", "نقش‌ها", Icons.Default.Person),
            FooterMenuItem("tools", "ابزار", Icons.Default.Build),
            FooterMenuItem("settings", "تنظیمات", Icons.Default.Settings)
        )
    }
    var selectedFooter by rememberSaveable { mutableStateOf("home") }

    Scaffold { innerPadding ->
        CartelLayout(
            modifier = Modifier.padding(innerPadding),
            headerContent = {
                CartelHeader(
                    userName = "کاربر",
                    onProfileClick = { /* TODO */ },
                    onFriendsClick = { /* TODO */ }
                )
            },
            footerContent = {
                CartelFooterMenu(
                    items = footerItems,
                    selected = selectedFooter,
                    onSectionSelected = { selectedFooter = it.id }
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                Text("انتخاب سناریو", style = MaterialTheme.typography.headlineMedium)
                Spacer(Modifier.height(16.dp))
                ScenarioList(scenarios, onScenarioClick)
            }
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