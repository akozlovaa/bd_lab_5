package com.iot.model.entity;

import javax.persistence.*;

@Entity
public class Song {
    private int id;
    private Album album;
    private Artist artist;
    private Genre genre;
    private String name;
    private int durationInSeconds;

    public Song(Album album, Artist artist, Genre genre, String name, int durationInSeconds) {
        this.album = album;
        this.artist = artist;
        this.genre = genre;
        this.name = name;
        this.durationInSeconds = durationInSeconds;
    }

    public Song() {

    }


    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "duration_in_seconds", nullable = false)
    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }


    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "id", nullable = false)
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "id", nullable = false)
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable = false)
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", album=" + album.getId() +
                ", artist=" + artist.getId() +
                ", genre=" + genre.getId() +
                ", name='" + name + '\'' +
                ", durationInSeconds=" + durationInSeconds +
                '}';
    }
}
