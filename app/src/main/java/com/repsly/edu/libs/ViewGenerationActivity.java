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

public class ViewGenerationActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_generation);
        ButterKnife.bind(this);
        tvHelloWorld.setText("tralala");
        btn1.setText("Hey gho.");

    }
    @BindView(R.id.tvHelloWorld) TextView tvHelloWorld;
    @BindView(R.id.button) Button btn1;

    @OnClick(R.id.button) void onButtonClick() {
        //TODO implement
    }

    @OnLongClick(R.id.button) boolean onButtonLongClick() {
        Toast.makeText(getApplicationContext(), "Trala la la, long click!", Toast.LENGTH_SHORT).show();
        btn1.setText("long klik na btn1");
        return true;
    }


    @OnClick(R.id.button2) void onButton2Click() {
        //TODO implement
    }

    @OnLongClick(R.id.button2) boolean onButton2LongClick() {
        //TODO implement
        return true;
    }

    @OnClick(R.id.button5) void onButton5Click() {
        //TODO implement
    }

    @OnLongClick(R.id.button5) boolean onButton5LongClick() {
        //TODO implement
        return true;
    }

    @OnClick(R.id.button3) void onButton3Click() {
        //TODO implement
    }

    @OnLongClick(R.id.button3) boolean onButton3LongClick() {
        //TODO implement
        return true;
    }

    @OnClick(R.id.button4) void onButton4Click() {
        //TODO implement
    }

    @OnLongClick(R.id.button4) boolean onButton4LongClick() {
        //TODO implement
        return true;
    }

    @OnClick(R.id.button6) void onButton6Click() {
        //TODO implement
    }

    @OnLongClick(R.id.button6) boolean onButton6LongClick() {
        //TODO implement
        return true;
    }

    @OnClick(R.id.button7) void onButton7Click() {
        //TODO implement
    }

    @OnLongClick(R.id.button7) boolean onButton7LongClick() {
        //TODO implement
        return true;
    }
}
