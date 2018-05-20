package com.example.android.sportnewsapp;


public class News {

    /**
     * Image representing the news
     */

    private String mNewsImage;

    /**
     * Title of the news
     */
    private String mNewsHeading;

    /**
     * Author of the news
     */
    private String mNewsAuthor;

    /**
     * Category of the news
     */
    private String mNewsCategory;

    /**
     * Date of the news
     */
    private String mNewsDate;

    /**
     * Website url of the news
     */
    private String mNewsUrl;

    /**
     * Constructs a new News object
     *
     * @param newsImage    is the image representing the news
     * @param newsHeading  is the title of news
     * @param newsAuthor   is the author of the news
     * @param newsCategory is the category of news
     * @param newsDate     is the date of publication the news
     * @param newsUrl      is the website of the news
     */
    public News(String newsImage, String newsHeading, String newsAuthor, String newsCategory, String newsDate, String newsUrl) {
        mNewsImage = newsImage;
        mNewsHeading = newsHeading;
        mNewsAuthor = newsAuthor;
        mNewsCategory = newsCategory;
        mNewsDate = newsDate;
        mNewsUrl = newsUrl;
    }

    /**
     * Returns the image representing the news
     */

    public String getNewsImage() {
        return mNewsImage;
    }

    /**
     * Returns the title of the news
     */
    public String getNewsHeading() {
        return mNewsHeading;
    }

    /**
     * Returns the author of the news
     */
    public String getNewsAuthor() {
        return mNewsAuthor;
    }

    /**
     * Returns the category of the news
     */
    public String getNewsCategory() {
        return mNewsCategory;
    }

    /**
     * Returns the date of the news
     */
    public String getNewsDate() {
        return mNewsDate;
    }

    /**
     * Returns the website of the news
     */
    public String getNewsUrl() {
        return mNewsUrl;
    }


}
