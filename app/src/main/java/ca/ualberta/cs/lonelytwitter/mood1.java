package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by pslin on 1/17/17.
 */

public class mood1 extends Mood {
    public mood1(Date date, String mood) {
        super(date, mood);
    }

    public mood1(String mood) {
        super(mood);
    }

    @Override
    public String getMood() {
        return "I am happy";
    }
}
