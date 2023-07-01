import javafx.application.Application;
import javafx.stage.Stage;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PremiereLeagueManager extends Application implements LeagueManager, Serializable {
    private ArrayList<FootballClub> footballLeague = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private ArrayList<PlayedMatch> playedMatches = new ArrayList<>();

    @Override
    public void Add_Club(String clubName, String clubLocation, String clubPresident, int memberCount) {
        FootballClub footballClub = new FootballClub(clubName, clubLocation, clubPresident, memberCount);
        footballLeague.add(footballClub);
    }

    @Override
    public String Delete_Club(String clubName) {
        for(FootballClub fbclub :  footballLeague) {
            if(fbclub.getClubName().equals(clubName)){
                footballLeague.remove(fbclub);
                return " Club Deleted ";

            }

        }

        return " Club does not exist ";

    }

    @Override
    public String Display_Statistic(String clubName) {
        String stats;
        for (FootballClub fbClub :  footballLeague) {
            if(fbClub.getClubName().equals(clubName)){
                stats =
                        " ------------------------------------------------\n" +
                                " ------------------------------------------------\n" +
                                "Wins                    :" + fbClub.getWinCount() + "\n" +
                                "Defeats                 :" + fbClub.getDefeatCount() + "\n" +
                                "Draws                   :" + fbClub.getDrawCount() + "\n" +
                                "Concieved Goals         :" + fbClub.getConcievedGoalCount() + "\n" +
                                "Received Goals          :" + fbClub.getReceivedGoalCount() + "\n" +
                                "Points                  :" + fbClub.getTotalPoints() + "\n" +
                                "Played Matches Count    :" + fbClub.getPlayedMatchesCount() + "\n";
                return stats;

            }

        }

        return "Club does not exist";

    }

    @Override
    public String Display_Table() {
        footballLeague.sort(Collections.reverseOrder());
        String tableString = "";
        tableString += "                                                           $-Premier League Manager-$                               \n  ";

        tableString += "-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n";

        tableString += String.format("%-15s %-12s %10s %10s %10s %20s %20s %20s %10s %n", "Club Name", "Location", "Wins", "Draws" , "Loses" ,"Goals Concieved" , "Goals Recieved" , "Goal Difference" ,"Points");

        tableString += "-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n";

        for (FootballClub footballClub: footballLeague) {

            tableString += String.format("%-15s %-12s %8s %10s %10s %15s %20s %20s %15s %n",footballClub.getClubName(), footballClub.getClubLocation(), footballClub.getWinCount(),footballClub.getDrawCount(),footballClub.getDefeatCount(),footballClub.getConcievedGoalCount(),footballClub.getReceivedGoalCount(),footballClub.getGoalDifference(),footballClub.getTotalPoints());

        }

        tableString += "------------------------------------------------------------------------------------------------------------------------------------------------------------------";
        return tableString;

    }

    @Override
    public void Add_Played_Match(String firstTeam, String secondTeam, int firstTeamScore, int secondTeamScore, Date matchDate) {
        FootballClub footballClub1 = searchClubs(firstTeam);
        FootballClub footballClub2 = searchClubs(secondTeam);
        PlayedMatch match = new PlayedMatch(footballClub1,footballClub2,firstTeamScore,secondTeamScore,matchDate);
        updateScores(match);

        footballLeague.sort(Collections.reverseOrder());

        playedMatches.add(match);

    }

    private void updateScores(PlayedMatch match) {
        FootballClub footballClub1 = match.getFirstTeam();
        FootballClub footballClub2 = match.getSecondTeam();

        footballClub1.setPlayedMatchesCount(footballClub1.getPlayedMatchesCount() + 1);
        footballClub2.setPlayedMatchesCount(footballClub2.getPlayedMatchesCount()+ 1);

        if (match.getFirstTeamScore() > match.getSecondTeamScore()){   // first team wins
            footballClub1.setWinCount(footballClub1.getWinCount() + 1);
            footballClub1.setConcievedGoalCount(footballClub1.getConcievedGoalCount() + match.getFirstTeamScore());
            footballClub1.setRecievedGoalCount(footballClub1.getReceivedGoalCount() + match.getSecondTeamScore());
            footballClub1.setTotalPoints(footballClub1.getTotalPoints() + 3);

            footballClub2.setDefeatCount(footballClub2.getDefeatCount() + 1);
            footballClub2.setConcievedGoalCount(footballClub2.getConcievedGoalCount() + match.getSecondTeamScore());
            footballClub2.setRecievedGoalCount(footballClub2.getReceivedGoalCount() + match.getFirstTeamScore());

        }else if(match.getSecondTeamScore() > match.getFirstTeamScore()){  // second team wins
            footballClub2.setWinCount(footballClub2.getWinCount() + 1);
            footballClub2.setConcievedGoalCount(footballClub2.getConcievedGoalCount() + match.getSecondTeamScore());
            footballClub2.setRecievedGoalCount(footballClub2.getReceivedGoalCount() + match.getFirstTeamScore());
            footballClub2.setTotalPoints(footballClub2.getTotalPoints() + 3);

            footballClub1.setDefeatCount(footballClub1.getDefeatCount() + 1);
            footballClub1.setConcievedGoalCount(footballClub1.getConcievedGoalCount() + match.getFirstTeamScore());
            footballClub1.setRecievedGoalCount(footballClub1.getReceivedGoalCount() + match.getSecondTeamScore());

        }else if (match.getFirstTeamScore() == match.getSecondTeamScore()){ //  draw

            footballClub1.setDrawCount(footballClub1.getDrawCount() + 1);
            footballClub1.setConcievedGoalCount(footballClub1.getConcievedGoalCount() + match.getFirstTeamScore());
            footballClub1.setRecievedGoalCount(footballClub1.getReceivedGoalCount() + match.getSecondTeamScore());
            footballClub1.setTotalPoints(footballClub1.getTotalPoints() + 1);

            footballClub2.setDrawCount(footballClub2.getDrawCount() + 1);
            footballClub2.setConcievedGoalCount(footballClub2.getConcievedGoalCount() + match.getSecondTeamScore());
            footballClub2.setRecievedGoalCount(footballClub2.getReceivedGoalCount() + match.getFirstTeamScore());
            footballClub2.setTotalPoints(footballClub2.getTotalPoints() + 1);

        }

    }

    @Override
    public void Save() throws IOException {
        File file = new File("footballData.ser");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(footballLeague);
        objectOutputStream.writeObject(playedMatches);

    }

    @Override
    public void Read_Data() {
        try {
            File file = new File("footballData.ser");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object footballClubArray = objectInputStream.readObject();
            Object matchesArray = objectInputStream.readObject();
            footballLeague = (ArrayList<FootballClub>) footballClubArray;
            playedMatches = (ArrayList<PlayedMatch>) matchesArray;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(" ");
        }

    }

    @Override
    public ArrayList<FootballClub> readTable() {
        try {
            File file = new File("footballData.ser");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object footballClubArray = objectInputStream.readObject();
            Object matchesArray = objectInputStream.readObject();
            footballLeague = (ArrayList<FootballClub>) footballClubArray;
            playedMatches = (ArrayList<PlayedMatch>) matchesArray;
        } catch (IOException | ClassNotFoundException e) {

            System.out.println(" ");

        }

        return footballLeague;

    }

    @Override
    public ArrayList<PlayedMatch> readTable2() {
        try {
            File file = new File("footballData.ser");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object footballClubArray = objectInputStream.readObject();
            Object matchesArray = objectInputStream.readObject();
            footballLeague = (ArrayList<FootballClub>) footballClubArray;
            playedMatches = (ArrayList<PlayedMatch>) matchesArray;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(" ");
        }

        return playedMatches;

    }

    private FootballClub searchClubs(String clubName){
        for (FootballClub fbClub2 : footballLeague){
            if (fbClub2.getClubName().equals(clubName)){
                return fbClub2;
            }

        }

        return null;
    }

    public void displayGUI() {
        Application.launch();
    }

    public ArrayList<FootballClub> getFootballLeague() {
        return footballLeague;
    }

    public ArrayList<PlayedMatch> getPlayedMatches() {
        return playedMatches;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GUI2.displayGUI();
    }
}
