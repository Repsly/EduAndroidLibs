package com.repsly.edu.libs;

import android.app.Application;

import com.tumblr.remember.Remember;

/**
 * Created by tomkan on 23.5.2016..
 */
public class EventApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Remember.init(getApplicationContext(), "com.example.testing.eventbusttest");
    }
}
