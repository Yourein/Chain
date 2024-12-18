package net.yourein.chain.ui.top

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import net.yourein.chain.R
import net.yourein.chain.model.ChatRoomModel
import net.yourein.chain.ui.common.ChainTitleText
import net.yourein.chain.ui.common.ChainTopBar
import net.yourein.chain.ui.theme.ChainTheme

@Composable
fun TopScreen(
    viewModel: TopScreenViewModel
) {
    val idolUnreadCount =
        remember(viewModel.idols) { viewModel.idols.count { it.hasUnread } }
    val unitUnreadCount =
        remember(viewModel.units) { viewModel.units.count { it.hasUnread } }

    TopScreen(
        unreadCount = persistentListOf(idolUnreadCount, unitUnreadCount, 0),
        roomWithIdol = viewModel.idols,
        roomWithUnit = viewModel.units,
    )
}

@Composable
fun TopScreen(
    unreadCount: ImmutableList<Int>,
    roomWithIdol: ImmutableList<ChatRoomModel>,
    roomWithUnit: ImmutableList<ChatRoomModel>,
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
            modifier = Modifier
                .padding(innerPadding)
        ) {
            TopScreenTabRow(
                selectedTab = selectedTab,
                unreadCount = unreadCount,
                onTabClicked = { selectedTab = it },
            )

            Box(
                modifier = Modifier
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal)
                    )
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.shinycolors),
                    contentDescription = null,
                    modifier = Modifier
                        .size(300.dp)
                        .align(Alignment.TopEnd)
                )

                when (selectedTab) {
                    0    -> {
                        RoomList(
                            rooms = roomWithIdol,
                            onRoomItemClick = {},
                        )
                    }

                    1    -> {
                        RoomList(
                            rooms = roomWithUnit,
                            onRoomItemClick = {},
                        )
                    }

                    2    -> {

                    }

                    else -> Unit
                }


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TopScreenPreview() {
    ChainTheme {
        TopScreen(
            unreadCount = persistentListOf(0, 0, 0),
            roomWithIdol = persistentListOf(),
            roomWithUnit = persistentListOf(),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TopScreenPreviewWithUnreads() {
    ChainTheme {
        TopScreen(
            unreadCount = persistentListOf(12, 6, 0),
            roomWithIdol = persistentListOf(),
            roomWithUnit = persistentListOf(),
        )
    }
}