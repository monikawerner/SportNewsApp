package com.example.android.sportnewsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a fake list of earthquake locations.
        ArrayList<News> news = new ArrayList<>();
        news.add(new News("Gol", "Football", "Monika", "May 13, 2018"));
        news.add(new News("Ball", "Tennis", "Ania", "May 12, 2018"));
        news.add(new News("Not too much", "Volleyball", "Nina", "May 7, 2018"));


        // Find a reference to the {@link ListView} in the layout
        ListView newsListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of news
        NewsAdapter adapter = new NewsAdapter(this, news);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        newsListView.setAdapter(adapter);
    }
}
