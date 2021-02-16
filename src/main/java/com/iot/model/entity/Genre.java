package com.iot.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Genre {
    private int id;
    private String name;

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {

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


    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
