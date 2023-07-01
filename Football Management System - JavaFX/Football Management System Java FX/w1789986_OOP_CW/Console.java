
import javafx.application.Application;

import java.io.IOException;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) throws IOException {
        PremiereLeagueManager premierLeagueManager = new PremiereLeagueManager();

        premierLeagueManager.Read_Data();

        int command = 0;
        while(true)  {
            try {
                Scanner scanner3 = new Scanner(System.in);

                System.out.println(" ------------------------------------------------");
                System.out.println("            $-Premier League Manager-$   ");
                System.out.println(" ------------------------------------------------");
                System.out.println(" ------------------------------------------------");
                System.out.println(" Press ' 1 ' to Add  new club ");
                System.out.println(" ------------------------------------------------");
                System.out.println(" Press ' 2 ' to Delete club ");
                System.out.println(" ------------------------------------------------");
                System.out.println(" Press ' 3 ' to Display Statistics ");
                System.out.println(" ------------------------------------------------");
                System.out.println(" Press ' 4 ' to Display Premier League table ");
                System.out.println(" ------------------------------------------------");
                System.out.println(" Press ' 5 ' to Add Played Match ");
                System.out.println(" ------------------------------------------------");
                System.out.println(" Press ' 6 ' to GUI ");
                System.out.println(" ------------------------------------------------");
                System.out.println(" Press ' 7 ' to Save & Exit ");
                System.out.println(" ------------------------------------------------");
                System.out.print(" Press number           : ");

                String option=scanner3.nextLine();
                command = 0;
                command = Integer.parseInt(option);
            } catch (Exception e) {
                System.out.println("error msg");
            }

            switch(command) {
                case 1 :
                    Scanner scanner = new Scanner(System.in);
                    System.out.print(" Club Name                  : ");
                    String clubName = scanner.nextLine();

                    System.out.print(" Club Location              : ");
                    String clubLocation = scanner.nextLine();

                    System.out.print(" Club President             : ");
                    String clubPresident  = scanner.nextLine();

                    System.out.print(" Club Member Count          : ");
                    int memberCount = Integer.parseInt(scanner.nextLine());

                    premierLeagueManager.Add_Club(clubName, clubLocation, clubPresident, memberCount);
                    premierLeagueManager.Save();
                      break;

                case 2 :
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.print(" Club name                : ");
                    String deletedClub = scanner2.nextLine();
                    System.out.println(premierLeagueManager.Delete_Club(deletedClub));
                    premierLeagueManager.Save();
                    break;

                case 3 :
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.print(" Club name                : ");
                    String clubStats = scanner3.nextLine();
                    System.out.println(
                            premierLeagueManager.Display_Statistic(clubStats)
                    );
                    break;

                case 4 :
                    System.out.println(premierLeagueManager.Display_Table());
                    premierLeagueManager.Display_Table();
                    break;

                case 5:
                    Scanner scanner4 = new Scanner(System.in);
                    System.out.println(" Date Played      ");

                    System.out.print(" Day                              :");
                    int day = scanner4.nextInt();

                    System.out.print(" Month                            :");
                    int month = scanner4.nextInt();

                    System.out.print(" Year                             :");
                    int year = scanner4.nextInt();
                    scanner4.nextLine();

                    System.out.print(" First Team Name                  :");
                    String firstTeam = scanner4.nextLine();

                    System.out.print(" Fist Team Score                  :");
                    int firstTeamScore = scanner4.nextInt();
                    scanner4.nextLine();

                    System.out.println(" Second Team Name               :");
                    String secondTeam = scanner4.nextLine();

                    System.out.println(" Second team Score              :");
                    int secondTeamScore = scanner4.nextInt();

                    Date datePlayed = new Date(day,month,year);

                    premierLeagueManager.Add_Played_Match(firstTeam,secondTeam,firstTeamScore,secondTeamScore,datePlayed);

                    System.out.print( "--------------------- Match Added -------------------- ");
                    premierLeagueManager.Save();
                    break;

                case 6:
                    premierLeagueManager.displayGUI();
                    premierLeagueManager.Save();
                    System.exit(0);
                    break;

                case 7:
                    premierLeagueManager.Save();
                    System.exit(0);
                    break;
                default:

            }

        }

    }

}

