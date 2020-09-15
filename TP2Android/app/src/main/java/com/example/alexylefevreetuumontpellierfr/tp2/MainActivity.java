package com.example.alexylefevreetuumontpellierfr.tp2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends Activity {

    private EditText etFN,etLN,etTN;
    private final static String MA_CLE = "MaCle";
    private int compteur = 0;
    private String contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contact = "";



        findViewById(R.id.addContact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //////////////////////// CONSTRUCTION DU STRING CONTACT POUR L'ECRIRE DANS LE FICHIER

                contact = "";

                etFN = findViewById(R.id.firstname);
                contact = contact + etFN.getText().toString()+ "-"; //// AJOUT SEPARATEUR ENTRE PRENOM ET NOM

                etLN = findViewById(R.id.lastname);
                contact = contact + etLN.getText().toString()+ "-"; //// AJOUT SEPARATEUR ENTRE NOM ET NUMERO

                etTN = findViewById(R.id.telnum);
                contact = contact + etTN.getText().toString();

                ////////////////////// SI TOUS LES CHAMPS SONT REMPLIS ALORS ON ECRIT LE CONTACT DANS LE FICHIER
                ////////////////////// SINON ON AFFICHE UN TOAST QUI INDIQUE A L'UTILISATEUR DE REMPLIR LES CHAMPS

                if( etFN.getText().toString().equals("") || etLN.getText().toString().equals("") || etTN.getText().toString().equals("") ) {
                    Toast.makeText(MainActivity.this, R.string.fill, Toast.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(MainActivity.this, ActivityContact.class);

                    try {
                        FileOutputStream fichier = openFileOutput("savedContacts.txt", Context.MODE_PRIVATE);
                        contact = contact + ";"; ///////// AJOUT SEPARATION ENTRE LES CONTACTS
                        fichier.write(contact.getBytes());
                        fichier.close();


                        ///////////////////////// LANCEMENT DU SERVICE QUI VERIFIE/AJOUTE CONTACT A LA BDD

                        Intent iServ = new Intent(MainActivity.this, ContactService.class);
                        startService(iServ);


                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "FICHIER NON CREE", Toast.LENGTH_LONG).show();
                    }

                    startActivity(i);
                }

            }
        });

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Toast.makeText(this, "onSave()",
                Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);

        if ((savedInstanceState != null) && (savedInstanceState.containsKey(MA_CLE))){
            int cpt = savedInstanceState.getInt(MA_CLE);
            Toast.makeText(this, "onRestore()" + cpt,
                    Toast.LENGTH_SHORT).show();
        }

    }




    @Override
    protected void onResume() {
        super.onResume();
        compteur++;
        Toast.makeText(this,  compteur + " times on this screen",
                Toast.LENGTH_SHORT).show();
    }

}
