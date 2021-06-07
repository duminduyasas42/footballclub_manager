package CLI;

import java.io.Serializable;
import java.util.Objects;



public class SportsClub  implements Serializable {
    private static final long serialVersionUID = -1874298607472967827L;
   private String clubName;
    private String clubAddress;
    private int numMember;


    public SportsClub(String clubName, String clubAddress, int numMember) {
        super();
        this.clubName = clubName;
        this.clubAddress = clubAddress;
        this.numMember = numMember;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubAddress() {
        return clubAddress;
    }

    public void setClubAddress(String clubAddress) {
        this.clubAddress = clubAddress;
    }

    public int getNumMember() {
        return numMember;
    }

    public void setNumMember(int numMember) {
        this.numMember = numMember;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return numMember == that.numMember &&
                Objects.equals(clubName, that.clubName) &&
                Objects.equals(clubAddress, that.clubAddress);
    }


    @Override
    public int hashCode() {
        return Objects.hash(clubName, clubAddress, numMember);
    }



}



