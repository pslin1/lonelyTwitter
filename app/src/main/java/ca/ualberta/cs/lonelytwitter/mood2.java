package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by pslin on 1/17/17.
 */

public class mood2 extends Mood {
    public mood2(Date date, String mood) {
        super(date, mood);
    }

    public mood2(String mood) {
        super(mood);
    }

    @Override
    public String getMood() {
        return "I am sad";
    }
}
