package com.gravyty.beassign;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
public class weatherAPIClient {

        public static String makeHTTPCall(String url) {
                try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                    HttpGet httpGet = new HttpGet(url);

                    try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                        int responseCode = response.getStatusLine().getStatusCode();
                        System.out.println(" ~~~!!! Response Code: !!!~~~ " + responseCode);
                        return EntityUtils.toString(response.getEntity());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
}
/*            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);

            try {
                HttpResponse response = httpClient.execute(httpGet);
                return EntityUtils.toString(response.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }*/

 /// RESTful Java client: https://alvinalexander.com/java/java-apache-httpclient-restful-client-examples/
/// https://www.geeksforgeeks.org/try-with-resources-feature-in-java/

// ISO 3166 country codes : "Tel-Aviv,IL","London,GB","New York,US-NY,US"