package com.example.alexylefevreetuumontpellierfr.tp2;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class ContactsDAO extends DAOBase {
    public static final String TABLE_NAME = "contact";
    public static final String KEY = "id";
    public static final String NOM = "nom";
    public static final String PRENOM = "prenom";
    public static final String NUMERO = "numero";


    public static final String CONTACT_TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PRENOM + " TEXT NOT NULL," +
                    NOM + " TEXT CHECK (" + PRENOM + " NOT NULL)," +
                    NUMERO + " TEXT NOT NULL);";

    public static final String TABLE_DROP =  "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public ContactsDAO(Context c){
        super(c);
    }


    public void ajouter(Contacts c) {

        ContentValues value = new ContentValues();
        value.put(ContactsDAO.PRENOM, c.getPrenom());
        value.put(ContactsDAO.NOM, c.getNom());
        value.put(ContactsDAO.NUMERO, c.getNumero());
        mDb.insert(ContactsDAO.TABLE_NAME, null, value);

    }


    public Cursor selectionner() {
        Cursor cursor = mDb.rawQuery("SELECT * FROM " + TABLE_NAME + ";", null);
        return cursor;
    }

    public Cursor selectContact(String prenom, String nom, String numero){
        Cursor cursor = mDb.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " +
                PRENOM + " = ? AND " +
                NOM + " = ? AND " +
                NUMERO + " = ? ;", new String[] {prenom,nom,numero});
        return cursor;
    }
}
