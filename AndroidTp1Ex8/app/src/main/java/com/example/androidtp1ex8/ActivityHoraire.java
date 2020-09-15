package com.example.androidtp1ex8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActivityHoraire extends Activity {

    ArrayAdapter<String> aa;
    ListView lv;
    List<String> arr;


    HashMap<String, HashMap<String, ArrayList<String> >> tabHoraire = null;

    HashMap<String, ArrayList<String>> listeVParis;
    ArrayList<String> listeHParisMtp;

    ArrayList<String> listeHParisLyon;

    HashMap<String, ArrayList<String>> listeVMtp;
    ArrayList<String> listeHMtpParis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horaire);

        tabHoraire = new HashMap<>();


        //  PARIS - MONTPELLIER
        listeVParis = new HashMap<>();
        listeHParisMtp = new ArrayList<>();

        listeHParisMtp.add("8h00");
        listeHParisMtp.add("10h00");
        listeHParisMtp.add("12h00");

        listeVParis.put("montpellier", listeHParisMtp);


        // PARIS - LYON
        listeHParisLyon = new ArrayList<>();

        listeHParisLyon.add("7h00");
        listeHParisLyon.add("11h00");
        listeHParisLyon.add("15h00");
        listeHParisLyon.add("17h00");
        listeHParisLyon.add("18h00");

        listeVParis.put("lyon", listeHParisLyon);

        tabHoraire.put("paris", listeVParis);



        // MONTPELLIER - PARIS
        listeVMtp = new HashMap<>();
        listeHMtpParis = new ArrayList<>();

        listeHMtpParis.add("12h00");
        listeHMtpParis.add("14h00");
        listeHMtpParis.add("16h00");

        listeVMtp.put("paris", listeHMtpParis);

        tabHoraire.put("montpellier", listeVMtp);




        Intent i = getIntent();

        String vD = i.getStringExtra("vD");
        String vA = i.getStringExtra("vA");


        arr = tabHoraire.get(vD).get(vA);


        lv = findViewById(R.id.heure);

        aa = new ArrayAdapter<>(ActivityHoraire.this,android.R.layout.simple_list_item_1,arr);
        lv.setAdapter(aa);


        (findViewById(R.id.retourButton)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });


    }
}
