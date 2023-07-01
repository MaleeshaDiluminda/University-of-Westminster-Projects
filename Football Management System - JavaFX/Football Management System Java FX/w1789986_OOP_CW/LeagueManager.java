
import java.io.IOException;
import java.util.ArrayList;

public interface LeagueManager {
    public abstract void Add_Club(String clubName, String clubLocation, String clubPresident, int memberCount);

    public abstract String Delete_Club(String clubName);

    public abstract String Display_Statistic(String clubName);

    public abstract String Display_Table();

    public abstract void Add_Played_Match(String firstTeam, String secondTeam, int firstTeamScore, int secondTeamScore, Date matchDate);

    public abstract void Save() throws IOException;

    public abstract void Read_Data();

    public ArrayList<FootballClub> readTable();

    ArrayList<PlayedMatch> readTable2();

}
