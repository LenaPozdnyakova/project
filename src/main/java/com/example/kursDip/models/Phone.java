package com.example.kursDip.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String anons;
    private String full_text;

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    private String views;

    public Long getId() {
        return id;
    }
    public String getAnons() {
        return anons;
    }
    public String getTitle() {
        return title;
    }

    public String getFull_text() {
        return full_text;
    }


    public void setId(Long id) {
        this.id = id;
    }
    public void setAnons(String anons) {
        this.anons = anons;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public Phone(String title, String anons, String full_text) {
        this.title = title;
        this.anons = anons;
        this.full_text = full_text;
    }

    public Phone() {
    }
}
