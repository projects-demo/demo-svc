package com.example.demo_svc;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoreResponse {
    @JsonProperty("Results")
    private List<String> results;

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }
}
