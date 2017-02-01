package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pslin on 1/17/17.
 * <p>
 * Tweet class is a super class that implements Tweetable
 */
public abstract class Tweet implements Tweetable{
    private Date date;
    private String message;
    /**
     * The Mood list.
     */
    public ArrayList<Mood> moodList;
    //private String hiddenString;

    /**
     * Instantiates a new Tweet.
     *
     * @param date    the date
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public Tweet(Date date, String message) throws TweetTooLongException {
        this.date = date; //can pass in date manually
        this.setMessage(message);
    }

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public Tweet(String message) throws TweetTooLongException {
        this.setMessage(message);
        this.date = new Date(); // current time and date, created automatically if no date specified
    }

    /**
     * Is important boolean.
     *
     * @return the boolean
     */
    public abstract Boolean isImportant(); //all child classes have to implement this, how we do it can vary for each child class

    public Date getDate() {
        return date;
    }


    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public void setMessage(String message) throws TweetTooLongException {
        if(message.length() > 144) {
            //todo throw new error here
            throw new TweetTooLongException();
        } else {
            this.message = message;
        }
        this.message = message;
    }

    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }
}
