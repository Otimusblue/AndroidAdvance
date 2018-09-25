package com.example.macintoshhd.parsejsonuseglide.Model;

public class Anime {

    private String mName;
    private String mDescription;
    private String mRating;
    private String mStudio;
    private String mCategories;
    private String mImage;
    private int mEpisode;

    public Anime(){

    }

    public Anime(String name, String description, String rating, String studio, String categories,
            String image, int episode) {
        mName = name;
        mDescription = description;
        mRating = rating;
        mStudio = studio;
        mCategories = categories;
        mImage = image;
        mEpisode = episode;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getRating() {
        return mRating;
    }

    public void setRating(String rating) {
        mRating = rating;
    }

    public String getStudio() {
        return mStudio;
    }

    public void setStudio(String studio) {
        mStudio = studio;
    }

    public String getCategories() {
        return mCategories;
    }

    public void setCategories(String categories) {
        mCategories = categories;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public int getEpisode() {
        return mEpisode;
    }

    public void setEpisode(int episode) {
        mEpisode = episode;
    }

}

