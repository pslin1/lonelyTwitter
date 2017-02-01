package ca.ualberta.cs.lonelytwitter;

import android.text.method.DateKeyListener;

import java.util.Date;

/**
 * Created by pslin on 1/17/17.
 */
public abstract class Mood {
    private Date date;


    /**
     * Instantiates a new Mood.
     *
     * @param date the date
     */
    public Mood (Date date) {
        this.date = date;

    }

    /**
     * Instantiates a new Mood.
     */
    public Mood () {
        this.date = new Date();

    }

    /**
     * Gets mood.
     *
     * @return the mood
     */
    public abstract String getMood();

    /**
     * Gets date.
     *
     * @return the date
     */
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

}
