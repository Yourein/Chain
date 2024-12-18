package net.yourein.chain.model

import net.yourein.chain.db.table.User

data class ChatRoomModel(
    val chatRoomId: Int,
    val name: String,
    val iconRes: Int,
    val member: List<User>,
    val hasUnread: Boolean,
)