package com.gperalta.android.musicplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class SongFragment: Fragment() {
    private lateinit var song: Song
    private lateinit var titleFieldSongName: TextView
    private lateinit var titleFieldArtistName: TextView
    private lateinit var buttonNext: Button
    private lateinit var buttonPrev: Button
    private lateinit var buttonPlayPause: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        song = Song()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_song, container, false)
        //initializing the stuff
        titleFieldSongName = view.findViewById(R.id.song_title_label) as TextView
        titleFieldArtistName = view.findViewById(R.id.artist_title_label) as TextView

        buttonPrev = view.findViewById(R.id.skip_back) as Button
        buttonNext = view.findViewById(R.id.skip_foward) as Button
        buttonPlayPause = view.findViewById(R.id.play_pause) as Button


        return view
    }

    override fun onStart() {
        super.onStart()

    }



}