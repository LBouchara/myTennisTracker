package com.boucharalaura.mytennistracker;

/**
 * Created by BoucharaLaura on 26/04/2018.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class InsertData extends Fragment implements View.OnClickListener {

    public InsertData() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DisplayData.
     */
    public static InsertData newInstance() {
        InsertData fragment = new InsertData();
        return fragment;
    }
    public void insert(FragmentActivity activity, TennisMatch match){
        try{
            DBGestionnaire gestionnaire = new DBGestionnaire(activity);
            gestionnaire.open(activity);
            gestionnaire.insertMatch(match);
        } catch (Exception E) {
            Toast.makeText(null, E.toString(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == (R.id.record)) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tennis_match_recorder,
                container, false);
        Button record = (Button) view.findViewById(R.id.record);

        record.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TextView first_player = (TextView)  getView().findViewById(R.id.player1);
                TextView second_player = (TextView)  getView().findViewById(R.id.player2);
                TextView score_first_player = (TextView)  getView().findViewById(R.id.score_player1);
                TextView score_scond_player = (TextView)  getView().findViewById(R.id.score_player2);
                TextView place = (TextView)  getView().findViewById(R.id.place);
                TextView date = (TextView)  getView().findViewById(R.id.date);
                TextView stat_first_player = (TextView)  getView().findViewById(R.id.stat_player1);
                TextView stat_second_player = (TextView)  getView().findViewById(R.id.stat_player2);
                String first_player_v = first_player.getText().toString();
                String second_player_v = second_player.getText().toString();
                String score_first_player_v = score_first_player.getText().toString();
                String score_scond_player_v = score_scond_player.getText().toString();
                String place_v = place.getText().toString();
                String date_v = date.getText().toString();
                String stat_first_player_v = stat_first_player.getText().toString();
                String stat_second_player_v = stat_second_player.getText().toString();

                TennisMatch match = new TennisMatch(first_player_v, second_player_v, score_first_player_v + " - " + score_scond_player_v, place_v, date_v, stat_first_player_v + " - " + stat_second_player_v);

                new InsertData().insert(getActivity(), match);
            }
        });

        return view;
    }
}