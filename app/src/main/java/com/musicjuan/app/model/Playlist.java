package com.musicjuan.app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "playlists")
public class Playlist {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private long createdAt;
    private List<Long> songIds = new ArrayList<>();

    public Playlist(String name) {
        this.name = name;
        this.createdAt = System.currentTimeMillis();
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public long getCreatedAt() { return createdAt; }
    public List<Long> getSongIds() { return songIds; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSongIds(List<Long> songIds) { this.songIds = songIds; }
    public void addSong(long songId) { this.songIds.add(songId); }
    public void removeSong(long songId) { this.songIds.remove(songId); }
}
