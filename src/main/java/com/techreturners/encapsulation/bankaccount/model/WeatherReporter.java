package com.techreturners.encapsulation.bankaccount.model;

import java.text.MessageFormat;

public class WeatherReporter {

    private static final String LONDON = "London";
    private static final String CALIFORNIA = "California";
    private static final String CAPE_TOWN = "Cape Town";
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

    private String getLocationBasedEmoji() {
        if (LONDON.equalsIgnoreCase(location)) {
            return "🌦";
        } else if (CALIFORNIA.equalsIgnoreCase(location)) {
            return "🌅";
        } else if (CAPE_TOWN.equalsIgnoreCase(location)) {
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


    private double celsiusToFahrenheit() {
        return (9.0 / 5.0) * temperature + 32;
    }

    public static void main(String[] args) {
        WeatherReporter weatherReporter = new WeatherReporter("London", 18);
        System.out.println(weatherReporter.print());
    }
}
