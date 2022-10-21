package com.hug.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class SongForm {
    private String name, artist;
    private List<String> type;

    private MultipartFile path;

    public SongForm() {
    }

    public SongForm(String name, String artist, List<String> type, MultipartFile path) {
        this.name = name;
        this.artist = artist;
        this.type = type;
        this.path = path;
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

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }
}
