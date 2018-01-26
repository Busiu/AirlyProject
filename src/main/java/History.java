import java.io.FileNotFoundException;

public class History {

    //FIELDS
    private String fromDateTime;
    private String tillDateTime;
    private SingleMeasurements measurements;

    //CONSTRUCTOR
    public History(){

    }

    //METHODS
    public void format(){
        fromDateTime = fromDateTime.replace("T", " ");
        fromDateTime = fromDateTime.replace("Z", "");
        tillDateTime = tillDateTime.replace("T", " ");
        tillDateTime = tillDateTime.replace("Z", "");
    }

    public void write(int index) throws FileNotFoundException{
        AsciiArt subTitle = new AsciiArt(Integer.toString(index));
        subTitle.draw();
        if(!(measurements == null)){
            if(fromDateTime != null)
                System.out.println("Początek Pomiaru: " + fromDateTime);
            else
                System.out.println("Początek Pomiaru: " + "brak danych");
            //-------------------------------------------------------------------
            if(tillDateTime != null)
                System.out.println("Koniec Pomiaru: " + tillDateTime);
            else
                System.out.println("Koniec Pomiaru: " + "brak danych");
            //-------------------------------------------------------------------
            measurements.write();
        }
        else
            System.out.println("Brak historycznych danych!");

    }

}
