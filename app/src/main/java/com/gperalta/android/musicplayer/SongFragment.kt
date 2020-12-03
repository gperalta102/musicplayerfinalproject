package com.gperalta.android.musicplayer

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

private const val TAG = "SongFragment"
private const val ARG_SONG_ID = "song_id"
private const val ARG_SONG_TITLE = "song_title"
private const val ARG_SONG_ARTIST = "artist_title"
private const val ARG_SONG_LOCATION = "location"


class SongFragment: Fragment() {
    private lateinit var song: Song
    private lateinit var titleFieldSongName: TextView
    private lateinit var titleFieldArtistName: TextView
    private lateinit var buttonNext: Button
    private lateinit var buttonPrev: Button
    private lateinit var buttonPlayPause: Button
    private lateinit var mediaPlayer: MediaPlayer
    private var songId: Long = 0
    private var songTitle = "broken"
    private var songArtist = "broken too"
    private var songLocation = "even this one is broken"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        song = Song()
        songId = arguments?.getSerializable(ARG_SONG_ID) as Long
        songTitle = arguments?.getSerializable(ARG_SONG_TITLE)as String
        songArtist = arguments?.getSerializable(ARG_SONG_ARTIST)as String
        songLocation = arguments?.getSerializable(ARG_SONG_LOCATION)as String
        Log.d(TAG, "args bundle song ID: $songId , $songTitle, $songArtist, $songLocation")
        //eventually load song infromation into media player
        val songUri: Uri = Uri.parse(songLocation)
        mediaPlayer = MediaPlayer.create(context,songUri)

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

        titleFieldSongName.setText(songTitle)
        titleFieldArtistName.setText(songArtist)

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
            if (mediaPlayer.isPlaying){
                mediaPlayer.pause()
            }else{
                mediaPlayer.start()
            }
        }
        buttonNext.setOnClickListener{ view: View ->
            //next song
            Log.d(TAG,"next was clicked")
            Toast.makeText(requireActivity(), "Skip ",Toast.LENGTH_SHORT).show()
        }

    }

    override fun onDetach() {
        super.onDetach()
        mediaPlayer.reset()
    }

    companion object{
        fun newInstance(songId: Long, songTitle: String, artistTitle: String, location: String):SongFragment {
            val args = Bundle().apply {
                putSerializable(ARG_SONG_ID, songId)
                putSerializable(ARG_SONG_TITLE,songTitle)
                putSerializable(ARG_SONG_ARTIST,artistTitle)
                putSerializable(ARG_SONG_LOCATION,location)
            }
            return SongFragment().apply {
                arguments = args
            }
        }
    }



}