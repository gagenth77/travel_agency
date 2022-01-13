package fr.lernejo.travelsite;

public record Enregistrement(String userEmail, String userName, String userCountry,
                             WeatherExpectation weatherExpectation, int minimumTemperatureDistance) {
}
