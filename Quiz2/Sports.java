import java.util.ArrayList;

public class Sports {
	
    private String sportType;

    private String firstClub;

    private String secondClub;

    private String matchResult;

    private int[][] clubStats;

    private ArrayList<String> clubNames;

    public Sports(String sportType,String firstClub,String secondClub,
            String matchResult,ArrayList<String> clubNames,int[][] clubStats) {

            this.sportType= sportType;
            this.firstClub=firstClub;
            this.secondClub=secondClub;
            this.matchResult= matchResult;
            this.clubNames=clubNames;
            this.clubStats=clubStats;
    }

    public void hockeyCalculator() {

        IceHockey icehockey = new IceHockey(sportType, firstClub, secondClub, matchResult,clubNames,clubStats);
        icehockey.calculator();

    }

    public void handballCalculator() {

        Handball handball = new Handball(sportType, firstClub, secondClub, matchResult,clubNames,clubStats);
        handball.calculator();

    }

    public void basketballCalculator() {

        Basketball basketball = new Basketball(sportType, firstClub, secondClub, matchResult,clubNames,clubStats);
        basketball.calculator();

    }

    public void volleyballCalculator() {

        Volleyball volleyball = new Volleyball(sportType, firstClub, secondClub, matchResult,clubNames,clubStats);
        volleyball.calculator();

    }

    public String getSportType() {
            return sportType;
    }

    public void setSportType(String sportType) {
            this.sportType = sportType;
    }

    public String getFirstClub() {
            return firstClub;
    }

    public void setFirstClub(String firstClub) {
            this.firstClub = firstClub;
    }

    public String getSecondClub() {
            return secondClub;
    }

    public void setSecondClub(String secondClub) {
            this.secondClub = secondClub;
    }

    public String getMatchResult() {
            return matchResult;
    }

    public void setMatchResult(String matchResult) {
            this.matchResult = matchResult;
    }

    public ArrayList<String> getClubNames() {
        return clubNames;
    }

    public void setClubNames(String obje) {
        clubNames.add(obje);
    }

    public ArrayList<String> resetClubNames() {
        clubNames.clear();
        return clubNames;
    }

    public int[][] getClubStats() {
        return clubStats;
    }

    public void setClubStats(int[][] clubStats) {
        this.clubStats = clubStats;
    }
	
}
