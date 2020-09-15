package com.example.alexylefevreetuumontpellierfr.tp2;

import android.app.IntentService;
import android.content.Intent;
import android.database.Cursor;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class ContactService extends IntentService {

    private StringBuilder sb;
    String[] tabContact;
    private ContactsDAO cdao = new ContactsDAO(this);
    private Cursor cursor;


    public ContactService() {
        super("ContactService");
    }



    @Override
    protected void onHandleIntent(Intent intent) {

            try {
                ///////////////////////// LECTURE DU FICHIER DE CONTACT SAUVEGARDES
                FileInputStream fichier = openFileInput("savedContacts.txt");
                InputStreamReader lecteur = new InputStreamReader(fichier);
                BufferedReader br = new BufferedReader(lecteur);
                sb = new StringBuilder();
                String ligne;
                while((ligne = br.readLine()) != null){
                    sb.append(ligne);
                }

                br.close();
                lecteur.close();
                fichier.close();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(ContactService.this, "IOEXCEPTION", Toast.LENGTH_LONG).show();
            }

            ///////////////////////////// SEPARATION DE TOUS LES CONTACTS
            tabContact = sb.toString().split(";");

            ///////////////////////////// VERIFICATION SI LA BDD CONTIENT BIEN TOUS
            ///////////////////////////// LES CONTACTS QUI SONT DANS LE FICHIER
            for (String s : tabContact) {
                cdao.open(); // OUVERTURE BDD
                String[] prenomNomNumero = s.split("-"); // SEPARATION DU PRENOM NOM ET NUMERO DU CONTACT POUR LE COMPARER A LA BASE
                cursor = cdao.selectContact(prenomNomNumero[0],prenomNomNumero[1],prenomNomNumero[2]); // POSITIONNE CURSOR SUR LE CONTACT S'IL EXISTE
                if(!cursor.moveToNext()){ // S'IL N'EXISTE PAS ALORS ON L'AJOUTE
                    cdao.ajouter(new Contacts(prenomNomNumero[0],prenomNomNumero[1],prenomNomNumero[2]));
                }
                cdao.close(); // ON FERME LA BASE
            }


            stopSelf(); // ON STOP LE SERVICE

    }

}
