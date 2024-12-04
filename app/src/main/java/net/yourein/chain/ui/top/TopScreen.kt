package net.yourein.chain.ui.top

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.yourein.chain.ui.common.ChainTitleText
import net.yourein.chain.ui.common.ChainTopBar
import net.yourein.chain.ui.theme.ChainTheme

@Composable
fun TopScreen(
    viewModel: TopScreenViewModel
) {
}

@Composable
private fun TopScreen(
    unreadCount: List<Int>,
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    Scaffold(
        topBar = {
            ChainTopBar(
                title = { ChainTitleText() }
            )
        },
        contentWindowInsets = WindowInsets(0)
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            TopScreenTabRow(
                selectedTab = selectedTab,
                unreadCount = unreadCount,
                onTabClicked = { selectedTab = it },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TopScreenPreview() {
    ChainTheme {
        TopScreen(
            unreadCount = listOf(0, 0, 0)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TopScreenPreviewWithUnreads() {
    ChainTheme {
        TopScreen(
            unreadCount = listOf(12, 6, 0)
        )
    }
}