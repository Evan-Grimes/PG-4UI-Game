public class MainGame {
    public static void main(String[] args) {
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