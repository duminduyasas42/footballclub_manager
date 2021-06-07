package CLI;

import java.io.Serializable;
import java.util.Objects;


public class Match implements Serializable,Comparable<Match>{

    private String club1;
    private String club2;
    private int score1;
    private int score2;
    private int day;
    private int month ;
    private int year;

    public Match(String club1, String club2, int score1, int score2, int day, int month, int year) {
        this.club1 = club1;
        this.club2 = club2;
        this.score1 = score1;
        this.score2 = score2;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getClub1() {
        return club1;
    }

    public void setClub1(String club1) {
        this.club1 = club1;
    }

    public String getClub2() {
        return club2;
    }

    public void setClub2(String club2) {
        this.club2 = club2;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return score1 == match.score1 &&
                score2 == match.score2 &&
                day == match.day &&
                month == match.month &&
                year == match.year &&
                Objects.equals(club1, match.club1) &&
                Objects.equals(club2, match.club2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(club1, club2, score1, score2, day, month, year);
    }

    @Override
    public int compareTo(Match o) {
        int compare=Integer.compare(o.year,year);
        if(compare==0){
            compare=Integer.compare(o.month,month);
            if(compare==0){
                compare=Integer.compare(o.day,day);

            }

        }

        return compare;
    }


}


