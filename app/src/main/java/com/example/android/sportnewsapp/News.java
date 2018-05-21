package com.example.android.sportnewsapp;


public class News {

    /**
     * Declare variables for image, title, author, category and website url of the news.
     */

    private String mNewsImage;

    private String mNewsHeading;

    private String mNewsAuthor;

    private String mNewsCategory;

    private String mNewsDate;

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

    public String getNewsImage() {
        return mNewsImage;
    }

    public String getNewsHeading() {
        return mNewsHeading;
    }

    public String getNewsAuthor() {
        return mNewsAuthor;
    }

    public String getNewsCategory() {
        return mNewsCategory;
    }

    public String getNewsDate() {
        return mNewsDate;
    }

    public String getNewsUrl() {
        return mNewsUrl;
    }

}
