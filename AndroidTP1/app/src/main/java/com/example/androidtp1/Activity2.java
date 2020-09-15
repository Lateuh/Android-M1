package com.example.androidtp1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends Activity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        Intent i = getIntent();

        tv = (TextView) findViewById(R.id.nom);
        tv.setText(i.getStringExtra("nom"));

        tv = (TextView) findViewById(R.id.prenom);
        tv.setText(i.getStringExtra("prenom"));

        tv = (TextView) findViewById(R.id.age);
        tv.setText(i.getStringExtra("age"));

        tv = (TextView) findViewById(R.id.domain);
        tv.setText(i.getStringExtra("domain"));

        tv = (TextView) findViewById(R.id.numtel2);
        tv.setText(i.getStringExtra("numtel"));





        (findViewById(R.id.retourButton)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });

        (findViewById(R.id.okButton)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i3 = new Intent(Activity2.this, Activity3.class);


                        i3.putExtra("numtel2", tv.getText().toString());


                        startActivity(i3);
                    }
                });

    }
}
