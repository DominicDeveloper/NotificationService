package com.asadbek.notificationservice

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class NotificationReceiver:Service(){
    lateinit var mediaPlayer: MediaPlayer
    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer()
        mediaPlayer.setDataSource(this,Settings.System.DEFAULT_RINGTONE_URI)
        mediaPlayer.prepare()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
       if (mediaPlayer.isPlaying){
           mediaPlayer.pause()
       }else{
           mediaPlayer.start()
       }
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}