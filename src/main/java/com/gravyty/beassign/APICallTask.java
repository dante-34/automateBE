package com.gravyty.beassign;
import java.util.concurrent.Callable;

public class APICallTask implements Callable<String> {
    private final String baseUrl;
    private final String apiKey;
    private final String location;
    private String units;

    public APICallTask(String baseUrl, String apiKey, String location) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.location = location;
        this.units = "imperial";
        if(location.contains("Aviv"))
            this.units = "metric";
    }

    @Override
    public String call() {
        String url = baseUrl + "APIKey=" + apiKey + "&q=" + location + "&units=" + units;
        //System.out.println("^^^DEBUG^^^ request=" + url);
        return weatherAPIClient.makeHTTPCall(url);
    }
}

