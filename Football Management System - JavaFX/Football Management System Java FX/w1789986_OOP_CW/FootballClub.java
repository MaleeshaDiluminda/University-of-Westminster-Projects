
import java.io.Serializable;

public class FootballClub extends SportsClub implements Serializable,Comparable<FootballClub> {

    private int winCount;
    private int drawCount;
    private int defeatCount;
    private int concievedGoalCount;
    private int receivedGoalCount;
    private int totalPoints;
    private int playedMatchesCount;

    @Override
    public String toString(){
     return this.getClubName();
    }

    public FootballClub(String clubName, String clubLocation, String clubPresident, int clubMemberCount) {
        super(clubName, clubLocation, clubPresident, clubMemberCount);
    }

    public FootballClub(String clubName, String clubLocation, String clubPresident, int clubMemberCount, int winCount, int drawCount, int defeatCount, int concievedGoalCount, int receivedGoalCount, int totalPoints, int playedMatchesCount) {
        super(clubName, clubLocation, clubPresident, clubMemberCount);
        this.winCount = winCount;
        this.drawCount = drawCount;
        this.defeatCount = defeatCount;
        this.concievedGoalCount = concievedGoalCount;
        this.receivedGoalCount = receivedGoalCount;
        this.totalPoints = totalPoints;
        this.playedMatchesCount = playedMatchesCount;
    }

    public int getWinCount(){
        return winCount;
    }

    public void setWinCount(int i) {
        winCount=i;
    }

    public int getDrawCount() {
        return drawCount;
    }

    public void setDrawCount(int i){
        drawCount = i;
    }

    public int getDefeatCount(){
        return defeatCount;
    }

    public void setDefeatCount(int i) {
        defeatCount=i;
    }

    public int getConcievedGoalCount() {
        return concievedGoalCount;
    }

    public void setConcievedGoalCount(int i){
        concievedGoalCount = i;
    }

    public int getReceivedGoalCount() {
        return receivedGoalCount;
    }

    public void setRecievedGoalCount(int i){
        receivedGoalCount = i;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int i){
        totalPoints = i;
    }

    public int getPlayedMatchesCount() {
        return playedMatchesCount;
    }

    public void setPlayedMatchesCount(int i){
        playedMatchesCount = i;
    }

    public int getGoalDifference(){
        return concievedGoalCount - receivedGoalCount;
    }

    @Override
    public int compareTo(FootballClub o) {
        int outPut = this.getTotalPoints() - o.getTotalPoints();
        if (outPut == 0)
           return this.getGoalDifference() - o.getGoalDifference();
        else return outPut;

    }

}

