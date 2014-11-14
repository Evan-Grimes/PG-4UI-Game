import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) throws IOException {
        Frame frame = new Frame();
        String slvl=new String();
        
        int atk=1;
        int lvl=0;
        int hp=0;
        
        try{
        File level=new File("level.txt");
        if(!level.exists()){
    			 level.createNewFile();
                         slvl="one";
    		}
        FileWriter fileWritter = new FileWriter(level.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	        bufferWritter.write(slvl+" ");
    	        bufferWritter.close();
        }catch(IOException e){
    		e.printStackTrace();
    	}
        Scanner sin=new Scanner(new FileReader("level.txt"));
        while(sin.hasNext()){
        slvl=sin.next();

    }
}