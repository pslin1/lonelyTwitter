package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by pslin on 1/17/17.
 */
public class mood2 extends Mood {
    /**
     * Instantiates a new Mood 2.
     *
     * @param date the date
     */
    public mood2(Date date) {
        super(date);
    }

    /**
     * Instantiates a new Mood 2.
     */
    public mood2() {
    }

    public String getMood() {
        return "I am sad";
    }
}
