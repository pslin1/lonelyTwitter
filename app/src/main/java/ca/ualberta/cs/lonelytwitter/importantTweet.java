package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by pslin on 1/17/17.
 */

public class importantTweet extends Tweet {
    public importantTweet(Date date, String message) throws TweetTooLongException {
        super(date, message);
    }

    public importantTweet(String message) throws TweetTooLongException {
        super(message);
    }

    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    @Override //ensures you won't accidentally create a new method
    public String getMessage() {
        return super.getMessage() + " !!!! ";
    }
}
