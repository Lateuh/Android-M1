package com.example.alexylefevreetuumontpellierfr.tp2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DAOBase {
    // Nous sommes à la première version de la base
    // Si je décide de la mettre à jour, il faudra changer cet attribut
    protected final static int VERSION = 1;
    // Le nom du fichier qui représente ma base
    protected final static String NOM = "mesContacts.db";

    protected SQLiteDatabase mDb = null;
    protected ContactsOpenHelper monGest = null;



    public DAOBase(Context pContext) {
        this.monGest = new ContactsOpenHelper(pContext, NOM, null, VERSION);
    }

    public void open() {
        // Pas besoin de fermer la dernière base puisque getWritableDatabase s'en charge
        mDb = monGest.getWritableDatabase();
    }

    public void close() {
        mDb.close();
    }

    public SQLiteDatabase getDb() {
        return mDb;
    }
}