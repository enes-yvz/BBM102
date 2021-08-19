import java.util.ArrayList;

public class IceHockey extends Sports {
        
    public IceHockey(String sportType,String firstClub,String secondClub,String matchResult,ArrayList<String> clubNames,int[][] clubStats) {

            super(sportType,firstClub,secondClub,matchResult,clubNames,clubStats);	
    }

    public void calculator() {

        int[][] clubStats=getClubStats(); // Get empty array from superclass 

        String[] resultList= getMatchResult().split(":");         
        int firstClubScore =Integer.parseInt(resultList[0]);
        int secondClubScore =Integer.parseInt(resultList[1]);

        if (!getClubNames().contains(getFirstClub())) {
            //If team not in club names array add it
            setClubNames(getFirstClub());
        }

        if (!getClubNames().contains(getSecondClub())) {
           //Same thing for second team 
           setClubNames(getSecondClub());
        }

        int position =getClubNames().indexOf(getFirstClub());

        /* Get index of team in the club names and in the same 
        index of club stats array increase variables based on conditions  */

        clubStats[position][0]+=1;
        clubStats[position][4]+=firstClubScore;
        clubStats[position][5]+=secondClubScore;

        if (firstClubScore>secondClubScore){

            clubStats[position][1]+=1;
            clubStats[position][6]+=3;
        }
        else if(firstClubScore==secondClubScore){

            clubStats[position][2]+=1;
            clubStats[position][6]+=1;  
        }
        else{
            clubStats[position][3]+=1;
        }

        position =getClubNames().indexOf(getSecondClub());

        clubStats[position][0]+=1;
        clubStats[position][5]+=firstClubScore;
        clubStats[position][4]+=secondClubScore;

        if (secondClubScore>firstClubScore){

            clubStats[position][1]+=1;
            clubStats[position][6]+=3;   
        }
        else if(secondClubScore==firstClubScore){

            clubStats[position][2]+=1;
            clubStats[position][6]+=1;  
        }
        else{
            clubStats[position][3]+=1;
        }

        setClubStats(clubStats); // Replace the increased list with empty list in superclass

    }
}
