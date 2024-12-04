package net.yourein.chain.navigation

import kotlinx.serialization.Serializable

// Navigation Root
@Serializable data object Top

// アイドルとのトーク画面
@Serializable data class IdolTalk(val talkId: String)

// ユニットでのトーク画面
@Serializable data class UnitTalk(val groupId: String)