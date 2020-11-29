package com.gperalta.android.musicplayer

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "SongListFragment"

class SongListFragment: Fragment() {
    private lateinit var songRecyclerView: RecyclerView

    private val songListViewModel: SongListViewModel by lazy {
        ViewModelProviders.of(this).get(SongListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total songsL ${songListViewModel.songs.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_song_list,container,false)

        songRecyclerView = view.findViewById(R.id.song_recycler_view) as RecyclerView
        songRecyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }

    companion object{
        fun newInstance(): SongListFragment{
            return SongListFragment()
        }
    }
}