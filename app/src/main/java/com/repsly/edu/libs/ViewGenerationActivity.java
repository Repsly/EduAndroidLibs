package com.repsly.edu.libs;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.testing.eventbustest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * Generated from xml -> Plugin -> "Android Code Generator"
 * Used with "Butterknifed" views.
 */
public class ViewGenerationActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_generation);
        ButterKnife.bind(this);
        tvHelloWorld.setText("Butter is cool.");
        btn1.setText("Pet cemetery.");

    }
    @BindView(R.id.tvHelloWorld) TextView tvHelloWorld;
    @BindView(R.id.button) Button btn1;

    @OnLongClick(R.id.button) boolean onButtonLongClick() {
        btn1.setText("You have long clicked on me. What's your problem?");
        return true;
    }

    @OnClick(R.id.button7) void onButton7Click() {
        Toast.makeText(getApplicationContext(), "Hey, I also have feelings!", Toast.LENGTH_SHORT)
             .show();
    }

}
