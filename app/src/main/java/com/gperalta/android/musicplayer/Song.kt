package com.gperalta.android.musicplayer

import android.net.Uri

data class Song(
    val id: Long = 404,
    var title: String = "uknown ${id}",
    var artist: String = "unknown",
    var location: String = "uknown"

) {
}