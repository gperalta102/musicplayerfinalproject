package com.gperalta.android.musicplayer

import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.*

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity(), SongListFragment.Callbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)){
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1)
            }else{
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1)
            }
        }


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null){
            val fragment = SongListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container,fragment)
                .commit()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"Permission has been granted", Toast.LENGTH_SHORT)
                }else{
                    Toast.makeText(this, "permission not granted", Toast.LENGTH_SHORT)
                }
            }
        }
        return
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onSongSelected(songId: Long, songTitle: String, artistTitle: String, location: String) {
        Log.d(TAG, "MainActivity,on Song Selected: $songId")

        val fragment = SongFragment.newInstance(songId, songTitle, artistTitle, location)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }



}