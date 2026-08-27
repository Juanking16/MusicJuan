package com.musicjuan.app.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.musicjuan.app.model.Playlist;
import java.util.List;

@Dao
public interface PlaylistDao {
    @Insert
    void insert(Playlist playlist);

    @Update
    void update(Playlist playlist);

    @Delete
    void delete(Playlist playlist);

    @Query("SELECT * FROM playlists")
    List<Playlist> getAllPlaylists();

    @Query("SELECT * FROM playlists WHERE id = :id")
    Playlist getPlaylistById(int id);
}
