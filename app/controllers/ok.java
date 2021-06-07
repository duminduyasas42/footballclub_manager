package controllers;


import CLI.FootballClub;
import CLI.Match;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import play.api.libs.json.Json;
import play.mvc.Controller;
import play.mvc.Result;
import CLI.PremierLeagueManager;

import java.io.IOException;
import java.util.ArrayList;


public class ok extends Controller {
    PremierLeagueManager manager=new PremierLeagueManager();

    public Result postTest() {
        

        ObservableList<FootballClub> club_list = null;
        Gson gson = new Gson();
        try {
            club_list=manager.getclubsforgui();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jasonString = gson.toJson(club_list);



        return ok(jasonString);
    }
    public Result getmatches() {


        ObservableList<Match> match_list = null;
        Gson gson = new Gson();
        try {
            match_list=manager.getmatchsforgui();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jasonString = gson.toJson(match_list);



        return ok(jasonString);
    }
    public Result matchesRandom() {
        manager.randomMatchCreaterGuiAnguler();




        return ok("ok");
    }
    public Result sortgoals() {
        manager.sortgoalanguler();




        return ok("ok");
    }
    public Result sortwin() {
        manager.sortWinanguler();




        return ok("ok");
    }
    public Result matchsearch(int day,int month,int year) {


        ObservableList<Match> match_list = null;
        Gson gson = new Gson();
        match_list=manager.search(day, month, year);


        String jasonString = gson.toJson(match_list);



        return ok(jasonString);
    }

}
