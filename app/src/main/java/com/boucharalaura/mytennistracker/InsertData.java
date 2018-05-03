package com.boucharalaura.mytennistracker;

/**
 * Created by BoucharaLaura on 26/04/2018.
 */

import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import java.util.ArrayList;


public class InsertData {
    private final TennisMatch MATCH1 = new TennisMatch("Player 1", "Player 2", "0 - 0", "Wimbledon", "27/04/2018", "3 - 2");
    private final TennisMatch MATCH2 = new TennisMatch("Player 1", "Player2", "4 - 1", "Roland Garros", "01/05/2018", "5 - 3");

    public InsertData() {
    }

    public static InsertData newInstance() {
        InsertData data = new InsertData();
        return data;
    }

    public void insert(FragmentActivity activity){
        try{
            DBGestionnaire gestionnaire = new DBGestionnaire(activity);
            gestionnaire.open(activity);

            ArrayList<TennisMatch> matches = new ArrayList<>();
            matches.add(MATCH1);
            matches.add(MATCH2);
            for(TennisMatch match : matches) {
                gestionnaire.insertMatch(match);
            }
        } catch (Exception E) {
            Toast.makeText(null, E.toString(), Toast.LENGTH_LONG).show();
        }
    }
}