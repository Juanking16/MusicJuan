package com.musicjuan.app.util;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import com.musicjuan.app.model.Song;
import java.util.ArrayList;
import java.util.List;

public class MusicLoader {

    public static List<Song> loadSongs(Context context) {
        List<Song> songs = new ArrayList<>();
        
        String[] projection = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.ALBUM_ID
        };

        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
        String sortOrder = MediaStore.Audio.Media.TITLE + " ASC";

        Cursor cursor = context.getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                selection,
                null,
                sortOrder
        );

        if (cursor != null) {
            while (cursor.moveToNext()) {
                long id = cursor.getLong(0);
                String title = cursor.getString(1);
                String artist = cursor.getString(2);
                String album = cursor.getString(3);
                long duration = cursor.getLong(4);
                String path = cursor.getString(5);
                long albumId = cursor.getLong(6);

                Song song = new Song(id, title, artist, album, duration, path, albumId);
                songs.add(song);
            }
            cursor.close();
        }

        return songs;
    }
}
