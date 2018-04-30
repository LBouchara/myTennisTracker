package com.boucharalaura.mytennistracker;

/**
 * Created by BoucharaLaura on 26/04/2018.
 */

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DisplayData.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DisplayData#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplayData extends Fragment {
    public View rootView;

    public TextView players;
    public TextView score;
    public TextView place;
    public TextView date;
    public TextView statistic;
    private OnFragmentInteractionListener mListener;

    public DisplayData() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DisplayData.
     */
    public static DisplayData newInstance() {
        DisplayData fragment = new DisplayData();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.content_tennis_traker, container, false);

        new InsertData().insert(getActivity());
        DBGestionnaire gestionnaire = new DBGestionnaire(getActivity());
        gestionnaire.open(getActivity());
        ArrayList<TennisMatch> matchesList = gestionnaire.getAllMatches();

        String playersData;
        String scoreData;
        String placeData;
        String dateData;
        String statisticData;

        if(matchesList != null) {
            TableLayout tableLayoutMatch = new TableLayout(getContext());
            for(int i=0 ; i<matchesList.size(); i ++) {
                playersData = matchesList.get(i).getPlayers().get(0) + " - " + matchesList.get(i).getPlayers().get(1);
                scoreData = matchesList.get(i).getScore();
                placeData = matchesList.get(i).getPlace();
                dateData = matchesList.get(i).getDate();
                statisticData = matchesList.get(i).getStatistic();

                TableRow match = new TableRow(this.getContext());
                match.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                TableLayout matchInformation = new TableLayout(this.getContext());
                matchInformation.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                TableRow matchMoreInformation = new TableRow(this.getContext());
                matchMoreInformation.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                TextView players = new TextView(this.getContext());
                players.setText(playersData);
                players.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                TextView score = new TextView(this.getContext());
                score.setText(scoreData);
                score.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                matchMoreInformation.addView(players);
                matchMoreInformation.addView(score);

                TableRow matchMainInformation = new TableRow(this.getContext());
                matchMainInformation.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                TextView place = new TextView(this.getContext());
                place.setText(placeData);
                place.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                TextView date = new TextView(this.getContext());
                date.setText(dateData);
                date.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                matchMoreInformation.addView(place);
                matchMoreInformation.addView(date);

                TableRow matchStatistic = new TableRow(this.getContext());
                matchStatistic.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                TextView statistic = new TextView(this.getContext());
                statistic.setText(statisticData);
                statistic.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                matchMoreInformation.addView(statistic);

                matchInformation.addView(matchMoreInformation);
                matchInformation.addView(matchMainInformation);
                matchInformation.addView(matchStatistic);

                match.addView(matchInformation);
                tableLayoutMatch.addView(match);
            }
        }
        return rootView;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    public void setText(String txtPlayers, String txtScore, String txtPlace, String txtDate, String txtStatistic) {
        players.setText(txtPlayers);
        score.setText(txtScore);
        place.setText(txtPlace);
        date.setText(txtDate);
        statistic.setText(txtStatistic);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}