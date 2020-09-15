package com.example.androidtp1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity3 extends Activity {

    TextView tv;
    Uri uri1;
    String numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);


        Intent i5 = getIntent();

        numero = i5.getStringExtra("numtel2");


        tv = (TextView) findViewById(R.id.numtel3);
        tv.setText(numero);





        findViewById(R.id.callButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri1 = Uri.parse("tel:"+numero);

                Intent i4 = new Intent(Intent.ACTION_DIAL, uri1);
                startActivity(i4);
            }
        });


    }
}
