package net.yourein.chain.db.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "chatroom"
)
data class Chatroom(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "room_id")
    val roomId: Int,

    val name: String,

    @ColumnInfo(name = "icon_id")
    val iconId: Int,
)
