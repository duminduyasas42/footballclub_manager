package CLI;

import javafx.collections.ObservableList;

import java.io.IOException;


public interface LeagueManager {
    public void addClub();

    public void findClub();
    public void clubTable();
    public void deleteClub(String a);

    public void addmatch();

    public void objectInputStream() throws IOException;
    public void objectOutputStream() throws IOException;
    public void objectOutputStream1()throws IOException;
    public void readmatch()throws IOException;
    public void randomMatchCreater();
    public String search(String day,String month,String year);
    public void sort1();
    public void sort2();
    public ObservableList getclubsforgui() throws IOException;
    public ObservableList getmatchsforgui() throws IOException;
    public ObservableList search(int days,int months,int years);
    public void randomMatchCreaterGuiAnguler();
    public void sortgoalanguler();
    public void sortWinanguler();





}