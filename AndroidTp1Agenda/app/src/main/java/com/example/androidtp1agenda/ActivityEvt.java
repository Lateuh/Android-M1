package com.example.androidtp1agenda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActivityEvt extends Activity {

    ListView lv;
    ListAdapter la;
    List<HashMap<String, String>> laListe = new ArrayList<>();
    HashMap<String, String> evt;
    public final static int codeReq = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evt);

        lv = (ListView) findViewById(R.id.events);



    findViewById(R.id.addEvnt).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(ActivityEvt.this, MainActivity.class);
            startActivityForResult(i, codeReq);
        }
    });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==codeReq){
            if(resultCode==RESULT_OK){
                evt = new HashMap<>();
                evt.put("v1",data.getStringExtra("date"));
                evt.put("v2",data.getStringExtra("event"));
                laListe.add(evt);
                la = new SimpleAdapter(this,laListe,android.R.layout.simple_list_item_2,new String[]{"v1","v2"},new int[]{android.R.id.text1,android.R.id.text2});
                lv.setAdapter(la);
            }
        }
    }
}
