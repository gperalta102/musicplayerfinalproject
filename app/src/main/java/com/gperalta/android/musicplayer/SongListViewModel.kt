package com.gperalta.android.musicplayer

import androidx.lifecycle.ViewModel

class SongListViewModel:ViewModel() {
    val songs = mutableListOf<Song>()

    init {
        //temp songs, this is where you would scan and look for the songs
        for (i in 0 until 100){
            val song = Song()
            song.title = "Song #$i"
            song.album = "Album #$i"
            song.artist = "Artist $i"
            //adding to the songs
            songs += song
        }
    }
}