package com.example.androidtp1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ex3 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout monLinear = new LinearLayout(this);
        monLinear.setOrientation(LinearLayout.VERTICAL);

        EditText et_nom = new EditText(this);
        et_nom.setHint("Entrez votre nom");

        EditText et_prenom = new EditText(this);
        et_prenom.setHint("Entrez votre prenom");

        EditText et_domaine = new EditText(this);
        et_domaine.setHint("Entrez votre domaine");

        EditText et_numTel = new EditText(this);
        et_numTel.setHint("Entrez votre numero de tel");
        et_numTel.setInputType(2);

        EditText et_age = new EditText(this);
        et_age.setHint("Entrez votre age");
        et_age.setInputType(2);


        Button submit_button = new Button(this);
        submit_button.setText("Valider");


        monLinear.addView(et_nom);
        monLinear.addView(et_prenom);
        monLinear.addView(et_domaine);
        monLinear.addView(et_numTel);
        monLinear.addView(et_age);
        monLinear.addView(submit_button);




        setContentView(monLinear);
    }
}
