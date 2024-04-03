import java.util.*;

class WeatherData {
    private double temperature;
    private double humidity;
    
    public WeatherData(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }
    
    public double getTemperature() {
        return temperature;
    }
    
    public double getHumidity() {
        return humidity;
    }
}

public class WeatherData {
    public static void main(String[] args) {
        List<WeatherData> weatherDataList = new ArrayList<>();
        // Populate weatherDataList with weather data
        
        // Example weather data
        weatherDataList.add(new WeatherData(25.0, 60.0));
        weatherDataList.add(new WeatherData(12.0, 70.0));
        weatherDataList.add(new WeatherData(5.0, 80.0));
        weatherDataList.add(new WeatherData(-5.0, 50.0));
        weatherDataList.add(new WeatherData(18.0, 65.0));
        
        Map<String, Integer> daysByTemperatureRange = new HashMap<>();
        Map<String, Double> averageHumidityByTemperatureRange = new HashMap<>();
        
        // Initialize temperature ranges
        String[] temperatureRanges = {"<0°C", "0-10°C", "10-20°C", "20-30°C", ">30°C"};
        for (String range : temperatureRanges) {
            daysByTemperatureRange.put(range, 0);
            averageHumidityByTemperatureRange.put(range, 0.0);
        }
        
        // Analyze weather data
        for (WeatherData weatherData : weatherDataList) {
            double temperature = weatherData.getTemperature();
            double humidity = weatherData.getHumidity();
            String range = getTemperatureRange(temperature);
            
            daysByTemperatureRange.put(range, daysByTemperatureRange.get(range) + 1);
            averageHumidityByTemperatureRange.put(range, averageHumidityByTemperatureRange.get(range) + humidity);
        }
        
        // Calculate average humidity
        for (String range : temperatureRanges) {
            int days = daysByTemperatureRange.get(range);
            double averageHumidity = averageHumidityByTemperatureRange.get(range) / days;
            averageHumidityByTemperatureRange.put(range, averageHumidity);
        }
        
        // Display results
        System.out.println("Number of days with temperatures within certain ranges and average humidity:");
        for (String range : temperatureRanges) {
            System.out.println(range + ": Days - " + daysByTemperatureRange.get(range) + ", Average Humidity - " + averageHumidityByTemperatureRange.get(range));
        }
    }
    
    private static String getTemperatureRange(double temperature) {
        if (temperature < 0) {
            return "<0°C";
        } else if (temperature >= 0 && temperature < 10) {
            return "0-10°C";
        } else if (temperature >= 10 && temperature < 20) {
            return "10-20°C";
        } else if (temperature >= 20 && temperature < 30) {
            return "20-30°C";
        } else {
            return ">30°C";
        }
    }
}