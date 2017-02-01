package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by pslin on 1/17/17.
 */
public class mood1 extends Mood {
    /**
     * Instantiates a new Mood 1.
     *
     * @param date the date
     */
    public mood1(Date date) {
        super(date);
    }

    /**
     * Instantiates a new Mood 1.
     */
    public mood1() {
    }

    public String getMood() {
        return "I am happy";
    }
}
