public class Main {

    public static void main(String[] args) {
        
        String[] fixtureList = ReadFromFile.readFile(args[0]);
        Splitter splitter = new Splitter();
        String[] symbol = {"I","H","B","V"};//First letter of the sport types
        for (int x=0;x<4;x++){// For each sport type one loop
            String[][] mainList=splitter.setter(fixtureList,symbol[x]);//Get variables for output  
            Writer.writer(mainList,symbol[x]);//Write variables to type_of_sport.txt            
        }
    }
}
