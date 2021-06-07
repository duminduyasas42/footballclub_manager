package CLI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;



public class consoler extends Application {


    static Scanner sc = new Scanner(System.in);
    static String c;
    static int d;
    //use to get methods of premierleaguemanager
    static PremierLeagueManager manager=new PremierLeagueManager();







    @Override
    public  void start(Stage primaryStage) throws Exception {

        //reload saved data of clubs
        try {
            manager.objectInputStream();
            System.out.println("reload club details");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //reload saved data of matches
        try {
            manager.readmatch();
            System.out.println("reload match details");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //d=9 loop ends
        while (d!=9){
            System.out.println("what do you what to do?\n1.add club\n2.delete club\n3.search club\n4.table details\n5.add match\n6.open GUI javafx\n7.open GUI Anguler\n9.quit");
            c = sc.nextLine();
            //check for integuter validation
            if (isnum(c)==true){
                //convert string number to integur
                d=Integer.parseInt(c);

                if(d==1){
                    //when d =1 we add new club using premierleaguemanager
                    manager.addClub();
                    try {//clubdetails
                        manager.objectOutputStream();
                        System.out.println("save data");
                    } catch (IOException e) {

                    }


                }else if(d==2){
                    //when d equals to we take input to delete the club given in the input
                    System.out.print("name of delete club:");
                    String a="";
                    a=a+ sc.nextLine();
                    if(a.equals("")) {
                        System.out.println("empty");


                    }else{
                        if(manager.isClub(a)==true){
                        System.out.println("are you sure you want to delete club " + a + "?");
                        String b = sc.nextLine();
                        if (b.equals("Yes") || b.equals("yes") || b.equals("Y") || b.equals("y")) {
                            manager.deleteClub(a);
                            try {//clubdetails
                                manager.objectOutputStream();
                                System.out.println("save data");
                            } catch (IOException e) {

                            }
                        }
                        }else {
                            System.out.println("club does not exist");
                        }

                    }





                }else if(d==3){
                    //find club is use to find a club by using the name of the club and give details
                    manager.findClub();

                }else if(d==4){
                    //scoreboard for all club statictics
                    manager.clubTable();

                }else if (d==9){
                    //it is use quite but before quiting it saves all the data by using outputstream for match details and club details

                    System.out.println("thank you");
                }else if (d==5){//add match to interface
                    manager.addmatch();
                    try {//clubdetails
                        manager.objectOutputStream();
                        System.out.println("save club");
                    } catch (IOException e) {

                    }
                    try {//clubdetails
                        manager.objectOutputStream1();
                        System.out.println("save match");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                else if (d==6){//add match to interface
                    printlist_gui();
                }
                else if (d == 7) {//add match to interface
                    try {
                        // Just one line and you are done !
                        // We have given a command to start cmd
                        // /K : Carries out command specified by string

                        Runtime.getRuntime().exec("cmd.exe /c start  sbt run");

                        System.out.println("dfgddggd");

                    } catch (Exception e) {
                        System.out.println("HEY Buddy ! U r Doing Something Wrong ");
                        e.printStackTrace();
                    }

                }

            }
        }





    }
    public static void main(String[] args)throws IOException {
        launch();
    }



    public static boolean isnum(String a) {
        //see if the a is string or integure and sea ifit was negative
        try {
            int x = Integer.parseInt(a);
            if (x >= 0) {
                return true;
            } else {
                System.out.println("negative number");
                return false;
            }

        } catch (Exception e) {
            System.out.println("not a integure");
            return false;
        }

    }

    private static void  printlist_gui(){
        Collections.sort(manager.club_list);//sort data according to the footballclub

        Scene scene1,scene2,scene3;

        Stage stage=new Stage();
        BorderPane bod=new BorderPane();
        BorderPane matcher=new BorderPane();
        BorderPane searchresullt=new BorderPane();
        scene1=new Scene(bod,1200,500);
        scene2=new Scene(matcher,1200,500);
        scene3=new Scene(searchresullt,1200,500);
        Button match=new Button("details match");

        TableView<FootballClub> table;
        //name column
        TableColumn<FootballClub,Integer> nameColumn=new TableColumn<>("Club Name");
        nameColumn.setPrefWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("clubName"));

        //win column
        TableColumn<FootballClub,Integer> winColumn=new TableColumn<>("Wins");
        winColumn.setPrefWidth(150);
        winColumn.setCellValueFactory(new PropertyValueFactory<>("wins"));



        //draws column
        TableColumn<FootballClub,Integer> drawsColumn=new TableColumn<>("Draws");
        drawsColumn.setPrefWidth(150);
        drawsColumn.setCellValueFactory(new PropertyValueFactory<>("draws"));

        //defeats column
        TableColumn<FootballClub,Integer> defeatsColumn=new TableColumn<>("Defeats");
        defeatsColumn.setPrefWidth(150);
        defeatsColumn.setCellValueFactory(new PropertyValueFactory<>("defeats"));

        //numGoalsRecieved column
        TableColumn<FootballClub,Integer> numGoalsRecievedColumn=new TableColumn<>("numGoalsRecieved");
        numGoalsRecievedColumn.setPrefWidth(150);
        numGoalsRecievedColumn.setCellValueFactory(new PropertyValueFactory<>("numGoalsRecieved"));

        // numGoalsScored column
        TableColumn<FootballClub,Integer> numGoalsScoredColumn=new TableColumn<>("numGoalsScored");
        numGoalsScoredColumn.setPrefWidth(150);
        numGoalsScoredColumn.setCellValueFactory(new PropertyValueFactory<>("numGoalsScored"));
        //clubPoints column
        TableColumn<FootballClub,Integer> clubPointsColumn=new TableColumn<>("Club Points");
        clubPointsColumn.setPrefWidth(150);
        clubPointsColumn.setCellValueFactory(new PropertyValueFactory<>("clubPoints"));

        //numMatch column
        TableColumn<FootballClub,Integer> numMatchColumn=new TableColumn<>("Matchs Played");
        numMatchColumn.setPrefWidth(150);
        numMatchColumn.setCellValueFactory(new PropertyValueFactory<>("numMatch"));



        table= new TableView<>();
        table.setItems(manager.club_list);
        table.getColumns().addAll(nameColumn,winColumn,drawsColumn,defeatsColumn,numMatchColumn,numGoalsScoredColumn,numGoalsRecievedColumn,clubPointsColumn);


        TableView<Match> table1;
        //day column
        TableColumn<Match,Integer> dayColumn=new TableColumn<>("Day");
        dayColumn.setPrefWidth(150);
        dayColumn.setCellValueFactory(new PropertyValueFactory<>("day"));

        //month column
        TableColumn<Match,Integer> monthColumn=new TableColumn<>("Month");
        monthColumn.setPrefWidth(150);
        monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));



        //year column
        TableColumn<Match,Integer> yearColumn=new TableColumn<>("Year");
        yearColumn.setPrefWidth(150);
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        //club1 column
        TableColumn<Match,String> club1Column=new TableColumn<>("Club 1");
        club1Column.setPrefWidth(150);
        club1Column.setCellValueFactory(new PropertyValueFactory<>("club1"));

        //club2 column
        TableColumn<Match,String> club2Column=new TableColumn<>("Club 2");
        club2Column.setPrefWidth(150);
        club2Column.setCellValueFactory(new PropertyValueFactory<>("club2"));

        // Score1 column
        TableColumn<Match,Integer> score1Column=new TableColumn<>("Score 1");
        score1Column.setPrefWidth(150);
        score1Column.setCellValueFactory(new PropertyValueFactory<>("score1"));
        // Score2 column
        TableColumn<Match,Integer> score2Column=new TableColumn<>("Score 2");
        score2Column.setPrefWidth(150);
        score2Column.setCellValueFactory(new PropertyValueFactory<>("score2"));


        table1= new TableView<>();
        table1.setItems(manager.match_list);
        table1.getColumns().addAll(dayColumn,monthColumn,yearColumn,club1Column,club2Column,score1Column,score2Column);
        Pane tab1=new Pane();
        tab1.getChildren().addAll(table1);



        Pane tab=new Pane();
        tab.getChildren().addAll(table);
        bod.setCenter(tab);

        Button random=new Button("create random match");
        random.setOnAction(event -> {
            manager.randomMatchCreater();
            Collections.sort(manager.club_list);//sort data according to the footballclub
            table.refresh();

            table.setItems(manager.club_list);



            bod.setCenter(tab);

        });


        Button sortwin=new Button("sort by wins");
        sortwin.setOnAction(event -> {
            manager.sort1();
            table.refresh();

            table.setItems(manager.club_list);



            bod.setCenter(tab);

        });
        sortwin.setLayoutX(130);
        Button sortscoredgoals=new Button("sort by goals scored");
        sortscoredgoals.setOnAction(event -> {

            manager.sort2();
            table.refresh();

            table.setItems(manager.club_list);



            bod.setCenter(tab);

        });
        sortscoredgoals.setLayoutX(300);
        Pane pane2=new Pane();
        pane2.getChildren().addAll(random,sortwin,sortscoredgoals);

















        bod.setTop(pane2);
        Button back=new Button("back");
        back.setOnAction(event -> {
            bod.setTop(random);
            bod.setCenter(tab);
            bod.setBottom(match);
            stage.setScene(scene1);


        });
        Label ser=new Label();
        TextField search_day=new TextField("day");
        Button back2=new Button("back");


        search_day.setLayoutX(0);
        TextField search_month=new TextField("month");
        search_month.setLayoutX(100);
        TextField search_year=new TextField("year");
        search_year.setLayoutX(200);
        Button search=new Button("search");
        search.setOnAction(event -> {

            ser.setText(manager.search(search_day.getText(),search_month.getText(),search_year.getText()));

            searchresullt.setCenter(ser);
            searchresullt.setBottom(back2);
            stage.setScene(scene3);




        });
        search.setLayoutX(300);
        Pane topmatch=new Pane();
        topmatch.getChildren().addAll(search_day,search_month,search_year,search);

        back2.setOnAction(event -> {
            matcher.setTop(topmatch);

            matcher.setCenter(tab1);
            matcher.setBottom(back);
            stage.setScene(scene2);


        });







        match.setOnAction(event -> {
            matcher.setTop(topmatch);
            matcher.setCenter(tab1);
            matcher.setBottom(back);
            Collections.sort(manager.match_list);//sort data according to the footballclub


            stage.setScene(scene2);



        });
        bod.setBottom(match);









        stage.setScene(scene1);
        stage.showAndWait();

    }









}

