import com.sun.javaws.exceptions.InvalidArgumentException;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.util.Map;

public class OptionContainer {

    //FIELDS
    @Option(name = "--longitude", usage = "Podawana dlugosc geograficzna")
    private Double longitude = null;

    @Option(name = "--latitude", usage = "Podawana szerokosc geograficzna")
    private Double latitude = null;

    @Option(name = "--api-key", usage = "Klucz uwierzytelniajacy")
    private String apiKey = null;

    @Option(name = "--sensorId", usage = "Identyfikator sensora")
    private Integer sensorId = null;

    @Option(name = "--history", usage = "Czy chcemy wyswietlac historie, czy nie")
    private Boolean history = false;

    private String url = null;

    //CONSTRUCTOR
    public OptionContainer(String[] args) throws Exception{
            CmdLineParser parser = new CmdLineParser(this);
            Map<String, String> env = System.getenv();
            String API_KEY = env.get("API_KEY");
            if(!API_KEY.equals(null))
                apiKey = API_KEY;

            parser.parseArgument(args);
            validate();
            if(longitude != null && latitude != null){
                url = "https://airapi.airly.eu/v1/mapPoint/measurements?" + "latitude=" + latitude + "&longitude=" + longitude;
            }
            else if(sensorId != null){
                url = "https://airapi.airly.eu/v1/sensor/measurements?" + "sensorId=" + sensorId;
            }

    }

    //METHODS

    public String getApiKey() {
        return apiKey;
    }

    public String getUrl() {
        return url;
    }

    public Boolean getHistory() {
        return history;
    }

    private void validate() throws IllegalArgumentException{
        if((this.longitude == null || this.latitude == null) && this.sensorId == null)
            throw new IllegalArgumentException("Proszę podać poprawne argumenty (jest ich troszkę za mało)!");
        else if(apiKey == null)
            throw new IllegalArgumentException("Proszę podać poprawny api-key!");
        else if(longitude != null && latitude != null && sensorId != null)
            throw new IllegalArgumentException("Program nie jest w stanie rozstrzygnąć, które argumenty wziąć pod uwagę (współrzędne, czy ID sensora)!");

    }
}
