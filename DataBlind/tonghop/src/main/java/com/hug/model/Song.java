package com.hug.model;

import java.util.List;

public class Song {
    private String name, artist, path;
    private List<String> type;

    public Song() {
    }

    public Song(String name, String artist, String path, List<String> type) {
        this.name = name;
        this.artist = artist;
        this.path = path;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }
}
