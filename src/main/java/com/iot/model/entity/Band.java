package com.iot.model.entity;

import javax.persistence.*;



@Entity
public class Band {
    private int id;
    private String name;
    private Integer numOfArtists;

    public Band(String name, Integer numOfArtists) {
        this.name = name;
        this.numOfArtists = numOfArtists;
    }

    public Band() {

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
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "num_of_artists", nullable = true)
    public Integer getNumOfArtists() {
        return numOfArtists;
    }

    public void setNumOfArtists(Integer numOfArtists) {
        this.numOfArtists = numOfArtists;
    }


    @Override
    public String toString() {
        return "Band{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numOfArtists=" + numOfArtists +
                '}';
    }
}
