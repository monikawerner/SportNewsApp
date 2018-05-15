package com.example.android.sportnewsapp;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Helper methods related to requesting and receiving earthquake data from USGS.
 */
public final class QueryUtils {

    /** Sample JSON response for a TheGuardian query */
    private static final String SAMPLE_JSON_RESPONSE = "{\"response\":{\"status\":\"ok\",\"userTier\":\"developer\",\"total\":174322,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":17433,\"orderBy\":\"relevance\",\"results\":[{\"id\":\"sport/2018/apr/04/commonwealth-games-2018-sport-by-sport-guide\",\"type\":\"article\",\"sectionId\":\"sport\",\"sectionName\":\"Sport\",\"webPublicationDate\":\"2018-04-04T18:46:36Z\",\"webTitle\":\"Commonwealth Games: sport-by-sport guide on the Gold Coast | Martha Kelner\",\"webUrl\":\"https://www.theguardian.com/sport/2018/apr/04/commonwealth-games-2018-sport-by-sport-guide\",\"apiUrl\":\"https://content.guardianapis.com/sport/2018/apr/04/commonwealth-games-2018-sport-by-sport-guide\",\"isHosted\":false,\"pillarId\":\"pillar/sport\",\"pillarName\":\"Sport\"},{\"id\":\"sport/2018/feb/06/uk-sport-looks-forward-to-funding-debate\",\"type\":\"article\",\"sectionId\":\"sport\",\"sectionName\":\"Sport\",\"webPublicationDate\":\"2018-02-06T18:22:22Z\",\"webTitle\":\"UK Sport looks forward to funding debate | Letters\",\"webUrl\":\"https://www.theguardian.com/sport/2018/feb/06/uk-sport-looks-forward-to-funding-debate\",\"apiUrl\":\"https://content.guardianapis.com/sport/2018/feb/06/uk-sport-looks-forward-to-funding-debate\",\"isHosted\":false,\"pillarId\":\"pillar/sport\",\"pillarName\":\"Sport\"},{\"id\":\"world/2018/apr/06/western-australian-hunters-accused-of-releasing-feral-pigs-for-sport\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2018-04-06T05:55:36Z\",\"webTitle\":\"Western Australian hunters accused of releasing feral pigs for sport\",\"webUrl\":\"https://www.theguardian.com/world/2018/apr/06/western-australian-hunters-accused-of-releasing-feral-pigs-for-sport\",\"apiUrl\":\"https://content.guardianapis.com/world/2018/apr/06/western-australian-hunters-accused-of-releasing-feral-pigs-for-sport\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"society/2018/apr/04/british-sport-governing-bodies-significant-gender-pay-gap-football-association-rugby-football-union\",\"type\":\"article\",\"sectionId\":\"society\",\"sectionName\":\"Society\",\"webPublicationDate\":\"2018-04-04T13:07:13Z\",\"webTitle\":\"Significant pay gaps reported by British sport governing bodies\",\"webUrl\":\"https://www.theguardian.com/society/2018/apr/04/british-sport-governing-bodies-significant-gender-pay-gap-football-association-rugby-football-union\",\"apiUrl\":\"https://content.guardianapis.com/society/2018/apr/04/british-sport-governing-bodies-significant-gender-pay-gap-football-association-rugby-football-union\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"commentisfree/2018/apr/01/may-i-have-a-word-about-the-meaning-of-sport\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2018-04-01T05:00:12Z\",\"webTitle\":\"May I have a word about … the meaning of sport? | Jonathan Bouquet\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2018/apr/01/may-i-have-a-word-about-the-meaning-of-sport\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2018/apr/01/may-i-have-a-word-about-the-meaning-of-sport\",\"isHosted\":false,\"pillarId\":\"pillar/opinion\",\"pillarName\":\"Opinion\"},{\"id\":\"tv-and-radio/2018/mar/23/friday-best-tv-sport-relief-britains-favourite-food\",\"type\":\"article\",\"sectionId\":\"tv-and-radio\",\"sectionName\":\"Television & radio\",\"webPublicationDate\":\"2018-03-23T06:00:25Z\",\"webTitle\":\"Friday’s best TV: Sport Relief; Britain’s Favourite Food\",\"webUrl\":\"https://www.theguardian.com/tv-and-radio/2018/mar/23/friday-best-tv-sport-relief-britains-favourite-food\",\"apiUrl\":\"https://content.guardianapis.com/tv-and-radio/2018/mar/23/friday-best-tv-sport-relief-britains-favourite-food\",\"isHosted\":false,\"pillarId\":\"pillar/arts\",\"pillarName\":\"Arts\"},{\"id\":\"commentisfree/2018/mar/16/women-sport-equal-men-bravery-rugby-captain-catherine-spencer\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2018-03-16T09:00:01Z\",\"webTitle\":\"How can women’s sport become equal to men’s? Through bravery | Catherine Spencer\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2018/mar/16/women-sport-equal-men-bravery-rugby-captain-catherine-spencer\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2018/mar/16/women-sport-equal-men-bravery-rugby-captain-catherine-spencer\",\"isHosted\":false,\"pillarId\":\"pillar/opinion\",\"pillarName\":\"Opinion\"},{\"id\":\"commentisfree/2018/mar/11/ethics-and-sport-long-been-strangers-to-one-another-chris-froome-bradley-wiggins\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2018-03-11T06:08:39Z\",\"webTitle\":\"Ethics and sport have long been strangers to one another | Kenan Malik\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2018/mar/11/ethics-and-sport-long-been-strangers-to-one-another-chris-froome-bradley-wiggins\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2018/mar/11/ethics-and-sport-long-been-strangers-to-one-another-chris-froome-bradley-wiggins\",\"isHosted\":false,\"pillarId\":\"pillar/opinion\",\"pillarName\":\"Opinion\"},{\"id\":\"commentisfree/2018/mar/05/the-guardian-view-on-drugs-in-sport-a-deep-corruption\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2018-03-05T18:14:59Z\",\"webTitle\":\"The Guardian view on drugs in sport: a deep corruption | Editorial\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2018/mar/05/the-guardian-view-on-drugs-in-sport-a-deep-corruption\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2018/mar/05/the-guardian-view-on-drugs-in-sport-a-deep-corruption\",\"isHosted\":false,\"pillarId\":\"pillar/opinion\",\"pillarName\":\"Opinion\"},{\"id\":\"books/2017/dec/02/best-sport-books-2017\",\"type\":\"article\",\"sectionId\":\"books\",\"sectionName\":\"Books\",\"webPublicationDate\":\"2017-12-02T09:00:08Z\",\"webTitle\":\"The best books on sport of 2017\",\"webUrl\":\"https://www.theguardian.com/books/2017/dec/02/best-sport-books-2017\",\"apiUrl\":\"https://content.guardianapis.com/books/2017/dec/02/best-sport-books-2017\",\"isHosted\":false,\"pillarId\":\"pillar/arts\",\"pillarName\":\"Arts\"}]}}";
    /**
     * Create a private constructor because no one should ever create a {@link QueryUtils} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private QueryUtils() {
    }

    /**
     * Return a list of News objects that has been built up from
     * parsing a JSON response.
     */
    public static ArrayList<News> extractNews() {

        // Create an empty ArrayList that we can start adding news to
        ArrayList<News> news = new ArrayList<>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            JSONObject baseJsonResponse = new JSONObject(SAMPLE_JSON_RESPONSE);
            JSONArray newsArray = baseJsonResponse.getJSONArray("results");

            for(int i = 0; i < newsArray.length(); i++) {
                JSONObject currentNews = newsArray.getJSONObject(i);
                String title = currentNews.getString("webTitle");
                String category = currentNews.getString("sectionName");
                String author = currentNews.getString("webTitle");
                String date = currentNews.getString("webPublicationDate");

                News newsObject = new News(title, category, author, date);
                news.add(newsObject);
            }


        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the news JSON results", e);
        }

        // Return the list of news
        return news;
    }

}
