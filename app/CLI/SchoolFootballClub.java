package CLI;

import java.io.Serializable;
import java.util.Objects;


public class SchoolFootballClub extends FootballClub implements Serializable {
    private static final long serialVersionUID = -1874298607472967827L;
    private String schoolName;


    public SchoolFootballClub(String clubName, String clubAddress, int numMember,int wins, int draws, int defeats, int numGoalsRecieved, int numGoalsScored, int clubPoints, int numMatch,String schoolName) {
        super(clubName,clubAddress,numMember,wins,draws,defeats,numGoalsRecieved,numGoalsScored,clubPoints,numMatch);

        this.schoolName = schoolName;

    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolFootballClub that = (SchoolFootballClub) o;
        return Objects.equals(schoolName, that.schoolName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolName);
    }
}
