package com.techreturners.encapsulation.bankaccount.model;

import java.text.MessageFormat;

public class WeatherReporter {

    private final String location;
    private final double temperature;

    public WeatherReporter(String location, double temperature) {
        this.location = location;
        this.temperature = temperature;
    }

    public String print() {
        return MessageFormat.format("I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3} .",
                location, getLocationBasedEmoji(), getTagline(), celsiusToFahrenheit());
    }

    private final String LONDON ="London";
    private final String CALIFORNIA ="California";
    private final String CAPE_TOWN ="Cape Town";
   
   
    private String getLocationBasedEmoji() {
        if (location.equalsIgnoreCase(LONDON)) {

            return "🌦";

        } else if (location.equalsIgnoreCase(CALIFORNIA)) {

            return "🌅";

        } else if (location.equalsIgnoreCase(CAPE_TOWN)) {

            return "🌤";

        }
        return "🔆";
    }

    private String getTagline() {
        if (temperature > 30) {

            return "It's too hot 🥵!";

        } else if (temperature < 10) {

            return "It's too cold 🥶!";

        }
        return "Ahhh...it's just right 😊!";
    }


    private double celsiusToFahrenheit(){
        return  (9.0 / 5.0) * temperature + 32;
    }


    public static void main(String[] args) {
        WeatherReporter weatherReporter = new WeatherReporter("London",18);
        System.out.println(weatherReporter.print());
    }
}
