package com.boucharalaura.mytennistracker;

/**
 * Created by BoucharaLaura on 26/04/2018.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DataBase extends SQLiteOpenHelper {

    public static final String TABLE = "match";
    public static final String COL_ID = "ID";
    public static final String COL_PLAYER1 = "PLAYER1";
    public static final String COL_PLAYER2 = "PLAYER2";
    public static final String COL_SCORE = "SCORE";
    public static final String COL_PLACE = "PLACE";
    public static final String COL_DATE = "DATE";
    public static final String COL_STATISTIC = "STATISTIC";


    public static final String CREATE_BDD = "CREATE TABLE " + TABLE + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_PLAYER1 + " TEXT NOT NULL, "
            + COL_PLAYER2 + " TEXT NOT NULL, " + COL_SCORE + " TEXT NOT NULL, " + COL_PLACE + " TEXT NOT NULL,"
            + COL_DATE + " TEXT NOT NULL, " + COL_STATISTIC + " TEXT NOT NULL);";

    public DataBase(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //on créé la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut faire ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
        //comme ça lorsque je change la version les id repartent de 0
        String rq = "DROP TABLE " + TABLE + ";";
        db.execSQL(rq);
        onCreate(db);
    }
}
