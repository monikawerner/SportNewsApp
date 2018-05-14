package com.example.android.sportnewsapp;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    /** Constructs a new NewsAdapter
     *
     * @param context of the app
     * @param news is the list of news - data source of adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /** Returns a list item view that displays information of news at the given position in the list */

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

        /**
         * Find the TextView in the news_list_item.xml layout
         */
        TextView title = (TextView) listItemView.findViewById(R.id.title);
        /**
         * Get the title from the current News object and set this value on the title TextView
         */
        title.setText(currentNews.getNewsTitle());

        /**
         * Find the TextView in the news_list_item.xml layout
         */
        TextView category = (TextView) listItemView.findViewById(R.id.category);
        /**
         * Get the category from the current News object and set this value on the category TextView
         */
        category.setText(currentNews.getNewsCategory());

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
        TextView date = (TextView) listItemView.findViewById(R.id.date);
        /**
         * Get the date from the current News object and set this value on the date TextView
         */
        date.setText(currentNews.getNewsDate());

        /** Return the list item view */
        return listItemView;
    }
}
