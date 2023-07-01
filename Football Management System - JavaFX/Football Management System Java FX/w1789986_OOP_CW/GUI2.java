import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Random;

public class GUI2 {
    public static void displayGUI() {
        Stage primaryStage = new Stage();
        PremiereLeagueManager leagueManager = new PremiereLeagueManager();
        leagueManager.Read_Data();

        ObservableList<FootballClub> observableList = FXCollections.observableArrayList();

        AnchorPane anchorPane1 = new AnchorPane();
        primaryStage.setTitle("Football League");

        TableView leagueTable = new TableView();
        leagueTable.setPrefSize(1065,300);
        leagueTable.setLayoutY(55);
        leagueTable.setLayoutX(10);


        TableColumn column1Name = new TableColumn("Name ");
        column1Name.setCellValueFactory(new PropertyValueFactory<>("clubName"));

        TableColumn columnLocation = new TableColumn("Location");
        columnLocation.setCellValueFactory(new PropertyValueFactory<>("clubLocation"));

        TableColumn columnPresident = new TableColumn("President");
        columnPresident.setCellValueFactory(new PropertyValueFactory<>("clubPresident"));

        TableColumn column1 = new TableColumn("Win Count");
        column1.setCellValueFactory(new PropertyValueFactory<>("winCount"));

        TableColumn column2 = new TableColumn("Draw Count");
        column2.setCellValueFactory(new PropertyValueFactory<>("drawCount"));

        TableColumn column3 = new TableColumn("Defeat Count");
        column3.setCellValueFactory(new PropertyValueFactory<>("defeatCount"));

        TableColumn column4 = new TableColumn("Concieved Goal Count");
        column4.setCellValueFactory(new PropertyValueFactory<>("concievedGoalCount"));

        TableColumn column5 = new TableColumn("Received Goal Count");
        column5.setCellValueFactory(new PropertyValueFactory<>("receivedGoalCount"));

        TableColumn column6 = new TableColumn("Total Points");
        column6.setCellValueFactory(new PropertyValueFactory<>("totalPoints"));

        TableColumn column7 = new TableColumn("Played Matches Count");
        column7.setCellValueFactory(new PropertyValueFactory<>("playedMatchesCount"));

        leagueTable.getColumns().addAll(column1Name,columnLocation,columnPresident,column1,column2,column3,column4,column5,column6,column7);
        anchorPane1.getChildren().addAll(leagueTable);

        leagueTable.setItems(setLeagueTable(leagueManager));

        Button button = new Button("   Play Random Match   ");
        button.setLayoutY(760);
        button.setLayoutX(10);
        button.setPrefWidth(1065);
        button.setStyle("-fx-font-size: 14;-fx-background-color: yellow;-fx-font-weight: 200");

        button.setOnAction(e -> {

            Random random1 = new Random();
            int randomFirst = random1.nextInt(leagueManager.getFootballLeague().size());
            int randomSecond = random1.nextInt(leagueManager.getFootballLeague().size());
            int randomFirstScore = random1.nextInt(30);
            int randomSecondScore = random1.nextInt(30);
            int day = random1.nextInt(31) + 1;
            int month = random1.nextInt(12) + 1;
            int year = random1.nextInt(2020);
            Date randomDate = new Date(day, month, year);
            String firstTeam = leagueManager.getFootballLeague().get(0).getClubName();
            String secondTeam = leagueManager.getFootballLeague().get(1).getClubName();


            leagueManager.Add_Played_Match(firstTeam,secondTeam,randomFirstScore,randomSecondScore,randomDate);
            try {
                leagueManager.Save();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            setMatchesTable(leagueManager);
            setLeagueTable(leagueManager);
        });


        TextField firstteamNameTxt =new TextField("First Team Name");
        firstteamNameTxt.setLayoutY(730);
        firstteamNameTxt.setLayoutX(10);
        firstteamNameTxt.setPrefWidth(207);
        firstteamNameTxt.setStyle("-fx-font-size: 14;-fx-background-color: lightblue;-fx-font-weight: 200");

        TextField firstteamScoreTxt =new TextField("First Team Score");
        firstteamScoreTxt.setLayoutY(730);
        firstteamScoreTxt.setLayoutX(434);
        firstteamScoreTxt.setPrefWidth(210);
        firstteamScoreTxt.setStyle("-fx-font-size: 14;-fx-background-color: lightblue;-fx-font-weight: 200");

        TextField secondteamNameTxt =new TextField("Second Team Name");
        secondteamNameTxt.setLayoutY(730);
        secondteamNameTxt.setLayoutX(221);
        secondteamNameTxt.setPrefWidth(210);
        secondteamNameTxt.setStyle("-fx-font-size: 14;-fx-background-color: lightblue;-fx-font-weight: 200");

        TextField secondteamScoreTxt =new TextField("Second Team Score");
        secondteamScoreTxt.setLayoutY(730);
        secondteamScoreTxt.setLayoutX(647);
        secondteamScoreTxt.setPrefWidth(210);
        secondteamScoreTxt.setStyle("-fx-font-size: 14;-fx-background-color: lightblue;-fx-font-weight: 200");

        TextField matchDateTxt =new TextField("Match Date");
        matchDateTxt.setLayoutY(730);
        matchDateTxt.setLayoutX(860);
        matchDateTxt.setPrefWidth(213);
        matchDateTxt.setStyle("-fx-font-size: 14;-fx-background-color: lightblue;-fx-font-weight: 200");

        Button buttonPoints = new Button("Sort by Date");
        buttonPoints.setLayoutY(375);
        buttonPoints.setLayoutX(285);
        buttonPoints.setStyle("-fx-font-size: 14;-fx-background-color: yellow;-fx-font-weight: 200");
//      buttonPoints.setOnAction(event -> {
//        Comparator comp = Comparator.comparing(PlayedMatch::getMatchDate);
//        Collections.sort(playedMatches,comp);
//              });


        TextField dateSearch = new TextField("Enter Date");
        dateSearch.setLayoutY(375);
        dateSearch.setLayoutX(550);
        dateSearch.setPrefWidth(300);
        dateSearch.setStyle("-fx-font-size: 14;-fx-background-color: yellow;-fx-font-weight: 200");

        Button buttonGoals = new Button("Search by Date");
        buttonGoals.setLayoutY(375);
        buttonGoals.setLayoutX(400);
        buttonGoals.setStyle("-fx-font-size: 14;-fx-background-color: yellow;-fx-font-weight: 200");

        Label statTable = new Label("Statistics Table");
        statTable.setLayoutY(20);
        statTable.setLayoutX(20);
        statTable.setStyle("-fx-font-size: 18;-fx-background-color: yellow;-fx-font-weight: 200");

        Label playedTable = new Label(" Played Matches Table ");
        playedTable.setLayoutX(20);
        playedTable.setLayoutY(380);
        playedTable.setStyle("-fx-font-size: 18;-fx-background-color: yellow;-fx-font-weight: 200");

        Label descripLabel = new Label(" Click column headers to get statistics in ascending and descending order. ");
        descripLabel.setLayoutX(250);
        descripLabel.setLayoutY(20);
        descripLabel.setStyle("-fx-font-size: 18;-fx-background-color: yellow;-fx-font-weight: 200");

        anchorPane1.getChildren().addAll(button,buttonGoals,buttonPoints,playedTable,firstteamNameTxt,firstteamScoreTxt,secondteamNameTxt,secondteamScoreTxt,matchDateTxt,statTable,descripLabel,dateSearch);

        // Table 2

        TableView matchTable = new TableView();
        matchTable.setLayoutX(10);
        matchTable.setLayoutY(420);
        matchTable.setPrefSize(1065,300);

        TableColumn columnFirstTeam = new TableColumn("First Team");
        columnFirstTeam.setCellValueFactory(new PropertyValueFactory<>("firstTeam"));
        columnFirstTeam.setPrefWidth(213);

        TableColumn columnSecondTeam = new TableColumn("Second Team");
        columnSecondTeam.setCellValueFactory(new PropertyValueFactory<>("secondTeam"));
        columnSecondTeam.setPrefWidth(213);

        TableColumn columnfirstGoalCount = new TableColumn("1st Team Goals");
        columnfirstGoalCount.setCellValueFactory(new PropertyValueFactory<>("firstTeamScore"));
        columnfirstGoalCount.setPrefWidth(213);

        TableColumn columnsecondGoalCount = new TableColumn("2nd Team Goals");
        columnsecondGoalCount.setCellValueFactory(new PropertyValueFactory<>("secondTeamScore"));
        columnsecondGoalCount.setPrefWidth(213);

        TableColumn columnDate = new TableColumn("Date");
        columnDate.setCellValueFactory(new PropertyValueFactory<>("matchDate"));
        columnDate.setPrefWidth(213);

        matchTable.getColumns().addAll(columnFirstTeam,columnSecondTeam,columnfirstGoalCount,columnsecondGoalCount,columnDate);
        anchorPane1.getChildren().addAll(matchTable);

        matchTable.setItems(setMatchesTable(leagueManager));


        Scene scene = new Scene(anchorPane1,1085,1000);
        anchorPane1.setStyle("-fx-background-color: midnightblue");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static ObservableList<FootballClub> setLeagueTable(PremiereLeagueManager premiereLeagueManager) {
        ObservableList<FootballClub> observableList = FXCollections.observableArrayList();
        premiereLeagueManager.Read_Data();
        for (FootballClub footballClubtable : premiereLeagueManager.getFootballLeague()){
            observableList.add(footballClubtable);
        }
        return observableList;
    }

    private static ObservableList<PlayedMatch> setMatchesTable(PremiereLeagueManager premiereLeagueManager) {
        ObservableList<PlayedMatch> observableList = FXCollections.observableArrayList();
        premiereLeagueManager.Read_Data();
        for (PlayedMatch match : premiereLeagueManager.getPlayedMatches()){
            observableList.add(match);
        }
        return observableList;
    }
}
