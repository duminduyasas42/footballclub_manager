package CLI;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;


public class FootballClub extends SportsClub  implements Serializable, Comparable<FootballClub>{

    private static final long serialVersionUID = -1874298607472967827L;

    private int wins;
    private int draws;
    private int defeats;
    private int numGoalsRecieved;
    private int numGoalsScored;
    private int clubPoints;
    private int numMatch;

    public FootballClub(String clubName, String clubAddress, int numMember,int wins, int draws, int defeats, int numGoalsRecieved, int numGoalsScored, int clubPoints, int numMatch) {
        super(clubName,clubAddress,numMember);

        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.numGoalsRecieved = numGoalsRecieved;
        this.numGoalsScored = numGoalsScored;
        this.clubPoints = clubPoints;
        this.numMatch = numMatch;
    }

    public static Set<FootballClub> footballClubs;


    public static Set<FootballClub> allFootballClubs(){
        return footballClubs;
    }
    public static FootballClub findById(String name){
        for(FootballClub footballClub:footballClubs){
            if(name.equals(footballClub.getClubName())){
                return footballClub;

            }
        }
        return null;
    }
    public static void add(FootballClub footballClub){
        footballClubs.add(footballClub);
    }
    public static  boolean remove(FootballClub footballClub){
        return footballClubs.remove(footballClub);
    }


    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getNumGoalsRecieved() {
        return numGoalsRecieved;
    }

    public void setNumGoalsRecieved(int numGoalsRecieved) {
        this.numGoalsRecieved = numGoalsRecieved;
    }

    public int getNumGoalsScored() {
        return numGoalsScored;
    }

    public void setNumGoalsScored(int numGoalsScored) {
        this.numGoalsScored = numGoalsScored;
    }

    public int getClubPoints() {
        return clubPoints;
    }

    public void setClubPoints(int clubPoints) {
        this.clubPoints = clubPoints;
    }

    public int getNumMatch() {
        return numMatch;
    }

    public void setNumMatch(int numMatch) {
        this.numMatch = numMatch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballClub that = (FootballClub) o;
        return wins == that.wins &&
                draws == that.draws &&
                defeats == that.defeats &&
                numGoalsRecieved == that.numGoalsRecieved &&
                numGoalsScored == that.numGoalsScored &&
                clubPoints == that.clubPoints &&
                numMatch == that.numMatch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wins, draws, defeats, numGoalsRecieved, numGoalsScored, clubPoints, numMatch);
    }
    //compare some footballclubs with other football clubs and give the order of the scoreboard
    @Override
    public int compareTo(FootballClub o) {
        int compare=Integer.compare(o.clubPoints,clubPoints);
        if(compare==0){
            compare=Integer.compare(o.numGoalsScored-o.numGoalsRecieved,numGoalsScored-numGoalsRecieved);

        }

        return compare;
    }


}
