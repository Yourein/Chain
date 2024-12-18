package net.yourein.chain.ui.top

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
}

@Composable
fun TopScreen(
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
            modifier = Modifier
                .padding(innerPadding)
        ) {
            TopScreenTabRow(
                selectedTab = selectedTab,
                unreadCount = unreadCount,
                onTabClicked = { selectedTab = it },
            )

            Box(
                modifier = Modifier.fillMaxWidth()
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
                        val rooms = persistentListOf(
                            ChatRoomModel(
                                chatRoomId = 0,
                                name = "櫻木真乃",
                                iconRes = R.drawable.chain_icon_mano,
                                member = listOf(),
                                hasUnread = true,
                            ),
                            ChatRoomModel(
                                chatRoomId = 0,
                                name = "風野灯織",
                                iconRes = R.drawable.chain_icon_hiori,
                                member = listOf(),
                                hasUnread = true,
                            ),
                            ChatRoomModel(
                                chatRoomId = 0,
                                name = "めぐる",
                                iconRes = R.drawable.chain_icon_meguru,
                                member = listOf(),
                                hasUnread = true,
                            ),
                        )
                        RoomList(
                            rooms = rooms,
                            onRoomItemClick = {},
                        )
                    }

                    1    -> {

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