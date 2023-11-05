package com.gravyty.beassign;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
public class responseProcessor {
    public static void processAndPrintResponse(String json) {
        if (json != null)
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(json);

                String temperature = rootNode.path("main").path("temp").asText();
                String responseCode = rootNode.path("cod").asText();
                String locationName = rootNode.path("name").asText();
                String countryCode = rootNode.path("sys").path("country").asText();

                // Print a selection of fields in a readable format
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                System.out.println("Name-Of-Location: " + locationName);
                System.out.println("Response data: " + json);
                System.out.println("Response Code: " + responseCode + " ===>>> " + responseCodeComment(responseCode));
                System.out.println("Country: " + countryCode + verifyCorrectCountry(locationName,countryCode));

                if (locationName.contains("Aviv"))
                    System.out.println("Temperature in " + locationName + " is " + temperature + "°C");
                else
                    System.out.println("Temperature in " + locationName + " is " + temperature + "°F");

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    private static String responseCodeComment(String code) {
        if (code.equals("200"))
            return "Verification says all went well.";
        else
            return "Verification shows something went wrong.";
    }

    private static String verifyCorrectCountry(String city, String state) {
        if (city.equals("Tel Aviv")) {
            if (state.equals("IL"))
                return (" ===>>> Verifying: " + city + " is indeed inside " + state);
                else
                return (" ===>>> Failed verification: " + city + " is not in " + state);
        }
            return "";
    }
}
