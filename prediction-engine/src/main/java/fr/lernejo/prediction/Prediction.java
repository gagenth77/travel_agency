package fr.lernejo.prediction;

import java.util.Collection;

public record Prediction(String country, Collection<Temperature> temperatures) {
}
