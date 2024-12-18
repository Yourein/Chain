package net.yourein.chain.db.table

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomUser(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val userId: Int,
    val roomId: Int,
)