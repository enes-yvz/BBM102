import java.util.ArrayList;
import java.util.Arrays;

public class Splitter {
    
    private ArrayList<String> clubNames = new ArrayList<String>(4);
    
    private int[][] clubStats;
	
	public String[][] setter(String[] fixtureList, String symbol) {
            
            clubStats = new int[4][7]; // Empty array for results
                
            for (int i=0;i<24;i++) {

                String fixtureLine=fixtureList[i];

                String[] fixtureParts = fixtureLine.split("\t");

                String sportType = fixtureParts[0];

                String firstClub = fixtureParts[1];

                String secondClub = fixtureParts[2];

                String matchResult= fixtureParts[3];

                if (sportType.equals(symbol)){

                    Sports sport = new Sports(sportType,firstClub,secondClub,matchResult,clubNames,clubStats);
                    sport.setSportType(sportType);
                    sport.setFirstClub(firstClub);
                    sport.setSecondClub(secondClub);
                    sport.setMatchResult(matchResult);

                    if (symbol.equals("I")){
                        sport.hockeyCalculator();
                    }

                    if (symbol.equals("H")){
                        sport.handballCalculator();
                    }
                    
                    if (symbol.equals("B")){
                        sport.basketballCalculator();
                    }
                    
                    if (symbol.equals("V")){
                        sport.volleyballCalculator();
                    }
                }

                if (i==23){ // End of the loop and return values 
                    
                    Sports sport = new Sports(sportType,firstClub,secondClub,matchResult,clubNames,clubStats);
                    int[][] clubStats =sport.getClubStats();
                    int[][] finalList = new int[4][9];
                    for (int x=0;x<4;x++){// I want match results with club names so I create new array
                        int[] temp = new int[9];
                        for (int y=0;y<7;y++){
                            temp[y]= (clubStats[x][y]);
                        }
                        temp[7]=x;
                        temp[8]=clubStats[x][4]-clubStats[x][5];
                        finalList[x]=temp;
                    }
                    
                    Arrays.sort(finalList, (a, b) -> Integer.compare(a[8], b[8]));
                    Arrays.sort(finalList, (a, b) -> Integer.compare(a[6], b[6]));
                    //Sort array based on points and difference between (number of sets For:the number of sets Against)
                    
                    String[][] lastList = new String[4][9]; 
                    
                    for (int x=0;x<4;x++){// I want match results with club names so I create new array
                        String[] temp = new String[9];
                        for (int y=0;y<7;y++){
                            temp[y]= (Integer.toString(finalList[x][y]));
                        }
                        temp[7]=(clubNames.get(finalList[x][7]));

                        temp[8]=Integer.toString(finalList[x][8]);
                        
                        lastList[x]=temp;
                    }
                   
                    clubNames=sport.resetClubNames();//Cleaning club names for the next loop
                    return lastList;
                    }
            }  
        return null;
    }
            
 }
