package com.iot.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Artist {
    private int id;
    private Label label;
    private Band band;
    private String name;
    private int monthlyListens;
    private int followers;

    public Artist( Label label, Band band, String name, int monthlyListens, int followers) {

        this.label = label;
        this.band = band;
        this.name = name;
        this.monthlyListens = monthlyListens;
        this.followers = followers;
    }

    public Artist() {

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
    @Column(name = "monthly_listens", nullable = false)
    public int getMonthlyListens() {
        return monthlyListens;
    }

    public void setMonthlyListens(int monthlyListens) {
        this.monthlyListens = monthlyListens;
    }

    @Basic
    @Column(name = "followers", nullable = false)
    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }
    @ManyToOne
    @JoinColumn(name = "label_id", referencedColumnName = "id")
    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
    @ManyToOne
    @JoinColumn(name = "band_id", referencedColumnName = "id")
    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }


    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
////                ", label=" + label.getId() +
//                ", band=" + band.getId() +
                ", name='" + name + '\'' +
                ", monthlyListens=" + monthlyListens +
                ", followers=" + followers +
                '}';
    }
}
