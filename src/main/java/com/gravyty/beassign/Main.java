package com.gravyty.beassign;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class Main {
    public static void main(String[] args) {

        // Create an ExecutorService with two threads for concurrent execution
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Define the URLs for the API requests
        String baseUrl   = "https://api.openweathermap.org/data/2.5/weather?";
        String apiKey    = "not_the_one_ending_with_36bf";
        String location1 = "Tel-Aviv,IL";
        String location2 = "New%20York,US-NY,US"; // alternately "London,GB"

        // Create tasks for the API calls
        APICallTask task1 = new APICallTask(baseUrl, apiKey, location1);
        APICallTask task2 = new APICallTask(baseUrl, apiKey, location2);

        // Submit the tasks to the executor
        Future<String> response1 = executor.submit(task1);
        Future<String> response2 = executor.submit(task2);

        // Process the responses
        try {
            String result1 = response1.get();
            String result2 = response2.get();

            System.out.println("Response for Tel Aviv: ");//+ result1);
            responseProcessor.processAndPrintResponse(result1);
            System.out.println("Response for New York City: "); //+ result2);
            responseProcessor.processAndPrintResponse(result2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Shutdown the executor
        executor.shutdown();
    }
}