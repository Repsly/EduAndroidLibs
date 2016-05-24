package com.repsly.edu.libs;

import android.app.Application;

import com.tumblr.remember.Remember;

/**
 * Application cool class.
 */
public class EventApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Remember.init(getApplicationContext(), "com.example.testing.eventbusttest");
    }
}
