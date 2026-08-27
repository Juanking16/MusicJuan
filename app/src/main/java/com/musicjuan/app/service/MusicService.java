package com.musicjuan.app.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.musicjuan.app.model.Song;
import java.io.IOException;

public class MusicService extends Service {

    private MediaPlayer mediaPlayer;
    private Song currentSong;
    private boolean isPlaying = false;
    private final IBinder binder = new MusicBinder();
    private MusicServiceListener listener;

    public interface MusicServiceListener {
        void onSongChanged(Song song);
        void onPlaybackStatusChanged(boolean isPlaying);
        void onDurationChanged(long duration);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
        setupMediaPlayerListeners();
    }

    private void setupMediaPlayerListeners() {
        mediaPlayer.setOnCompletionListener(mp -> playNext());
        mediaPlayer.setOnErrorListener((mp, what, extra) -> {
            isPlaying = false;
            if (listener != null) {
                listener.onPlaybackStatusChanged(false);
            }
            return false;
        });
    }

    public void playSong(Song song) {
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.reset();
            mediaPlayer.setDataSource(song.getPath());
            mediaPlayer.prepare();
            mediaPlayer.start();
            currentSong = song;
            isPlaying = true;

            if (listener != null) {
                listener.onSongChanged(song);
                listener.onPlaybackStatusChanged(true);
                listener.onDurationChanged(mediaPlayer.getDuration());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            isPlaying = false;
            if (listener != null) {
                listener.onPlaybackStatusChanged(false);
            }
        }
    }

    public void resume() {
        if (!mediaPlayer.isPlaying() && currentSong != null) {
            mediaPlayer.start();
            isPlaying = true;
            if (listener != null) {
                listener.onPlaybackStatusChanged(true);
            }
        }
    }

    public void seekTo(int position) {
        mediaPlayer.seekTo(position);
    }

    public int getCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    public int getDuration() {
        return mediaPlayer.getDuration();
    }

    public Song getCurrentSong() {
        return currentSong;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setListener(MusicServiceListener listener) {
        this.listener = listener;
    }

    public void playNext() {
        if (listener != null) {
            listener.onSongChanged(null);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

    public class MusicBinder extends Binder {
        public MusicService getService() {
            return MusicService.this;
        }
    }
}
