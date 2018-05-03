package com.boucharalaura.mytennistracker;

/**
 * Created by BoucharaLaura on 26/04/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBGestionnaire {

    private static final int DB_VERSION = 2;
    private static final String DB_NAME = "tennismatch.db";

    private static final int NUM_COL_PLAYER1 = 1;
    private static final int NUM_COL_PLAYER2 = 2;
    private static final int NUM_COL_SCORE = 3;
    private static final int NUM_COL_PLACE = 4;
    private static final int NUM_COL_DATE = 5;
    private static final int NUM_COL_STATISTIC = 6;
    private SQLiteDatabase database;
    private DataBase myDataBase;


    public DBGestionnaire(Context context) {
        this.myDataBase = new DataBase(context, DB_NAME, null, DB_VERSION);
    }

    //Open access to the data base
    public void open(Context context) { database = myDataBase.getWritableDatabase(); }

    //Close access to the data base
    public void close() { database.close(); }


    public SQLiteDatabase getDB() { return database; }

    public ArrayList<TennisMatch> getAllMatches() {
        //String sql = "SELECT * FROM " + DataBase.TABLE;
        Cursor c = database.query(DataBase.TABLE, new String[] {DataBase.COL_ID, DataBase.COL_PLAYER1, DataBase.COL_PLAYER2, DataBase.COL_SCORE, DataBase.COL_PLACE, DataBase.COL_DATE, DataBase.COL_STATISTIC}, null, null, null, null, null);

        if (c.getCount() == 0) return null;

        ArrayList<TennisMatch> matchesList = new ArrayList<>();
        c.moveToFirst();
        matchesList.add(cursorToMatch(c));

        while(c.moveToNext()) {
            matchesList.add(cursorToMatch(c));
        }

        //On ferme le cursor
        c.close();

        return matchesList;
    }

    //Convert a cursor element to a tennis match
    private TennisMatch cursorToMatch(Cursor c) {
        TennisMatch match = new TennisMatch();
        match.setPlayers(c.getString(NUM_COL_PLAYER1), c.getString(NUM_COL_PLAYER2));
        match.setScore(c.getString(NUM_COL_SCORE));
        match.setPlace(c.getString(NUM_COL_PLACE));
        match.setDate(c.getString(NUM_COL_DATE));
        match.setStatistic(c.getString(NUM_COL_STATISTIC));

        //On retourne le match
        return match;
    }

    //Insert match in the data base
    public long insertMatch(TennisMatch match) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(DataBase.COL_PLAYER1, match.getPlayers().get(0));
        values.put(DataBase.COL_PLAYER2, match.getPlayers().get(1));
        values.put(DataBase.COL_SCORE, match.getScore());
        values.put(DataBase.COL_PLACE, match.getPlace());
        values.put(DataBase.COL_DATE, match.getDate());
        values.put(DataBase.COL_STATISTIC, match.getStatistic());
        //on insère l'objet dans la BDD via le ContentValues
        return database.insert(DataBase.TABLE, null, values);
    }
}