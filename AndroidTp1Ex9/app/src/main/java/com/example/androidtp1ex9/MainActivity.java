package com.example.androidtp1ex9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class MainActivity extends Activity {

    CalendarView calendrier;
    String date;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendrier = findViewById(R.id.calender);

        calendrier.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth){
                date = dayOfMonth + "-" + (month + 1) + "-" + year;
            }
        });

        (findViewById(R.id.voirEvent)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

        (findViewById(R.id.creerEvent)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String ev = calendrier.getDate()+ " : ";
                        Intent i = new Intent(MainActivity.this, ActivityEvent.class);
                        int codeReq = 1;
                        i.putExtra("event",ev);
                        startActivityForResult(i,codeReq);
                    }
                });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 1) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {

            }
        }
    }
}
