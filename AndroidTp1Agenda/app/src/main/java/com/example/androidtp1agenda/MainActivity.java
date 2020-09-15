package com.example.androidtp1agenda;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends Activity {

DatePickerDialog.OnDateSetListener md;
String dateChoisie = "";
TextView tv;
EditText et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.date);


    findViewById(R.id.dateBouton).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Calendar cal = Calendar.getInstance();


            int day = cal.get(Calendar.DAY_OF_MONTH);
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);

            DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,md,year,month,day);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        }
    });

    md = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            month++;
            dateChoisie = dayOfMonth+"/"+month+"/"+year;
            tv = findViewById(R.id.textDate);
            tv.setText(dateChoisie);
        }
    };


    findViewById(R.id.submitButton).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(et.getText().toString()=="" || dateChoisie==""){
                Toast.makeText(MainActivity.this, R.string.demande, Toast.LENGTH_LONG).show();
            } else {
                Intent i2 = new Intent();
                i2.putExtra("date",dateChoisie);
                i2.putExtra("event", et.getText().toString());
                setResult(RESULT_OK,i2);
                finish();
            }
        }
    });

    }
}
