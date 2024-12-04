package net.yourein.chain.navigation

import kotlinx.serialization.Serializable

// Navigation Root
@Serializable data object Top

// アイドルとのトーク画面
@Serializable data class IdolTalk(val talkId: String)

// アイドルのプロフィール画面
@Serializable
data class IdolProfile(val idolId: String)

// ユニットでのトーク画面
@Serializable data class UnitTalk(val groupId: String)

// グループの参加者一覧画面
@Serializable
data class GroupMembers(val groupId: String)

// デバッグ用画面
@Serializable
data object Playground