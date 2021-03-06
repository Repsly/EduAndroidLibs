package com.repsly.edu.libs;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.testing.eventbustest.R;
import com.getwandup.rxsensor.RxSensor;
import com.getwandup.rxsensor.domain.RxSensorEvent;
import com.repsly.edu.libs.activities.HolderActivity;
import com.repsly.edu.libs.database.DbHandler;
import com.repsly.edu.libs.models.ItemForSending;
import com.repsly.edu.libs.models.OneModel;
import com.repsly.edu.libs.models.OneModelTwo;
import com.repsly.edu.libs.models.ParcelTest;
import com.repsly.edu.libs.models.UserSearch;
import com.repsly.edu.libs.retrofit.GitInterface;
import com.repsly.edu.libs.retrofit.RetrofitImpl;
import com.tumblr.remember.Remember;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;

/**
 * This is where all starts. Here we will only put libs that do something to help us develop better Android apps.
 * Also, it's fine to hardcode strings here. It's cool. Don't worry.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.button10).setOnClickListener(this);
        findViewById(R.id.button11).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        DbHandler dbHandler;
        switch (v.getId()) {
            case R.id.button:
                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(i);
                break;
            case R.id.button2:
                Toast.makeText(getApplicationContext(), "Started downloading...", Toast.LENGTH_SHORT)
                     .show();
                new Async().execute();
                break;
            case R.id.button3:
                dbHandler = new DbHandler(getApplicationContext());
                dbHandler.saveDrool("hey", "ho");
                break;
            case R.id.button4:
                dbHandler = new DbHandler(getApplicationContext());
                Toast.makeText(getApplicationContext(), dbHandler.getFirstDrool(),
                               Toast.LENGTH_SHORT).show();
                break;
            case R.id.button5:
                //using retrofit inside another thread
                new Async2().execute();
                break;
            case R.id.button6:
                //using retrofit with callback
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://requestb.in/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                GitInterface service = retrofit.create(GitInterface.class);
                Call<ItemForSending> yea = service.sendSomething(new ItemForSending("da", 3));
                yea.enqueue(new Callback<ItemForSending>() {
                    @Override
                    public void onResponse(Call<ItemForSending> call,
                                           Response<ItemForSending> response) {
                        if (response.isSuccessful()) {
                            Log.d("Libs debug message", "Yeaaaa, this works!");
                        } else {
                            Log.d("Libs debug message", "Nooo. Fuck.");
                        }
                    }

                    @Override
                    public void onFailure(Call<ItemForSending> call, Throwable t) {

                    }
                });
                break;
            case R.id.button7:
                ParcelTest pt = new ParcelTest("cool name", 2, true, 9000, new OneModelTwo("hey", true));
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("pt", pt);
                Remember.putBoolean("clickedOnBtn7", true);
                startActivity(intent);
                break;
            case R.id.button8:
                Toast.makeText(getApplicationContext(), "Clicked on a btn7: " + Remember.getBoolean("clickedOnBtn7", false), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button9:
                RxSensor rxSensor = new RxSensor(this);
                rxSensor.observe(Sensor.TYPE_ACCELEROMETER, SensorManager.SENSOR_DELAY_NORMAL)
                        .subscribe(new Subscriber<RxSensorEvent>() {
                            @Override
                            public void onCompleted() {
                                Log.d("RxSensor", "event: onCompleted");

                            }
                            @Override
                            public void onError(Throwable e) {
                                Log.d("RxSensor", "event: onError");

                            }

                            @Override
                            public void onNext(RxSensorEvent sensorEvent) {
                                Log.d("RxSensor", "event: " + sensorEvent.toString());
                            }
                        });
                break;
            case R.id.button10:
                new MaterialDialog.Builder(this)
                        .title(R.string.dialog_title)
                        .customView(R.layout.dialog_input,false)
                        .positiveText(R.string.dialog_ok)
                        .negativeText(R.string.dialog_no)
                        .positiveColor(getResources().getColor(R.color.turqouise))
                        .negativeColor(getResources().getColor(R.color.red))
                        .dividerColor(getResources().getColor(R.color.turqouise))
                        .callback(dialogCallback)
                        .show();
                break;
            case R.id.button11:
                startActivity(new Intent(this,HolderActivity.class));
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class Async extends AsyncTask<Void, Void, List<OneModel>> {

        @Override
        protected void onPostExecute(List<OneModel> list) {
            super.onPostExecute(list);
            EventBus.getDefault().post(list);
        }


        @Override
        protected List<OneModel> doInBackground(Void... params) {
            try {
                Thread.sleep(2000);
                RetrofitImpl retro = new RetrofitImpl("https://api.github.com/");
                return retro.getRepos();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private class Async2 extends AsyncTask<Void, Void, UserSearch> {

        @Override
        protected void onPostExecute(UserSearch userSearch) {
            super.onPostExecute(userSearch);
            EventBus.getDefault().post(userSearch);
        }


        @Override
        protected UserSearch doInBackground(Void... params) {
            try {
                Thread.sleep(2000);
                RetrofitImpl retro = new RetrofitImpl("https://api.github.com/")
                        .setSearchName("tom");
                return retro.getSearchResults();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private MaterialDialog.ButtonCallback dialogCallback = new MaterialDialog.ButtonCallback() {
        @Override
        public void onPositive(MaterialDialog dialog) {
            super.onPositive(dialog);
            EditText input = (EditText) dialog.findViewById(R.id.etGiveFive);
            if(input.getText().toString().equals("5")){
                Toast.makeText(getBaseContext(),R.string.dialog_success,Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }else{
                Toast.makeText(getBaseContext(),R.string.dialog_dismiss,Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onNegative(MaterialDialog dialog) {
            super.onNegative(dialog);
        }
    };
}
