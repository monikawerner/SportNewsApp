package com.example.android.sportnewsapp;


public class News {

    /** Title of the news */
    private String mNewsTitle;

    /** Category of the news */
    private String mNewsCategory;

    /** Author of the news */
    private String mNewsAuthor;

    /** Date of the news */
    private String mNewsDate;

    /** Constructs a new News object
     * @param newsTitle is the title of news
     * @param newsCategory is the category of news
     * @param newsAuthor is the author of news
     * @param newsDate is the date of publication the news
     */
    public News(String newsTitle, String newsCategory, String newsAuthor, String newsDate) {
        mNewsTitle = newsTitle;
        mNewsCategory = newsCategory;
        mNewsAuthor = newsAuthor;
        mNewsDate = newsDate;
    }

    /** Returns the title of the news */
    public String getNewsTitle() {return mNewsTitle;}

    /** Returns the category of the news */
    public String getNewsCategory() {return mNewsCategory;}

    /** Returns the author of the news */
    public String getNewsAuthor() {return mNewsAuthor;}

    /** Returns the date of the news */
    public String getNewsDate() {return mNewsDate;}

}
