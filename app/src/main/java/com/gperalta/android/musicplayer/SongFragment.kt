package com.gperalta.android.musicplayer

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.*

private const val TAG = "SongFragment"
private const val ARG_SONG_ID = "song_id"


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
        val songId:Long = arguments?.getSerializable(ARG_SONG_ID) as Long
        Log.d(TAG, "args bundle song ID: $songId")
        //eventually load song infromation
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
        buttonPrev.setOnClickListener{
            //previous song
            Log.d(TAG,"prev was clicked")
            Toast.makeText(requireActivity(), "back ",Toast.LENGTH_SHORT).show()
        }
        buttonPlayPause.setOnClickListener{
            //play or pause song
            Log.d(TAG,"play pause was clicked")
            Toast.makeText(requireActivity(), "play/pause",Toast.LENGTH_SHORT).show()
        }
        buttonNext.setOnClickListener{ view: View ->
            //next song
            Log.d(TAG,"next was clicked")
            Toast.makeText(requireActivity(), "Skip ",Toast.LENGTH_SHORT).show()
        }

    }

    companion object{
        fun newInstance(songId: Long):SongFragment {
            val args = Bundle().apply {
                putSerializable(ARG_SONG_ID, songId)
            }
            return SongFragment().apply {
                arguments = args
            }
        }
    }



}