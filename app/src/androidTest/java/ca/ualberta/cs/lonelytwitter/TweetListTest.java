package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pslin on 2/14/17.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }




    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void testAddTweet(){
        TweetList tweets= new TweetList();
        Tweet tweet = new NormalTweet("test tweet");


        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Illegal Arguement exception thrown");

        tweets.add(tweet);
        tweets.add(tweet);

    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        TweetList tweets2 = new TweetList();

        Date testDate = new Date("05/05/2018");
        Tweet tweet = new NormalTweet("test tweet" );

        Tweet anotherTweet = new NormalTweet("Another test tweet");

        tweets.add(tweet);
        tweets.add(anotherTweet);

        tweets2.add(tweet);
        tweets2.add(anotherTweet);

        ArrayList<Tweet> returnedList = tweets2.getTweet();
        //Tweet returnedTweet = tweets.getTweet(0);

        assertTrue(returnedList.get(0).getDate().after(returnedList.get(1).getDate())  );

    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Last tweet");

        tweets.add(tweet);
        tweets.delete(tweet);

        assertFalse(tweets.hasTweet(tweet));

    }

    public void testStrings(){
        assertEquals("'test' should be 'test'", "test", "test");
        assertTrue("'test' should start with 't'", "test".startsWith("t"));
    }



}
