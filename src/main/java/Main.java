
public class Main {

    public static void main(String args[]){
        try{
            OptionContainer optionContainer = new OptionContainer(args);

            AirlySupervisor airlySupervisor = new AirlySupervisor(optionContainer);
            airlySupervisor.getInfo();
            airlySupervisor.formatInfo();
            airlySupervisor.write();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }


        /*
        //System.out.println(optionContainer.getApiKey());
        //System.out.println(optionContainer.getUrl());
        //System.out.println(optionContainer.getHistory());

        AsciiArt art1 = new AsciiArt("3");
        AsciiArt art2 = new AsciiArt("7");
        AsciiArt art3 = new AsciiArt("23");
        AsciiArt art4 = new AsciiArt("123");
        AsciiArt art5 = new AsciiArt("5413");
        //AsciiArt art6 = new AsciiArt("234s");
        AsciiArt art7 = new AsciiArt("5543545");

        art1.draw();
        art2.draw();
        art3.draw();
        art4.draw();
        art5.draw();
        //art6.draw();
        art7.draw();




        */
    }
}
