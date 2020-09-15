package com.example.androidtp1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

    AlertDialog.Builder al;
    EditText etNom, etPrenom, etAge, etDomaine, etNumTel;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex4);



        etNom = (EditText) findViewById(R.id.nom);
        etPrenom = (EditText) findViewById(R.id.prenom);
        etAge = (EditText) findViewById(R.id.age);
        etDomaine = (EditText) findViewById(R.id.domain);
        etNumTel = (EditText) findViewById(R.id.numtel);




        al = new AlertDialog.Builder(MainActivity.this);
        al.setTitle(R.string.titre_confirmer);
        al.setMessage(R.string.confirmer);


        al.setPositiveButton(R.string.oui,new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // a la confirmation

                Intent i1 = new Intent(MainActivity.this, Activity2.class);

                i1.putExtra("nom",etNom.getText().toString());
                i1.putExtra("prenom",etPrenom.getText().toString());
                i1.putExtra("age",etAge.getText().toString());
                i1.putExtra("domain",etDomaine.getText().toString());
                i1.putExtra("numtel",etNumTel.getText().toString());


                startActivity(i1);
            }
        });


        al.setNegativeButton(R.string.non, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // a l'annulation
                Toast.makeText(MainActivity.this, R.string.clic2, Toast.LENGTH_LONG).show();
            }
        });


        al.setNeutralButton(R.string.euh, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // quand on hésite
                etNom.setBackgroundColor(getResources().getColor(R.color.color1));
                etPrenom.setBackgroundColor(getResources().getColor(R.color.color1));
                etAge.setBackgroundColor(getResources().getColor(R.color.color1));
                etDomaine.setBackgroundColor(getResources().getColor(R.color.color1));
                etNumTel.setBackgroundColor(getResources().getColor(R.color.color1));
            }
        });



        (findViewById(R.id.submitButton)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        al.show();
                    }
                });

    }
}
