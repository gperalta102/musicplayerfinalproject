package com.gperalta.android.musicplayer

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

private const val TAG = "SongListFragment"

class SongListFragment: Fragment() {
    

    private lateinit var songRecyclerView: RecyclerView
    private var adapter: SongAdapter? = null

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
        updateUI()

        return view
    }

    companion object{
        fun newInstance(): SongListFragment{
            return SongListFragment()
        }
    }

    private fun updateUI(){
        val songs = songListViewModel.songs
        adapter = SongAdapter(songs)
        songRecyclerView.adapter = adapter
    }

    private inner class SongHolder(view: View):RecyclerView.ViewHolder(view), View.OnClickListener{
        private lateinit var song: Song

        private val titleTextView: TextView = itemView.findViewById(R.id.song_title)
        private val artistTextView: TextView = itemView.findViewById(R.id.song_artist)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(song: Song){
            this.song = song
            titleTextView.text = this.song.title
            artistTextView.text = this.song.artist
        }

        override fun onClick(v: View) {
            Toast.makeText(context, "${song.title} pressed!",Toast.LENGTH_SHORT).show()
        }

    }

    private inner class SongAdapter(var songs: List<Song>): RecyclerView.Adapter<SongHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : SongHolder {
            val view = layoutInflater.inflate(R.layout.list_item_song,parent,false)
            return SongHolder(view)
        }

        override fun getItemCount() = songs.size

        override fun onBindViewHolder(holder: SongHolder, position: Int) {
            val song = songs[position]
            holder.bind(song)
        }
    }
}