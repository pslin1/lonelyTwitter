package ca.ualberta.cs.lonelytwitter;

import android.text.method.DateKeyListener;

import java.util.Date;

/**
 * Created by pslin on 1/17/17.
 */

public abstract class Mood {
    private Date date;


    public Mood (Date date) {
        this.date = date;

    }

    public Mood () {
        this.date = new Date();

    }

    public abstract String getMood();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
