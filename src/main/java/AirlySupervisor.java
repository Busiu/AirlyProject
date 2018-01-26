import com.google.gson.Gson;
import java.io.FileNotFoundException;

public class AirlySupervisor {

    private Measurements measurements;
    private Gson gson = new Gson();

    private OptionContainer optionContainer;

    //CONSTRUCTOR
    public AirlySupervisor(OptionContainer optionContainer){
        this.optionContainer = optionContainer;
    }

    public void getInfo() throws Exception{
        String JSON = URLInfoReader.getInfo(optionContainer.getUrl(), optionContainer.getApiKey());
        measurements = gson.fromJson(JSON, Measurements.class);
    }

    public void formatInfo(){
        measurements.format();
    }

    //METHODS
    public void write() throws FileNotFoundException{
        if(optionContainer.getHistory())
            measurements.writeAll();
        else
            measurements.write();
    }

}