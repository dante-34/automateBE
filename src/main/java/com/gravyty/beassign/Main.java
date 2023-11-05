package com.gravyty.beassign;

public class Main {
    public static void main(String[] args) {

        String APIKey = "not_the_one_ending_with_36bf";
        String baseUrl = "https://api.openweathermap.org/data/2.5/weather?";
        String myArguments1 = "units=imperial&APPID=" + APIKey + "&q=Tel-Aviv,IL";
        String myArguments2 = "units=imperial&APPID=" + APIKey + "&q=London,GB";
        String myArguments3 = "units=imperial&APPID=" + APIKey + "&q=New York,US-NY,US";

        String response = weatherAPIClient.makeHTTPCall(baseUrl + myArguments1);
        // Process the response or perform additional tasks

        System.out.println(" RESPONSE= " + response);
    }

}