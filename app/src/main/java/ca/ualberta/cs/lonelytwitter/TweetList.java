package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by pslin on 2/14/17.
 */

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);
    }

    public boolean hasTweet (Tweet tweet){

        return tweets.contains(tweet);
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public ArrayList<Tweet> getTweet(){
        //Taken from http://stackoverflow.com/questions/5927109/sort-objects-in-arraylist-by-date
        //Feb 14, 2017 18:18
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet tweet, Tweet t1) {
                Date a = tweet.getDate();
                Date b = t1.getDate();
                if (a.before(b)) {
                    return -1;
                }
                else if (a.equals(b)) {
                    return 0;
                }
                return 1;
            }
        });
        return tweets;
    }

    public int getCount(){
        return tweets.size();
    }
}
