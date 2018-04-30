package com.boucharalaura.mytennistracker;

import java.util.ArrayList;

/**
 * Created by BoucharaLaura on 26/04/2018.
 */

public class TennisMatch {
    private ArrayList<String> players = new ArrayList<>();;
    private String score;
    private String place;
    private String date;
    private String statistic;

    public TennisMatch(String player1, String player2, String score, String place, String date, String statistic) {
        this.players.add(player1);
        this.players.add(player2);
        this.score = score;
        this.place = place;
        this.date = date;
        this.statistic = statistic;
    }

    public TennisMatch() {
    }


    public ArrayList<String> getPlayers(){
        return players;
    }

    public void setPlayers(String player1, String player2) {
        this.players.add(player1);
        this.players.add(player2);
    }


    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatistic() {
        return statistic;
    }

    public void setStatistic(String statistic) {
        this.statistic = statistic;
    }

    public String  toString(){
        return "Players name : " + players.get(0) + " - " + players.get(1)
                + "Score : " + score
                + "Place : " + place
                + "Date : " + date
                + "Statistic : " + statistic;}
}
