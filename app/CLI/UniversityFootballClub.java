package CLI;

import java.io.Serializable;
import java.util.Objects;


public class UniversityFootballClub extends FootballClub implements Serializable {
    private static final long serialVersionUID = -1874298607472967827L;
    private String uniName;


    public UniversityFootballClub(String clubName, String clubAddress, int numMember,int wins, int draws, int defeats, int numGoalsRecieved, int numGoalsScored, int clubPoints, int numMatch,String uniName) {
        super(clubName,clubAddress,numMember,wins,draws,defeats,numGoalsRecieved,numGoalsScored,clubPoints,numMatch);

        this.uniName = uniName;

    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversityFootballClub that = (UniversityFootballClub) o;
        return Objects.equals(uniName, that.uniName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniName);
    }
}

