package com.example.macintoshhd.viewpager;

class DataFrog {
    private String mBackGroundColor;
    private int mIdImage;
    private String mDescription;

    public DataFrog(String backGroundColor, int idImage, String description) {
        mBackGroundColor = backGroundColor;
        mIdImage = idImage;
        mDescription = description;
    }

    public String getBackGroundColor() {
        return mBackGroundColor;
    }

    public int getIdImage() {
        return mIdImage;
    }

    public String getDescription() {
        return mDescription;
    }

}
