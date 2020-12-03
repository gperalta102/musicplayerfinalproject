package com.gperalta.android.musicplayer

import android.content.ContentResolver
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import androidx.lifecycle.ViewModel

class SongListViewModel:ViewModel() {
    //val songs = mutableListOf<Song>()

    init {
        /*//temp songs, this is where you would scan and look for the songs
        for (i in 0 until 100){
            val song = Song()
            song.title = "Song #$i"
            song.album = "Album #$i"
            song.artist = "Artist $i"
            //adding to the songs
            songs += song
        }*/
    }

    /*fun getSongList(){
        val musicResolver: ContentResolver = applicationContext.contentResolver
        val musicURI: Uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val musicCursor: Cursor? = musicResolver.query(musicURI,null,null,null,null)

        if (musicCursor != null && musicCursor.moveToFirst()){
            val idColumn: Int = musicCursor.getColumnIndex(MediaStore.Audio.Media._ID)
            val titleColumn: Int = musicCursor.getColumnIndex(MediaStore.Audio.Media.TITLE)
            val artistColumn: Int = musicCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)

            do {
                val id: Long = musicCursor.getLong(idColumn)
                val title: String = musicCursor.getString(titleColumn)
                val artist: String = musicCursor.getString(artistColumn)
                val tempSong: Song = Song(id,title,artist)
                songList.add(tempSong)
            }while ( musicCursor.moveToNext())

        }
    }*/
}