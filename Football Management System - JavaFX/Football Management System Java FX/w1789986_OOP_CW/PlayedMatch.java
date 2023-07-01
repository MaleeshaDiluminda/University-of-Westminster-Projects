import java.io.Serializable;

public class PlayedMatch implements Serializable {

    private FootballClub firstTeam;
    private FootballClub secondTeam;
    private int firstTeamScore;
    private int secondTeamScore;
    private Date matchDate;

    public PlayedMatch(String firstTeam, String secondTeam, int randomFirstScore, int randomSecondScore, Date randomDate) {
    }

    public PlayedMatch(FootballClub firstTeam, FootballClub secondTeam, int firstTeamScore, int secondTeamScore, Date matchDate) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.firstTeamScore = firstTeamScore;
        this.secondTeamScore = secondTeamScore;
        this.matchDate = matchDate;
    }

    public FootballClub getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(FootballClub firstTeam) {
        this.firstTeam = firstTeam;
    }

    public FootballClub getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(FootballClub secondTeam) {
        this.secondTeam = secondTeam;
    }

    public int getFirstTeamScore(){
        return firstTeamScore;
    }

    public void setFirstTeamScore(int firstTeamScore) {
        this.firstTeamScore = firstTeamScore;
    }

    public int getSecondTeamScore(){
        return secondTeamScore;
    }

    public void setSecondTeamScore(int secondTeamScore) {
        this.secondTeamScore = secondTeamScore;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

}

