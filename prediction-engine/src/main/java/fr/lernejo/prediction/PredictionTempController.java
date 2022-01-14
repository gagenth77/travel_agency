package fr.lernejo.prediction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@RestController
public class PredictionTempController {
    private final TemperatureService temperatureService;

    public PredictionTempController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping("/api/temperature")
    public Prediction predireTemperature(@RequestParam String country) {
        Collection<Temperature> temperatureList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            double temp = temperatureService.getTemperature(country);
            LocalDate date = LocalDate.now().minusDays(i);
            temperatureList.add(new Temperature(date.toString(), temp));
        }
        return new Prediction(country, temperatureList);
    }
}
