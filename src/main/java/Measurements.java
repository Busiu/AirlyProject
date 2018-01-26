import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Measurements {

    //FIELDS
    private SingleMeasurements currentMeasurements;
    private History [] history;

    private AsciiArt historia;
    private AsciiArt obecnie;

    //CONSTRUCTOR
    public Measurements() throws FileNotFoundException{
        historia = new AsciiArt(new Scanner(new File(".\\ascii\\HISTORIA.txt")));
        obecnie = new AsciiArt(new Scanner(new File(".\\ascii\\OBECNIE.txt")));
    }

    //METHODS
    public void writeAll() throws FileNotFoundException{
        obecnie.draw();
        currentMeasurements.write();
        historia.draw();
        for(int i = 0; i < history.length; i++){
            history[i].write(i + 1);
        }
    }

    public void format(){
        currentMeasurements.format();
        for(History history : history){
            history.format();
        }
    }

    public void write(){
        obecnie.draw();
        currentMeasurements.write();
    }

}
