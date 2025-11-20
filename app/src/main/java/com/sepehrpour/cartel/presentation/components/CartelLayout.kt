package com.sepehrpour.cartel.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AssistChip
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.sepehrpour.cartel.data.model.FooterMenuItem

@Composable
fun CartelLayout(
    modifier: Modifier = Modifier,
    headerContent: @Composable () -> Unit,
    footerContent: @Composable () -> Unit,
    body: @Composable ColumnScope.() -> Unit
){
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        headerContent()
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            content = body
        )
        footerContent()
    }
}

@Composable
fun CartelHeader(
    userName: String,
    onProfileClick: () -> Unit,
    onFriendsClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AssistChip(
            onClick = onProfileClick,
            label = { Text(text = userName) },
            leadingIcon = { Icon(Icons.Default.AccountCircle, null) }
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "بازپرس لوگو",
                tint = MaterialTheme.colorScheme.primary
            )
            Text("بازپرس", style = MaterialTheme.typography.titleMedium)
        }
        FilledTonalButton(onClick = onFriendsClick) {
            Icon(Icons.Default.AccountCircle, contentDescription = null)
            Spacer(Modifier.width(6.dp))
            Text("دوستان")
        }
    }
}


@Composable
fun CartelFooterMenu(
    items: List<FooterMenuItem>,
    selected: String,
    onSectionSelected: (FooterMenuItem) -> Unit
) {
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = item.id == selected,
                onClick = { onSectionSelected(item) },
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) }
            )
        }
    }
}
