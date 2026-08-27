package com.musicjuan.app.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.musicjuan.app.model.Playlist;

@Database(entities = {Playlist.class}, version = 1, exportSchema = false)
public abstract class MusicDatabase extends RoomDatabase {
    public abstract PlaylistDao playlistDao();
}
