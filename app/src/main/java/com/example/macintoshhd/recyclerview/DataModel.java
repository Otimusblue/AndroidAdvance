package com.example.macintoshhd.recyclerview;

public class DataModel {
    private int mImage;
    private String mName;

    public DataModel(int image, String name) {
        mImage = image;
        mName = name;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
