package com.iot.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Label {
    private int id;
    private String name;

    public Label(String name) {
        this.name = name;
    }

    public Label() {

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
        return "Label{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
