package com.example.alexylefevreetuumontpellierfr.tp2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactsOpenHelper extends SQLiteOpenHelper {
    public static final String CONTACT_KEY = "id";
    public static final String CONTACT_NUMERO = "numero";
    public static final String CONTACT_NOM = "nom";
    public static final String CONTACT_PRENOM = "prenom";


    public static final String CONTACT_TABLE_NAME = "contact";

    public static final String CONTACT_TABLE_CREATE =
            "CREATE TABLE " + CONTACT_TABLE_NAME + " (" +
                    CONTACT_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CONTACT_PRENOM + " TEXT NOT NULL," +
                    CONTACT_NOM + " TEXT CHECK (" + CONTACT_PRENOM + " NOT NULL)," +
                    CONTACT_NUMERO + " TEXT NOT NULL);";



    public static final String CONTACT_TABLE_DROP = "DROP TABLE IF EXISTS " + CONTACT_TABLE_NAME + ";";


    public ContactsOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CONTACT_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CONTACT_TABLE_DROP);
        onCreate(db);
    }

}
