package net.yourein.chain.ui.top

import androidx.lifecycle.ViewModel
import kotlinx.collections.immutable.persistentListOf
import net.yourein.chain.R
import net.yourein.chain.model.ChatRoomModel

class TopScreenViewModel : ViewModel() {
    private val mockRoom = ChatRoomModel(
        chatRoomId = 0,
        name = "櫻木真乃",
        iconRes = R.drawable.chain_icon_mano,
        member = listOf(),
        hasUnread = true
    )
    val idols = persistentListOf(
        mockRoom,
        mockRoom.copy(name = "風野灯織", iconRes = R.drawable.chain_icon_hiori),
        mockRoom.copy(name = "めぐる", iconRes = R.drawable.chain_icon_meguru),
        mockRoom.copy(name = "恋鐘", iconRes = R.drawable.chain_icon_kogane),
        mockRoom.copy(name = "まみみ", iconRes = R.drawable.chain_icon_mamimi),
        mockRoom.copy(
            name = "白瀬咲耶 / Sakuya Shirase",
            iconRes = R.drawable.chain_icon_sakuya
        ),
        mockRoom.copy(name = "三峰", iconRes = R.drawable.chain_icon_yuika),
        mockRoom.copy(
            name = "幽谷霧子",
            iconRes = R.drawable.chain_icon_kiriko
        ),
        mockRoom.copy(
            name = "こみやかほ",
            iconRes = R.drawable.chain_icon_kaho
        ),
        mockRoom.copy(
            name = "園田智代子",
            iconRes = R.drawable.chain_icon_chiyoko
        ),
        mockRoom.copy(name = "西城樹里", iconRes = R.drawable.chain_icon_juri),
        mockRoom.copy(name = "杜野凛世", iconRes = R.drawable.chain_icon_rinze),
        mockRoom.copy(
            name = "Natsuha Arisugawa",
            iconRes = R.drawable.chain_icon_natsuha
        ),
        mockRoom.copy(name = "大崎甘奈", iconRes = R.drawable.chain_icon_amana),
        mockRoom.copy(name = "てんか", iconRes = R.drawable.chain_icon_tenka),
        mockRoom.copy(
            name = "桑山千雪",
            iconRes = R.drawable.chain_icon_chiyuki
        ),
        mockRoom.copy(name = "ふゆ", iconRes = R.drawable.chain_icon_fuyuko),
        mockRoom.copy(
            name = "芹沢あさひ",
            iconRes = R.drawable.chain_icon_asahi
        ),
        mockRoom.copy(name = "愛依", iconRes = R.drawable.chain_icon_mei),
        mockRoom.copy(name = "浅倉", iconRes = R.drawable.chain_icon_toru),
        mockRoom.copy(name = "樋口", iconRes = R.drawable.chain_icon_madoka),
        mockRoom.copy(
            name = "福丸 小糸",
            iconRes = R.drawable.chain_icon_koito
        ),
        mockRoom.copy(name = "ひなな", iconRes = R.drawable.chain_icon_hinana),
        mockRoom.copy(
            name = "緋田美琴",
            iconRes = R.drawable.chain_icon_mikoto
        ),
        mockRoom.copy(
            name = "七草にちか",
            iconRes = R.drawable.chain_icon_nichika
        ),
        mockRoom.copy(name = "羽那", iconRes = R.drawable.chain_icon_hana),
        mockRoom.copy(name = "いかるが", iconRes = R.drawable.chain_icon_luca),
        mockRoom.copy(
            name = "いくはる",
            iconRes = R.drawable.chain_icon_haruki
        ),
    )
}