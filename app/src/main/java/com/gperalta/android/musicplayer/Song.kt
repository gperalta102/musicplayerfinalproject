package com.gperalta.android.musicplayer

import java.util.*

data class Song(
    val id: UUID = UUID.randomUUID(),
    var title: String = "uknown ${id}",
    var artist: String = "unknown",
    var album: String = "unknown",
    var location: String = ""

) {
}