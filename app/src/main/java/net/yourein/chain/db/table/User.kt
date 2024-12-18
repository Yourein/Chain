package net.yourein.chain.db.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    val userId: Int,

    val name: String,

    val description: String,

    @ColumnInfo(name = "resource_id")
    val resourceId: Int,

    // TODO: プロフィール画面の背景画像とか設定できるようにする
)
