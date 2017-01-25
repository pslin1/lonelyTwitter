package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pslin on 1/17/17.
 */

public abstract class Tweet implements Tweetable{
    private Date date;
    private String message;
    public ArrayList<Mood> moodList;
    //private String hiddenString;

    public Tweet(Date date, String message) throws TweetTooLongException {
        this.date = date; //can pass in date manually
        this.setMessage(message);
    }

    public Tweet(String message) throws TweetTooLongException {
        this.setMessage(message);
        this.date = new Date(); // current time and date, created automatically if no date specified
    }

    public abstract Boolean isImportant(); //all child classes have to implement this, how we do it can vary for each child class

    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

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
