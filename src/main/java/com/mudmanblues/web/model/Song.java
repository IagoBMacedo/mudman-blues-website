package com.mudmanblues.web.model;

public class Song {
    private Integer id;
    private String title;
    private String slug;
    private String lyrics;
    private String language;
    private String album;
    private String videoId;

    public Song(Integer id, String title, String slug, String lyrics, String language, String album, String videoId) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.lyrics = lyrics;
        this.language = language;
        this.album = album;
        this.videoId = videoId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }

    public String getLyrics() {
        return lyrics;
    }

    public String getLanguage() {
        return language;
    }

    public String getAlbum() {
        return album;
    }

    public String getVideoId() {
        return videoId;
    }
}
