package com.example.lesson37.model;

import java.io.Serializable;

public class CharacterModel implements Serializable {
    private String name;
    private String secondName;
    private int image;

    public CharacterModel(String name, String secondName, int image) {
        this.name = name;
        this.secondName = secondName;
        this.image = image;
    }

    public CharacterModel(String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
