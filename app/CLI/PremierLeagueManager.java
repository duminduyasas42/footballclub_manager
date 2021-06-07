package CLI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;


    public class PremierLeagueManager implements LeagueManager{
        //array list use to store all the footballclub details


        ObservableList<FootballClub> club_list= FXCollections.observableArrayList();
        //array list use to store all match deatails
        ObservableList<Match> match_list=FXCollections.observableArrayList();
        static Scanner sc=new Scanner(System.in);


        @Override
        public void deleteClub(String a){//delete a club club name is taken as a input it main class


            for (int i = 0; i < club_list.size(); i++){



                if (club_list.get(i).getClubName().equals(a)){


                    //System.out.println(premierLeagueArr.get(i));

                    club_list.remove(i);

                    System.out.println(a + " club is removed");
                }

            }


        }

        @Override
        public void addmatch() {
            //add the details of match and update every thing accordingly
            String clubName1,clubName2,clubScore1,clubScore2,date;
            int clubScore11,clubScore22,day,month,year;
            while(true){
                //get date all to gether people have give the date in the given formateor else there will be error massage


                System.out.print("enter membership date in formate 00|00|0000 :");
                date=sc.nextLine();



                int pos1 = date.indexOf("|");

                int pos2 = date.indexOf("|", pos1 + 1);

                int si = date.length();

                if (pos1 != -1 || pos2 != -1){

                    String d = date.substring(0, pos1);
                    String m = date.substring(pos1 + 1, pos2);
                    String y = date.substring(pos2 + 1);




                    boolean  da=isnum(d);
                    boolean mo=isnum(m);
                    boolean ye=isnum(y);

                    //see if dat is a number

                    if(da==false){
                        System.out.println("day is not correct");
                        continue;

                    }
                    //see if month is number
                    if(mo==false){
                        System.out.println("month is not correct");
                        continue;

                    }
                    //see if year is number
                    if(mo==false){
                        System.out.println("year is not correct");
                        continue;

                    }
                    //check if the date is entered in the correct formate with integure values

                    if(pos1==2 && pos2==5 && si==10 && mo==true && da==true && ye==true){

                        day = Integer.parseInt(d);
                        month = Integer.parseInt(m);
                        year = Integer.parseInt(y);
                        //check validation to see if it is a real number

                        boolean check=validation(day,month,year);
                        if(check==true){
                            break;
                        }
                        else{
                            System.out.println("not a real date");

                        }







                    }
                    else {
                        System.out.println("error date correctly");

                    }







                }
                else {
                    System.out.println("enter date correctly");

                }



            }

            //club one name


            System.out.print("first Club Name:");
            clubName1=sc.nextLine();
            //see if club 1 was entered as a club
            if(isClub(clubName1)==false){
                System.out.println("club 1 does not extist");

            }
            if(isClub(clubName1)==true){
                System.out.print("secound Club Name:");
                clubName2=sc.nextLine();
                //check if club 2 is avaiblein clublist
                if(isClub(clubName2)==true){

                    if(clubName1!=clubName2) {//check if both teams are not the same

                        while (true) {//see if score is integure
                            System.out.print("first Club score:");
                            clubScore1 = sc.nextLine();
                            if (isnum(clubScore1) == true) {
                                break;
                            }

                        }
                        while (true) {//see if score is integure
                            System.out.print("second Club score:");
                            clubScore2 = sc.nextLine();
                            if (isnum(clubScore2) == true) {
                                break;
                            }

                        }
                        clubScore11 = Integer.parseInt(clubScore1);
                        clubScore22 = Integer.parseInt(clubScore2);
                        //add match to match list

                        Match match = new Match(clubName1, clubName2, clubScore11, clubScore22, day, month, year);
                        match_list.add(match);



                        //update club 1



                        for (FootballClub club : club_list) {


                            if (club.getClubName().equals(clubName1)) {
                                //if club 1 win
                                if (clubScore11 > clubScore22) {
                                    club.setWins(club.getWins() + 1);
                                    club.setNumGoalsRecieved(club.getNumGoalsRecieved() + clubScore22);
                                    club.setNumGoalsScored(club.getNumGoalsScored() + clubScore11);
                                    club.setClubPoints(club.getClubPoints() + 3);
                                    club.setNumMatch(club.getNumMatch() + 1);


                                }
                                //if club1 loss
                                if (clubScore22 > clubScore11) {
                                    club.setDefeats(club.getDefeats() + 1);
                                    club.setNumGoalsRecieved(club.getNumGoalsRecieved() + clubScore22);
                                    club.setNumGoalsScored(club.getNumGoalsScored() + clubScore11);

                                    club.setNumMatch(club.getNumMatch() + 1);

                                }//if club1 draws
                                if (clubScore11 == clubScore22) {
                                    club.setDraws(club.getDraws() + 1);
                                    club.setNumGoalsRecieved(club.getNumGoalsRecieved() + clubScore22);
                                    club.setNumGoalsScored(club.getNumGoalsScored() + clubScore11);
                                    club.setClubPoints(club.getClubPoints() + 1);
                                    club.setNumMatch(club.getNumMatch() + 1);

                                }


                            }


                        }
                        for (FootballClub club : club_list) {//update club 2


                            if (club.getClubName().equals(clubName2)) {
                                //if club 2 win
                                if (clubScore22 > clubScore11) {
                                    club.setWins(club.getWins() + 1);
                                    club.setNumGoalsRecieved(club.getNumGoalsRecieved() + clubScore11);
                                    club.setNumGoalsScored(club.getNumGoalsScored() + clubScore22);
                                    club.setClubPoints(club.getClubPoints() + 3);
                                    club.setNumMatch(club.getNumMatch() + 1);


                                }//if club 2 looses
                                if (clubScore11 > clubScore22) {
                                    club.setDefeats(club.getDefeats() + 1);

                                    club.setNumGoalsRecieved(club.getNumGoalsRecieved() + clubScore11);
                                    club.setNumGoalsScored(club.getNumGoalsScored() + clubScore22);

                                    club.setNumMatch(club.getNumMatch() + 1);

                                }//if club2 draw
                                if (clubScore11 == clubScore22) {
                                    club.setDraws(club.getDraws() + 1);
                                    club.setNumGoalsRecieved(club.getNumGoalsRecieved() + clubScore11);
                                    club.setNumGoalsScored(club.getNumGoalsScored() + clubScore22);
                                    club.setClubPoints(club.getClubPoints() + 1);
                                    club.setNumMatch(club.getNumMatch() + 1);

                                }


                            }


                        }
                    }else{
                        System.out.println("booth clubs are the same");
                    }








                }
                if(isClub(clubName2)==false){
                    System.out.println("club 2 does not extist");

                }


            }





        }

        @Override//read foodball club dtails
        public void objectInputStream() throws IOException {
            FileInputStream fin=new FileInputStream("footballClubDetails.txt");
            ObjectInputStream objin=new ObjectInputStream(fin);
            while (true){
                try {

                    FootballClub club=(FootballClub) objin.readObject();

                    club_list.add(club);
                }catch (IOException|ClassNotFoundException e){
                    break;
                }
            }



        }
        @Override//read foodball club dtails
        public ObservableList getclubsforgui() throws IOException {
            ObservableList<FootballClub> club_list1= FXCollections.observableArrayList();
            FileInputStream fin=new FileInputStream("footballClubDetails.txt");
            ObjectInputStream objin=new ObjectInputStream(fin);
            while (true){
                try {
                    System.out.println("ssdsfdsfsf");
                    FootballClub club=(FootballClub) objin.readObject();
                    System.out.println(club);
                    club_list1.add(club);
                }catch (IOException|ClassNotFoundException e){
                    break;
                }
            }
            Collections.sort(club_list);//sort data according to the footballclub
            return club_list1;



        }

        @Override//read foodball club dtails
        public ObservableList getmatchsforgui() throws IOException {
            ObservableList<Match> match_list1=FXCollections.observableArrayList();
            FileInputStream fin=new FileInputStream("matchDetails.txt");
            ObjectInputStream objin=new ObjectInputStream(fin);
            while (true){
                try {
                    System.out.println("ssdsfdsfsf");
                    Match match=(Match) objin.readObject();
                    System.out.println(match);
                    match_list1.add(match);
                }catch (IOException|ClassNotFoundException e){
                    break;
                }
            }
            return match_list1;



        }


        @Override//write football club details
        public void objectOutputStream() throws IOException {
            FileWriter fwOb = new FileWriter("footballClubDetails.txt", false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();

            File file=new File("footballClubDetails.txt");
            FileOutputStream fout=new FileOutputStream(file,true);
            ObjectOutputStream objout=new ObjectOutputStream(fout);
            Iterator it=club_list.iterator();
            while (it.hasNext()){
                FootballClub club=(FootballClub) it.next();
                objout.writeObject(club);

            }



        }


        @Override//read matchdetails
        public void objectOutputStream1() throws IOException {
            FileWriter fwOb = new FileWriter("matchDetails.txt", false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();

            File file=new File("matchDetails.txt");
            FileOutputStream fout=new FileOutputStream(file,true);
            ObjectOutputStream objout=new ObjectOutputStream(fout);
            Iterator it=match_list.iterator();
            while (it.hasNext()){
                Match match=(Match) it.next();
                objout.writeObject(match);

            }



        }

        @Override
        public void readmatch() throws IOException {
            FileInputStream fin=new FileInputStream("matchDetails.txt");
            ObjectInputStream objin=new ObjectInputStream(fin);
            while (true){
                try {

                    Match match=(Match) objin.readObject();

                    match_list.add(match);
                }catch (IOException|ClassNotFoundException e){
                    break;
                }
            }

        }


        @Override
        public void randomMatchCreater() {
            int x=0 ,y=0;
            double xx=0,yy=0;
            int day=0,month=0,year=0;


            while (true){
                int min=0;
                int  max=club_list.size()-1;
                xx = (Math.random()*((max-min)+1))+min;
                yy = (Math.random()*((max-min)+1))+min;
                x= (int) xx;
                y=(int) yy;

                if(x!=y){
                    break;
                }

            }
            System.out.println(x+" "+y);


            while(true){
                //get date all to gether people have give the date in the given formateor else there will be error massage

                double days = (Math.random()*((31-1)+1))+1;
                double months = (Math.random()*((12-1)+1))+1;
                double years = (Math.random()*((2025-2000)+1))+2000;
                day=(int)days;
                month=(int)months;
                year=(int)years;


                boolean check=validation(day,month,year);
                if(check==true){
                    break;
                }
            }
            System.out.println("ddvvd");
            double clubScore1 = (Math.random()*((10-0)+1))+0;
            int clubScore11=(int)clubScore1;
            double clubScore2 = (Math.random()*((10-0)+1))+0;
            int clubScore22=(int)clubScore2;
            if (clubScore11 > clubScore22) {
                club_list.get((int) x).setWins(club_list.get((int) x).getWins() + 1);
                club_list.get((int) x).setNumGoalsRecieved((int) (club_list.get((int) x).getNumGoalsRecieved() + clubScore22));
                club_list.get((int) x).setNumGoalsScored((int) (club_list.get((int) x).getNumGoalsScored() + clubScore11));
                club_list.get((int) x).setClubPoints(club_list.get((int) x).getClubPoints() + 3);
                club_list.get((int) x).setNumMatch(club_list.get((int) x).getNumMatch() + 1);


            }
            //if club1 loss
            if (clubScore22 > clubScore11) {
                club_list.get((int) x).setDefeats(club_list.get((int) x).getDefeats() + 1);
                club_list.get((int) x).setNumGoalsRecieved((int) (club_list.get((int) x).getNumGoalsRecieved() + clubScore22));
                club_list.get((int) x).setNumGoalsScored((int) (club_list.get((int) x).getNumGoalsScored() + clubScore11));

                club_list.get((int) x).setNumMatch(club_list.get((int) x).getNumMatch() + 1);

            }//if club1 draws
            if (clubScore11 == clubScore22) {
                club_list.get((int) x).setDraws(club_list.get((int) x).getDraws() + 1);
                club_list.get((int) x).setNumGoalsRecieved((int) (club_list.get((int) x).getNumGoalsRecieved() + clubScore22));
                club_list.get((int) x).setNumGoalsScored((int) (club_list.get((int) x).getNumGoalsScored() + clubScore11));
                club_list.get((int) x).setClubPoints(club_list.get((int) x).getClubPoints() + 1);
                club_list.get((int) x).setNumMatch(club_list.get((int) x).getNumMatch() + 1);

            }

            if (clubScore22 > clubScore11) {
                club_list.get((int) y).setWins(club_list.get((int) y).getWins() + 1);
                club_list.get((int) y).setNumGoalsRecieved((int) (club_list.get((int) y).getNumGoalsRecieved()+ clubScore11 ));
                club_list.get((int) y).setNumGoalsScored((int) (club_list.get((int) y).getNumGoalsScored() + clubScore22));
                club_list.get((int) y).setClubPoints(club_list.get((int) y).getClubPoints() + 3);
                club_list.get((int) y).setNumMatch(club_list.get((int) y).getNumMatch() + 1);


            }
            //if club1 loss
            if (clubScore11 > clubScore22) {
                club_list.get((int) y).setDefeats(club_list.get((int) y).getDefeats() + 1);
                club_list.get((int) y).setNumGoalsRecieved((int) (club_list.get((int) y).getNumGoalsRecieved() + clubScore11));
                club_list.get((int) y).setNumGoalsScored((int) (club_list.get((int) y).getNumGoalsScored()+ clubScore22 ));

                club_list.get((int) y).setNumMatch(club_list.get((int) y).getNumMatch() + 1);

            }//if club1 draws
            if (clubScore11 == clubScore22) {
                club_list.get((int) y).setDraws(club_list.get((int) y).getDraws() + 1);
                club_list.get((int) y).setNumGoalsRecieved((int) (club_list.get((int) y).getNumGoalsRecieved()+ clubScore11 ));
                club_list.get((int) y).setNumGoalsScored((int) (club_list.get((int) y).getNumGoalsScored() + clubScore22));
                club_list.get((int) y).setClubPoints(club_list.get((int) y).getClubPoints() + 1);
                club_list.get((int) y).setNumMatch(club_list.get((int) y).getNumMatch() + 1);

            }
            Match match = new Match(club_list.get((int) x).getClubName(),club_list.get((int) y).getClubName(), clubScore11, clubScore22, day, month, year);
            match_list.add(match);
            FileWriter fwOb = null;
            try {
                fwOb = new FileWriter("matchDetails.txt", false);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            try {
                fwOb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            File file=new File("matchDetails.txt");
            FileOutputStream fout= null;
            try {
                fout = new FileOutputStream(file,true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectOutputStream objout= null;
            try {
                objout = new ObjectOutputStream(fout);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Iterator it=match_list.iterator();
            while (it.hasNext()){
                Match matchs=(Match) it.next();
                try {
                    objout.writeObject(matchs);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            FileWriter fwOb1 = null;
            try {
                fwOb1 = new FileWriter("footballClubDetails.txt", false);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pwOb1 = new PrintWriter(fwOb1, false);
            pwOb1.flush();
            pwOb1.close();
            try {
                fwOb1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            File file1=new File("footballClubDetails.txt");
            FileOutputStream fout1=null;
            try {
                fout1=new FileOutputStream(file1,true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectOutputStream objout1=null;
            try {
                objout1=new ObjectOutputStream(fout1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Iterator it1=club_list.iterator();
            while (it1.hasNext()){
                FootballClub club=(FootballClub) it1.next();

                try {
                    objout1.writeObject(club);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }







        }
        @Override
        public void randomMatchCreaterGuiAnguler() {
            int x=0 ,y=0;
            double xx=0,yy=0;
            int day=0,month=0,year=0;
            ObservableList<FootballClub> club_list123= FXCollections.observableArrayList();
            //array list use to store all match deatails
            ObservableList<Match> match_list123=FXCollections.observableArrayList();
            FileInputStream fin= null;
            try {
                fin = new FileInputStream("matchDetails.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectInputStream objin= null;
            try {
                objin = new ObjectInputStream(fin);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true){
                try {
                    System.out.println("ssdsfdsfsf");
                    Match match=(Match) objin.readObject();
                    System.out.println(match);
                    match_list123.add(match);
                }catch (IOException|ClassNotFoundException e){
                    break;
                }
            }
            FileInputStream find= null;
            try {
                find = new FileInputStream("footballClubDetails.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectInputStream objind= null;
            try {
                objind = new ObjectInputStream(find);
                System.out.println("load");
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true){
                try {
                    System.out.println("ssdsfdsfsf");
                    FootballClub club=(FootballClub) objind.readObject();
                    System.out.println(club);
                    club_list123.add(club);
                }catch (IOException|ClassNotFoundException e){
                    break;
                }
            }



            while (true){
                int min=0;
                int  max=club_list123.size()-1;
                xx = (Math.random()*((max-min)+1))+min;
                yy = (Math.random()*((max-min)+1))+min;
                x= (int) xx;
                y=(int) yy;

                if(x!=y){
                    break;
                }

            }
            System.out.println(x+" "+y);


            while(true){
                //get date all to gether people have give the date in the given formateor else there will be error massage

                double days = (Math.random()*((31-1)+1))+1;
                double months = (Math.random()*((12-1)+1))+1;
                double years = (Math.random()*((2025-2000)+1))+2000;
                day=(int)days;
                month=(int)months;
                year=(int)years;


                boolean check=validation(day,month,year);
                if(check==true){
                    break;
                }
            }
            System.out.println("ddvvd");
            double clubScore1 = (Math.random()*((10-0)+1))+0;
            int clubScore11=(int)clubScore1;
            double clubScore2 = (Math.random()*((10-0)+1))+0;
            int clubScore22=(int)clubScore2;
            if (clubScore11 > clubScore22) {
                club_list123.get((int) x).setWins(club_list123.get((int) x).getWins() + 1);
                club_list123.get((int) x).setNumGoalsRecieved((int) (club_list123.get((int) x).getNumGoalsRecieved() + clubScore22));
                club_list123.get((int) x).setNumGoalsScored((int) (club_list123.get((int) x).getNumGoalsScored() + clubScore11));
                club_list123.get((int) x).setClubPoints(club_list123.get((int) x).getClubPoints() + 3);
                club_list123.get((int) x).setNumMatch(club_list123.get((int) x).getNumMatch() + 1);


            }
            //if club1 loss
            if (clubScore22 > clubScore11) {
                club_list123.get((int) x).setDefeats(club_list123.get((int) x).getDefeats() + 1);
                club_list123.get((int) x).setNumGoalsRecieved((int) (club_list123.get((int) x).getNumGoalsRecieved() + clubScore22));
                club_list123.get((int) x).setNumGoalsScored((int) (club_list123.get((int) x).getNumGoalsScored() + clubScore11));

                club_list123.get((int) x).setNumMatch(club_list123.get((int) x).getNumMatch() + 1);

            }//if club1 draws
            if (clubScore11 == clubScore22) {
                club_list123.get((int) x).setDraws(club_list123.get((int) x).getDraws() + 1);
                club_list123.get((int) x).setNumGoalsRecieved((int) (club_list123.get((int) x).getNumGoalsRecieved() + clubScore22));
                club_list123.get((int) x).setNumGoalsScored((int) (club_list123.get((int) x).getNumGoalsScored() + clubScore11));
                club_list123.get((int) x).setClubPoints(club_list123.get((int) x).getClubPoints() + 1);
                club_list123.get((int) x).setNumMatch(club_list123.get((int) x).getNumMatch() + 1);

            }

            if (clubScore22 > clubScore11) {
                club_list123.get((int) y).setWins(club_list123.get((int) y).getWins() + 1);
                club_list123.get((int) y).setNumGoalsRecieved((int) (club_list123.get((int) y).getNumGoalsRecieved()+ clubScore11 ));
                club_list123.get((int) y).setNumGoalsScored((int) (club_list123.get((int) y).getNumGoalsScored() + clubScore22));
                club_list123.get((int) y).setClubPoints(club_list123.get((int) y).getClubPoints() + 3);
                club_list123.get((int) y).setNumMatch(club_list123.get((int) y).getNumMatch() + 1);


            }
            //if club1 loss
            if (clubScore11 > clubScore22) {
                club_list123.get((int) y).setDefeats(club_list123.get((int) y).getDefeats() + 1);
                club_list123.get((int) y).setNumGoalsRecieved((int) (club_list123.get((int) y).getNumGoalsRecieved() + clubScore11));
                club_list123.get((int) y).setNumGoalsScored((int) (club_list123.get((int) y).getNumGoalsScored()+ clubScore22 ));

                club_list123.get((int) y).setNumMatch(club_list123.get((int) y).getNumMatch() + 1);

            }//if club1 draws
            if (clubScore11 == clubScore22) {
                club_list123.get((int) y).setDraws(club_list123.get((int) y).getDraws() + 1);
                club_list123.get((int) y).setNumGoalsRecieved((int) (club_list123.get((int) y).getNumGoalsRecieved()+ clubScore11 ));
                club_list123.get((int) y).setNumGoalsScored((int) (club_list123.get((int) y).getNumGoalsScored() + clubScore22));
                club_list123.get((int) y).setClubPoints(club_list123.get((int) y).getClubPoints() + 1);
                club_list123.get((int) y).setNumMatch(club_list123.get((int) y).getNumMatch() + 1);

            }
            Match match = new Match(club_list123.get((int) x).getClubName(),club_list123.get((int) y).getClubName(), clubScore11, clubScore22, day, month, year);
            match_list123.add(match);
            System.out.println(match);
            FileWriter fwOb = null;
            try {
                fwOb = new FileWriter("matchDetails.txt", false);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            try {
                fwOb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            File file=new File("matchDetails.txt");
            FileOutputStream fout= null;
            try {
                fout = new FileOutputStream(file,true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectOutputStream objout= null;
            try {
                objout = new ObjectOutputStream(fout);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Iterator it=match_list123.iterator();
            while (it.hasNext()){
                Match matchs=(Match) it.next();
                try {
                    objout.writeObject(matchs);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            FileWriter fwOb1 = null;
            try {
                fwOb1 = new FileWriter("footballClubDetails.txt", false);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pwOb1 = new PrintWriter(fwOb1, false);
            pwOb1.flush();
            pwOb1.close();
            try {
                fwOb1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            File file1=new File("footballClubDetails.txt");
            FileOutputStream fout1=null;
            try {
                fout1=new FileOutputStream(file1,true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectOutputStream objout1=null;
            try {
                objout1=new ObjectOutputStream(fout1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Iterator it1=club_list123.iterator();
            while (it1.hasNext()){
                FootballClub club=(FootballClub) it1.next();
                System.out.println(club);
                try {
                    objout1.writeObject(club);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }







        }
        @Override
        public void sortgoalanguler() {

            ObservableList<FootballClub> club_list123= FXCollections.observableArrayList();
            //array list use to store all match deatails
            ObservableList<Match> match_list123=FXCollections.observableArrayList();
            FileInputStream fin= null;
            try {
                fin = new FileInputStream("matchDetails.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectInputStream objin= null;
            try {
                objin = new ObjectInputStream(fin);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true){
                try {
                    System.out.println("ssdsfdsfsf");
                    Match match=(Match) objin.readObject();
                    System.out.println(match);
                    match_list123.add(match);
                }catch (IOException|ClassNotFoundException e){
                    break;
                }
            }
            FileInputStream find= null;
            try {
                find = new FileInputStream("footballClubDetails.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectInputStream objind= null;
            try {
                objind = new ObjectInputStream(find);
                System.out.println("load");
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true){
                try {
                    System.out.println("ssdsfdsfsf");
                    FootballClub club=(FootballClub) objind.readObject();
                    System.out.println(club);
                    club_list123.add(club);
                }catch (IOException|ClassNotFoundException e){
                    break;
                }
            }

            Collections.sort(club_list123, new Comparator<FootballClub>() {
                @Override
                public int compare(FootballClub o1, FootballClub o2) {
                    int compare=Integer.compare(o2.getNumGoalsScored(),o1.getNumGoalsScored());
                    return compare;
                }
            });



            FileWriter fwOb = null;
            try {
                fwOb = new FileWriter("matchDetails.txt", false);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            try {
                fwOb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            File file=new File("matchDetails.txt");
            FileOutputStream fout= null;
            try {
                fout = new FileOutputStream(file,true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectOutputStream objout= null;
            try {
                objout = new ObjectOutputStream(fout);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Iterator it=match_list123.iterator();
            while (it.hasNext()){
                Match matchs=(Match) it.next();
                try {
                    objout.writeObject(matchs);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            FileWriter fwOb1 = null;
            try {
                fwOb1 = new FileWriter("footballClubDetails.txt", false);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pwOb1 = new PrintWriter(fwOb1, false);
            pwOb1.flush();
            pwOb1.close();
            try {
                fwOb1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            File file1=new File("footballClubDetails.txt");
            FileOutputStream fout1=null;
            try {
                fout1=new FileOutputStream(file1,true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectOutputStream objout1=null;
            try {
                objout1=new ObjectOutputStream(fout1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Iterator it1=club_list123.iterator();
            while (it1.hasNext()){
                FootballClub club=(FootballClub) it1.next();
                System.out.println(club);
                try {
                    objout1.writeObject(club);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }







        }



        @Override
        public void sortWinanguler() {

            ObservableList<FootballClub> club_list123= FXCollections.observableArrayList();
            //array list use to store all match deatails
            ObservableList<Match> match_list123=FXCollections.observableArrayList();
            FileInputStream fin= null;
            try {
                fin = new FileInputStream("matchDetails.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectInputStream objin= null;
            try {
                objin = new ObjectInputStream(fin);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true){
                try {
                    System.out.println("ssdsfdsfsf");
                    Match match=(Match) objin.readObject();
                    System.out.println(match);
                    match_list123.add(match);
                }catch (IOException|ClassNotFoundException e){
                    break;
                }
            }
            FileInputStream find= null;
            try {
                find = new FileInputStream("footballClubDetails.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectInputStream objind= null;
            try {
                objind = new ObjectInputStream(find);
                System.out.println("load");
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true){
                try {
                    System.out.println("ssdsfdsfsf");
                    FootballClub club=(FootballClub) objind.readObject();
                    System.out.println(club);
                    club_list123.add(club);
                }catch (IOException|ClassNotFoundException e){
                    break;
                }
            }

            Collections.sort(club_list123, new Comparator<FootballClub>() {
                @Override
                public int compare(FootballClub o1, FootballClub o2) {
                    int compare=Integer.compare(o2.getWins(),o1.getWins());
                    return compare;
                }
            });



            FileWriter fwOb = null;
            try {
                fwOb = new FileWriter("matchDetails.txt", false);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            try {
                fwOb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            File file=new File("matchDetails.txt");
            FileOutputStream fout= null;
            try {
                fout = new FileOutputStream(file,true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectOutputStream objout= null;
            try {
                objout = new ObjectOutputStream(fout);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Iterator it=match_list123.iterator();
            while (it.hasNext()){
                Match matchs=(Match) it.next();
                try {
                    objout.writeObject(matchs);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            FileWriter fwOb1 = null;
            try {
                fwOb1 = new FileWriter("footballClubDetails.txt", false);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pwOb1 = new PrintWriter(fwOb1, false);
            pwOb1.flush();
            pwOb1.close();
            try {
                fwOb1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            File file1=new File("footballClubDetails.txt");
            FileOutputStream fout1=null;
            try {
                fout1=new FileOutputStream(file1,true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectOutputStream objout1=null;
            try {
                objout1=new ObjectOutputStream(fout1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Iterator it1=club_list123.iterator();
            while (it1.hasNext()){
                FootballClub club=(FootballClub) it1.next();
                System.out.println(club);
                try {
                    objout1.writeObject(club);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }







        }


        @Override
        public String search(String days,String months,String years) {
            if(isnum(days)==false){
                return "day is not integure";
            }
            if(isnum(months)==false){
                return "month is not integure";
            }
            if(isnum(years)==false){
                return "year is not integure";
            }
            int day=Integer.parseInt(days);
            int month=Integer.parseInt(months);
            int year=Integer.parseInt(years);


            String a="";
            int i=0;
            if(validation(day,month,year)==false){
                return "not a real date";

            }
            for(Match match :match_list){


                if(match.getDay()==day && match.getMonth()==month && match.getYear()==year){
                    i=1;
                    a=a+day+"|"+month+"|"+year+"   "+match.getClub1()+" VS "+match.getClub2()+"   "+match.getScore1()+"---"+match.getScore2()+"\n";





                }



            }
            if(i==0){
                return "no match was played on the given day";
            }





            return a;
        }

        @Override
        public ObservableList search(int days,int months,int years) {
            ObservableList<Match> match_list2=FXCollections.observableArrayList();
            ObservableList<Match> match_list3=FXCollections.observableArrayList();
            FileInputStream fin= null;
            try {
                fin = new FileInputStream("matchDetails.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectInputStream objin= null;
            try {
                objin = new ObjectInputStream(fin);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true){
                try {
                    System.out.println("ssdsfdsfsf");
                    Match match=(Match) objin.readObject();
                    System.out.println(match);
                    match_list2.add(match);
                }catch (IOException|ClassNotFoundException e){
                    break;
                }
            }



            String a="";
            int i=0;

            for(Match match :match_list2){


                if(match.getDay()==days && match.getMonth()==months && match.getYear()==years){
                    match_list3.add(match);






                }



            }
            return match_list3;






        }



        @Override
        public void addClub(){
             String clubName,clubAddress,numMember;
            while (true) {//walidate numbers
                //add club name
                System.out.print("Club Name:");
                clubName="";
                clubName=clubName+sc.nextLine();
                if(clubName.equals("")){
                    System.out.println("empty");
                    continue;
                }
                if(isClub(clubName)==false){
                    break;
                }
                System.out.println("club already exist");


            }

            //add address
            while (true) {//walidate numbers
                clubAddress="";
                System.out.print("Club Address:");
                clubAddress=clubAddress+sc.nextLine();
                if(clubAddress.equals("")){
                    System.out.println("empty");
                    continue;
                }
                break;

            }

            while (true) {//walidate numbers
                numMember="";
                System.out.print("number of members:");
                numMember = numMember+sc.nextLine();
                if(numMember.equals("")){
                    System.out.println("empty");
                    continue;
                }
                if(isnum(numMember)==true){
                    break;
                }
            }
            int numMembers=Integer.parseInt(numMember);
            //add to football club



            FootballClub club=new FootballClub(clubName,clubAddress,numMembers,0,0,0,0,0,0,0);










            club_list.add(club);



        }

        @Override
        public void findClub(){
            //get name of the club which must be searched
            System.out.print("name of club :");
            String name="";
            name=sc.nextLine();
            if(name.equals("")){
                System.out.println("empty");

            }else {if(isClub(name)==true){
                for(FootballClub club :club_list) {

                        if (club.getClubName().equals(name)) {
                            System.out.println("Name:" + club.getClubName());
                            System.out.println("Address:" + club.getClubAddress());
                            System.out.println("Number of members:" + club.getNumMember());

                            if (club instanceof FootballClub) {
                            System.out.println("wins:" + ((FootballClub) club).getWins());
                            System.out.println("defeats:" + ((FootballClub) club).getDefeats());
                            System.out.println("draws:" + ((FootballClub) club).getDraws());
                            System.out.println("goals recieved:" + ((FootballClub) club).getNumGoalsRecieved());
                            System.out.println("goals scored:" + ((FootballClub) club).getNumGoalsScored());
                            System.out.println("points scores:" + ((FootballClub) club).getClubPoints());
                            System.out.println("number of matches played:" + ((FootballClub) club).getNumMatch());
                            }
                        }
                    }
                }else{
                System.out.println("club does not exist"); }
            }



        }
        @Override
        public void clubTable(){//scoreboard
            Collections.sort(club_list);//sort data according to the footballclub
            int aa=9,bb=4,cc=7,dd=5,ee=14,ff=14,gg=12,hh=12;


            String leftAlignFormat = "| %-"+aa+"s | %-"+bb+"d | %-"+cc+"d | %-"+dd+"d | %-"+ee+"d | %-"+ff+"d | %-"+gg+"d | %-"+hh+"d |%n";
            String leftAlignFormat1 = "| %-"+aa+"s | %-"+bb+"s | %-"+cc+"s | %-"+dd+"s | %-"+ee+"s | %-"+ff+"s | %-"+gg+"s | %-"+hh+"s |%n";




            System.out.format("+-"+"---------"+"-+-"+"----"+"-+-"+"-------"+"-+-"+"-----"+"-+-"+"--------------"+"-+-"+"--------------"+"-+-"+"------------"+"-+-"+"------------"+"-+%n");
//
            System.out.format(leftAlignFormat1, "Club Name","Wins","Defeats","Draws","Matches Played","Goals Recieved","Goals Scored","Point Scored");
////
            System.out.format("+-"+"---------"+"-+-"+"----"+"-+-"+"-------"+"-+-"+"-----"+"-+-"+"--------------"+"-+-"+"--------------"+"-+-"+"------------"+"-+-"+"------------"+"-+%n");






            for(FootballClub club :club_list){

                System.out.format(leftAlignFormat,club.getClubName(),club.getWins(),club.getDefeats(),club.getDraws(),club.getNumMatch(),club.getNumGoalsRecieved(),club.getNumGoalsScored(),club.getClubPoints());


















            }
            System.out.format("+-"+"---------"+"-+-"+"----"+"-+-"+"-------"+"-+-"+"-----"+"-+-"+"--------------"+"-+-"+"--------------"+"-+-"+"------------"+"-+-"+"------------"+"-+%n");


        }


        public boolean isnum(String a){//see if number is int
            try{
                int x=Integer.parseInt(a);
                if(x>=0 ) {
                    return true;
                }else {
                    System.out.println("negative number");
                    return false;
                }

            }catch (Exception e){
                System.out.println("not a integure");
                return false;
            }

        }
        @Override
        public void sort1(){
            Collections.sort(club_list, new Comparator<FootballClub>() {
                @Override
                public int compare(FootballClub o1, FootballClub o2) {
                    int compare=Integer.compare(o2.getWins(),o1.getWins());
                    return compare;
                }
            });

        }
        @Override
        public void sort2(){
            Collections.sort(club_list, new Comparator<FootballClub>() {
                @Override
                public int compare(FootballClub o1, FootballClub o2) {
                    int compare=Integer.compare(o2.getNumGoalsScored(),o1.getNumGoalsScored());
                    return compare;
                }
            });

        }

        public boolean isClub(String a){//see if club is regitered
            boolean ab=false;
            for(FootballClub club :club_list){


                if(club.getClubName().equals(a)){
                    ab=true;





                }



            }
            return ab;


        }
        public static boolean validation(int day,int month,int year){//valitate numbers to see if it is real window
            int x=year%400;
            //leapyear februvery
            if(x==0 && month==02 && day<30){
                return true;

            }//not leap year feburary
            else if(x!=0 && month==02 && day<29){
                return true;

            }//months with
            else if((month==1 ||month==3 || month==5 ||month==7 ||month==8 || month==10 ||month==12) && (day<32)){
                return true;

            }else if((month==4 ||month==6 || month==9|| month==11) && (day<31)){
                return true;

            }else{
                return false;
            }

        }

    }




