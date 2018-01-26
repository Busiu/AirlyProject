public class SingleMeasurements {

    //FIELDS
    private Double airQualityIndex;
    private Double pm25;
    private Double pm10;
    private Double humidity;
    private Double pressure;
    private Double temperature;

    //CONSTRUCTOR
    public SingleMeasurements(){

    }

    //METHODS
    public void format(){

    }

    public void write(){
        if(airQualityIndex != null)
            System.out.println("Wspólny Indeks Jakości Powietrza: " + String.format("%.0f", airQualityIndex));
        else
            System.out.println("Wspólny Indeks Jakości Powietrza: " + "brak danych");
        //-------------------------------------------------------------------
        if(pm25 != null)
            System.out.println("PM 2,5: " + String.format("%.0f  --->  ", pm25) + String.format("%.0f%s", pm25/0.25, "%"));
        else
            System.out.println("PM 2,5: " + "brak danych");
        //-------------------------------------------------------------------
        if(pm10 != null)
            System.out.println("PM 10: " + String.format("%.0f  --->  ", pm10) + String.format("%.0f%s", pm10/0.5, "%"));
        else
            System.out.println("PM 10: " + "brak danych");
        //-------------------------------------------------------------------
        if(humidity != null)
            System.out.println("Wilgotność Powietrza: " + String.format("%.0f%s", humidity, "%"));
        else
            System.out.println("Wilgotność Powietrza: " + "brak danych");
        //-------------------------------------------------------------------
        if(pressure != null)
            System.out.println("Ciśnienie Atmosferyczne: " + String.format("%.0f%s", pressure/100, " hPa"));
        else
            System.out.println("Ciśnienie Atmosferyczne: " + "brak danych");
        //-------------------------------------------------------------------
        if(temperature != null)
            System.out.println("Temperatura Powietrza : " + String.format("%.0f%s", temperature, "°C"));
        else
            System.out.println("Temperatura Powietrza: " + "brak danych");
    }
}
