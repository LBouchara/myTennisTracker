package com.boucharalaura.mytennistracker;

/**
 * Created by BoucharaLaura on 26/04/2018.
 */

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InsertData.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InsertData#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertData extends Fragment implements View.OnClickListener {
    private OnFragmentInteractionListener mListener;

    public InsertData() {
    }

    public static InsertData newInstance() {
        InsertData fragment = new InsertData();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return null;
    }

    public void insert(FragmentActivity activity){
        try{
            DBGestionnaire gestionnaire = new DBGestionnaire(activity);
            gestionnaire.open(activity);

            ArrayList<TennisMatch> matches = new ArrayList<>();
            TennisMatch match1 = new TennisMatch("Player 1", "Player 2", "0 - 0", "Wimbledon", "27/04/2018", "3 - 2");
            TennisMatch match2 = new TennisMatch("Player 1", "Player2", "4 - 1", "Roland Garros", "01/05/2018", "5 - 3");
            matches.add(match1);
            matches.add(match2);
            for(TennisMatch match : matches) {
                gestionnaire.insertMatch(match);
            }
        } catch (Exception E) {
            Toast.makeText(getContext(), E.toString(), Toast.LENGTH_LONG).show();
        }
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

    @Override
    public void onClick(View view) {
        //switch (view.getId()) {
            //case R.id.button3:
             //   break;
        //}
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