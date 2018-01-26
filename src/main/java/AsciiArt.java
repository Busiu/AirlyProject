import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AsciiArt {
    //FIELDS
    private String art;

    //CONSTRUCTORS
    //Wczytywanie konkretnych obrazkow
    public AsciiArt(Scanner scanner){
        String art = "";
        while(scanner.hasNext()){
            art += scanner.nextLine();
            art += '\n';
        }

        this.art = art;
    }

    //Wczytywanie kombinacji obrazkow
    public AsciiArt(String number) throws FileNotFoundException{
        String art = "";
        int length = number.length();
        Scanner pomiar = new Scanner(new File(".\\ascii\\pomiar.txt"));
        Scanner [] scanners = new Scanner[length];
        for(int i = 0; i < length; i++){
            if(!Character.isDigit(number.charAt(i)))
                throw new FileNotFoundException("AsciiArt obsluguje tylko cyfry oraz 2 inne wyrazy!");

            scanners[i] = new Scanner(new File(".\\ascii\\" + number.charAt(i) + ".txt"));
        }


        while(pomiar.hasNext()){
            for(int i = 0; i < length; i++){
                art += scanners[i].nextLine();
            }
            art += " ";
            art += pomiar.nextLine();
            art += '\n';
        }

        this.art = art;
    }

    //METHODS
    public void draw(){
        System.out.println(art);
    }
}
