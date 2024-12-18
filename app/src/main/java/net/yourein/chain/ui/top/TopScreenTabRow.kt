package net.yourein.chain.ui.top

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.yourein.chain.ui.theme.ChainGradiantIndicator
import net.yourein.chain.ui.theme.ChainSecondary
import net.yourein.chain.ui.theme.ChainTextPrimary
import net.yourein.chain.ui.theme.ChainTheme
import net.yourein.chain.ui.theme.ChainWhite

private val topScreenTab = listOf(
    "アイドル",
    "ユニット",
    "エトセトラ"
)

@Composable
fun TopScreenTabRow(
    selectedTab: Int,
    unreadCount: List<Int>,
    onTabClicked: (Int) -> Unit,
) {
    require(unreadCount.size == topScreenTab.size) {
        "Size of unreadCount must be same as size of topScreenTab"
    }

    Column {
        TabRow(
            selectedTabIndex = selectedTab,
            divider = {},
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    color = ChainSecondary,
                    height = 4.dp,
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTab])
                )
            },
        ) {
            topScreenTab.forEachIndexed { index, tabTitle ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { onTabClicked(index) },
                    text = {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = tabTitle,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (selectedTab == index) {
                                        ChainSecondary
                                    } else {
                                        ChainTextPrimary
                                    }
                                )

                                if (unreadCount[index] > 0) {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                    TopScreenTabRowUnreadIndicator(
                                        unreadCount = unreadCount[index]
                                    )
                                }
                            }

                            if (index != topScreenTab.lastIndex) {
                                VerticalDivider(
                                    thickness = 2.dp,
                                    modifier = Modifier
                                        .align(Alignment.CenterEnd)
                                        .padding(vertical = 8.dp)
                                        .offset(x = 17.dp) // Tab.HorizontalTextPadding分 + 1dpだけずらす
                                )
                            }
                        }
                    }
                )
            }
        }
        HorizontalDivider(
            thickness = 4.dp
        )
    }
}

@Composable
private fun TopScreenTabRowUnreadIndicator(
    unreadCount: Int,
) {
    Box(
        modifier = Modifier
            .width(40.dp)
            .height(20.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(ChainGradiantIndicator)
    ) {
        Text(
            text = "$unreadCount",
            color = ChainWhite,
            fontSize = 12.sp,
            lineHeight = 12.sp,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
private fun TopScreenTabRowPreview() {
    ChainTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            for (it in 0..2) {
                TopScreenTabRow(
                    selectedTab = it,
                    unreadCount = listOf(0, 0, 0),
                    onTabClicked = {}
                )
            }
        }
    }
}

@Preview
@Composable
private fun TopScreenTabRowWithUnreadPreview() {
    ChainTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            TopScreenTabRow(
                selectedTab = 0,
                unreadCount = listOf(123, 456, 0),
                onTabClicked = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UnreadIndicatorPreview() {
    ChainTheme {
        TopScreenTabRowUnreadIndicator(3)
    }
}