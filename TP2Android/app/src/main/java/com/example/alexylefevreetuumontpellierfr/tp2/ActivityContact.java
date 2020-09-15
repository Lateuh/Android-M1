package com.example.alexylefevreetuumontpellierfr.tp2;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class ActivityContact extends Activity {

    private ListView lv;
    private ArrayAdapter<String> aa;
    private ArrayList<String> contacts = new ArrayList<>();
    private Cursor cursor;
    private ContactsDAO cdao = new ContactsDAO(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        /////////////////// UTILISATION DE SQLITE POUR AFFICHER TOUS LES CONTACTS

        ////////////////// OUVERTURE DE LA BDD
        cdao.open();

        ///////////////// ON POSITIONNE LE CURSEUR SUR CHAQUE LIGNE DE LA TABLE ET ON AJOUTE A LA LISTE CONTACTS
        cursor = cdao.selectionner();
        while(cursor.moveToNext()){
            contacts.add(cursor.getString(1) + " " + cursor.getString(2) + " - " + cursor.getString(3));
        }

        cdao.close();/////////////// FERMETURE BDD



        ////////////////// CREATION DE LA LISTVIEW A PARTIR DE LA LISTE CONTACTS
        lv = findViewById(R.id.listContact);
        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        lv.setAdapter(aa);

    }

}
