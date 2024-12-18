package net.yourein.chain.db.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "post_user_id") val postUserId: Int,
    @ColumnInfo(name = "post_room_id") val postRoomId: Int,
    val message: String,
    @ColumnInfo(name = "is_read") val isAlreadyRead: Boolean,
)