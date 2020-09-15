package com.example.androidtp1ex9;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ActivityEvent extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Intent i = getIntent();
        String event = i.getStringExtra("event");




    }
}
