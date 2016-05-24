package com.repsly.edu.libs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testing.eventbustest.R;
import com.repsly.edu.libs.models.OneModel;
import com.repsly.edu.libs.models.ParcelTest;
import com.repsly.edu.libs.models.UserSearch;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Showing use of EventBus and some other stuff.
 */
public class SecondActivity extends Activity implements View.OnClickListener {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seconds_activity);
        tv = (TextView) findViewById(R.id.tv_text);
        findViewById(R.id.btnGoToThird).setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            ParcelTest pt = b.getParcelable("pt");
            if (pt != null) {
                Toast.makeText(getApplicationContext(),
                               "I got: " + pt.getName() + " " + pt.getAge() + " " + pt
                                       .getHowLong() + " " + pt.isGood(), Toast.LENGTH_SHORT)
                     .show();
                Toast.makeText(getApplicationContext(),
                               "And its object inside: " + pt.getOmt().getDa() + " " + pt.getOmt()
                                                                                         .isHa(),
                               Toast.LENGTH_SHORT)
                     .show();
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGoToThird:
                Intent i = new Intent(getApplicationContext(), ViewGenerationActivity.class);
                startActivity(i);
                break;
        }
    }

    @Subscribe
    public void heyHoLetsGo(List<OneModel> models) {
        String da = "";
        for (int i = 0; i < models.size(); i++) {
            da += models.get(i).user + ";" + models.get(i).htmlUrl + "\n\n\n";
        }
        tv.setText(da);
        Toast.makeText(getApplicationContext(),
                       "Here, I GOT HIM!!",
                       Toast.LENGTH_SHORT).show();
    }

    @Subscribe
    public void blabla(List<OneModel> models) {
        Toast.makeText(getApplicationContext(),
                       "Also, this other method got it. This is cool.",
                       Toast.LENGTH_LONG).show();
    }

    @Subscribe
    public void showSearchResults(UserSearch userSearch) {
        String da = "";
        for (int i = 0; i < userSearch.items.size(); i++) {
            da += userSearch.items.get(i).login + ";" + userSearch.items
                    .get(i).avatarUrl + "\n\n\n";
        }
        tv.setText(da);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}

