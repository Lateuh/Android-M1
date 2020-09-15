package com.example.androidtp1ex8;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    EditText etD,etA;
    String vD,vA = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etD = findViewById(R.id.depart);
        etA = findViewById(R.id.arrivee);


            (findViewById(R.id.submitButton)).
                    setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            vD = etD.getText().toString().toLowerCase();
                            vA = etA.getText().toString().toLowerCase();
                            if ((vD.equals("paris") && (vA.equals("montpellier") || vA.equals("lyon"))) || (vD.equals("montpellier") && vA.equals("paris"))) {
                                Intent i = new Intent(MainActivity.this, ActivityHoraire.class);
                                i.putExtra("vD", vD);
                                i.putExtra("vA", vA);
                                startActivity(i);
                            } else {
                                Toast.makeText(MainActivity.this, R.string.pasVille, Toast.LENGTH_LONG).show();
                            }
                        }
                    });
    }



}

