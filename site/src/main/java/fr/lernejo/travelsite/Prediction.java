package fr.lernejo.travelsite;

import java.util.Collection;

public record Prediction(String country, Collection<Temperature> temperatures) {
}
