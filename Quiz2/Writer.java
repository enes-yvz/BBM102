
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Writer {
    
    public static void writer(String[][] mainList,String symbol){
            
            
        String fourth=("4."+"\t"+mainList[0][7]+"\t"+mainList[0][0]+"\t"+ mainList[0][1]+
                            "\t"+ mainList[0][2]+"\t" +mainList[0][3]+"\t"+mainList[0][4]+":"+
                            mainList[0][5]+"\t"+mainList[0][6]);
        String third=("3."+"\t"+mainList[1][7]+"\t"+mainList[1][0]+"\t"+ mainList[1][1]+
                            "\t"+ mainList[1][2]+"\t" +mainList[1][3]+"\t"+mainList[1][4]+":"+
                            mainList[1][5]+"\t"+mainList[1][6]);
        String second=("2."+"\t"+mainList[2][7]+"\t"+mainList[2][0]+"\t"+ mainList[2][1]+
                            "\t"+ mainList[2][2]+"\t" +mainList[2][3]+"\t"+mainList[2][4]+":"+
                            mainList[2][5]+"\t"+mainList[2][6]);
        String first=("1."+"\t"+mainList[3][7]+"\t"+mainList[3][0]+"\t"+ mainList[3][1]+
                            "\t"+ mainList[3][2]+"\t" +mainList[3][3]+"\t"+mainList[3][4]+":"+
                            mainList[3][5]+"\t"+mainList[3][6]);

        String article=(first+"\n"+second+"\n"+third+"\n"+fourth);
        
        FileWriter fileWriter =null;

        if (symbol.equals("I")){
            try {
                fileWriter= new FileWriter("icehockey.txt");
                fileWriter.write(article);
            } catch (IOException ex) {
                Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                if(fileWriter !=null){
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        if (symbol.equals("H")){
            try {
                fileWriter= new FileWriter("handball.txt");
                fileWriter.write(article);
            } catch (IOException ex) {
                Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
               if(fileWriter !=null){
                   try {
                       fileWriter.close();
                   } catch (IOException ex) {
                       Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
           }
        }

        if (symbol.equals("B")){
             try {
                fileWriter= new FileWriter("basketball.txt");
                fileWriter.write(article);
            } catch (IOException ex) {
                Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                if(fileWriter !=null){
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        if (symbol.equals("V")){
             try {
                fileWriter= new FileWriter("volleyball.txt");
                fileWriter.write(article);
            } catch (IOException ex) {
                Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                if(fileWriter !=null){
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
    }
}
