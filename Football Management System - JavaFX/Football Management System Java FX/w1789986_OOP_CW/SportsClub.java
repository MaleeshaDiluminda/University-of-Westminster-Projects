import java.io.Serializable;

public class SportsClub implements Serializable  {

    private String clubName;
    private String clubLocation;
    private String clubPresident;
    private int clubMemberCount;

    public SportsClub(String clubName, String clubLocation, String clubPresident, int clubMemberCount) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;
        this.clubPresident = clubPresident;
        this.clubMemberCount = clubMemberCount;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String s) {
        this.clubName = s;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public void setClubLocation(String s) {
        this.clubLocation = s;
    }

    public String getClubPresident() {
        return clubPresident;
    }

    public void setClubPresident(String s) {
        this.clubPresident = s;
    }

    public int getClubMemberCount() {
        return clubMemberCount;
    }

    public void setClubMemberCount(int s) {
        this.clubMemberCount = s;
    }

    @Override
    public boolean equals(Object o) {
        return this.clubName.equals(((SportsClub) o).clubName);

    }
}

