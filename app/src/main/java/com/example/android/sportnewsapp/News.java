package com.example.android.sportnewsapp;


public class News {

    /** Title of the news */
    private String mNewsHeading;

    /** Category of the news */
    private String mNewsCategory;

    /** Date of the news */
    private String mNewsDate;

    /** Website url of the news */
    private String mNewsUrl;

    /** Constructs a new News object
     * @param newsHeading is the title of news
     * @param newsCategory is the category of news
     * @param newsDate is the date of publication the news
     */
    public News(String newsHeading, String newsCategory, String newsDate, String newsUrl) {
        mNewsHeading = newsHeading;
        mNewsCategory = newsCategory;
        mNewsDate = newsDate;
        mNewsUrl = newsUrl;
    }

    /** Returns the title of the news */
    public String getNewsHeading() {return mNewsHeading;}

    /** Returns the category of the news */
    public String getNewsCategory() {return mNewsCategory;}

    /** Returns the date of the news */
    public String getNewsDate() {return mNewsDate;}

    /** Returns the website of the news */
    public String getNewsUrl() {return  mNewsUrl;}


}
