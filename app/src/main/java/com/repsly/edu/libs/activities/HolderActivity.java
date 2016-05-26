package com.repsly.edu.libs.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.testing.eventbustest.R;
import com.repsly.edu.libs.fragments.MapFragment;

/**
 * Created by Alen on 26.5.2016..
 */
public class HolderActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.holder_activity);
        setUpFragment();

    }

    private void setUpFragment(){
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_frame, new MapFragment(), "map")
                .commit();
    }
}
