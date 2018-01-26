import java.net.*;
import java.io.*;

public class URLInfoReader {

    public static String getInfo(String url, String apiKey) throws Exception{
        URL Airly = new URL(url);
        HttpURLConnection http = (HttpURLConnection) Airly.openConnection();
        http.setRequestMethod("GET");
        http.setRequestProperty("apikey", apiKey);
        BufferedReader br = new BufferedReader(new InputStreamReader(
                http.getInputStream()));

        String result = "";
        String input;

        while ((input = br.readLine()) != null)
            result += input;
        br.close();

        return result;
    }
}
