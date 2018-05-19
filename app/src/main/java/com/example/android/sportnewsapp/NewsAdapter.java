package com.example.android.sportnewsapp;


import android.media.Image;
import android.widget.ArrayAdapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.net.URL;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {


    private static final String DATE_SEPARATOR = "T";
    private String formattedDate;


    /**
     * Constructs a new NewsAdapter
     *
     * @param context of the app
     * @param news    is the list of news - data source of adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information of news at the given position in the list
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /**
         * Check if the existing view is being reused, otherwise inflate the view
         */
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }
        /**
         * Get the object located at this position in the list
         */
        News currentNews = getItem(position);
        /** Find the ImageView in the news_list_item.xml layout
         */

        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        /**
         * Get the image from the current News object and set this value on the ImageView
         */

        GlideApp.with(this).load("http://goo.gl/gEgYUd").into(image);


        /**
         * Find the TextView in the news_list_item.xml layout
         */
        TextView title = (TextView) listItemView.findViewById(R.id.title);


        /**
         * Get the title from the current News object and set this value on the title TextView
         */
        title.setText(currentNews.getNewsHeading());

        /**
         * Find the TextView in the news_list_item.xml layout
         */
        TextView author = (TextView) listItemView.findViewById(R.id.author);
        /**
         * Get the author from the current News object and set this value on the author TextView
         */
        author.setText(currentNews.getNewsAuthor());

        /**
         * Find the TextView in the news_list_item.xml layout
         */
        TextView category = (TextView) listItemView.findViewById(R.id.category);
        /**
         * Get the category from the current News object and set this value on the category TextView
         */
        category.setText(currentNews.getNewsCategory());

        String dateFormat = currentNews.getNewsDate();

        if (dateFormat.contains(DATE_SEPARATOR)) {
            String[] parts = dateFormat.split(DATE_SEPARATOR);
            formattedDate = parts[0];
        }

        /** Find the TextView in the news_list_item.xml layout */
        TextView date = (TextView) listItemView.findViewById(R.id.date);

        /** Display the date of the current news in that TextView */
        date.setText(formattedDate);

        /** Return the list item view */
        return listItemView;
    }

}

