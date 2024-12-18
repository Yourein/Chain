package net.yourein.chain.ui.top

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import net.yourein.chain.R
import net.yourein.chain.model.ChatRoomModel
import net.yourein.chain.ui.theme.ChainTextPrimary
import net.yourein.chain.ui.theme.ChainTheme
import net.yourein.chain.ui.theme.ChainWhite

@Composable
fun RoomList(
    rooms: ImmutableList<ChatRoomModel>,
    onRoomItemClick: (ChatRoomModel) -> Unit,
) {
    LazyColumn {
        items(rooms) { room ->
            RoomItem(
                chatroom = room,
                onRoomItemClick = onRoomItemClick,
            )
        }
    }
}

@Composable
fun RoomItem(
    chatroom: ChatRoomModel,
    onRoomItemClick: (ChatRoomModel) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onRoomItemClick(chatroom) }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(chatroom.iconRes),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.size(16.dp))

        Text(
            text = chatroom.name,
            fontSize = 16.sp,
            lineHeight = 22.sp,
            color = ChainTextPrimary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f)
        )

        val backRadius = with(LocalDensity.current) { 14.dp.toPx() / 2f }
        val radius = with(LocalDensity.current) { 12.dp.toPx() / 2f }
        Box(
            modifier = Modifier
                .size(14.dp)
                .drawWithCache {
                    onDrawBehind {
                        drawCircle(
                            color = ChainWhite,
                            radius = backRadius
                        )
                        drawCircle(
                            brush = Brush.linearGradient(
                                0.4f to Color(0xFFF23971),
                                0.8f to Color(0xFFF48A83),
                                start = Offset(0f, 0f),
                                end = Offset(
                                    Float.POSITIVE_INFINITY,
                                    Float.POSITIVE_INFINITY
                                )
                            ),
                            radius = radius
                        )
                    }
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RoomItemPreview() {
    ChainTheme {
        RoomList(
            rooms = persistentListOf(
                ChatRoomModel(
                    chatRoomId = 0,
                    name = "放課後クライマックスガールズ",
                    iconRes = R.drawable.chain_icon_mano,
                    member = listOf(),
                    hasUnread = false,
                ),
            ),
            onRoomItemClick = {},
        )
    }
}