package com.iot.model.entity;

import javax.persistence.*;


@Entity
public class Album {
    private int id;
    private String name;
    private int numberOfSongs;
    private Artist artist;



    public Album() {
    }

    public Album(Artist artist, String name, Integer numberOfSongs) {
        this.artist= artist;
        this.name = name;
        this.numberOfSongs = numberOfSongs;
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
    @Column(name = "number_of_songs", nullable = false)
    public int getNumberOfSongs() {
        return numberOfSongs;
    }
    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }
    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "id", nullable = false)
    public Artist getArtist() {
        return artist;
    }
    public void setArtist(Artist artist) {
        this.artist = artist;
    }




    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", artist id =" + artist.getId() +
                ", name='" + name + '\'' +
                ", numberOfSongs=" + numberOfSongs +
                '}';
    }
}
