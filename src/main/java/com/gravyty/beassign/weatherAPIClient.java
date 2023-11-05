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
                        //System.out.println("Response Code==" + response.getStatusLine().getStatusCode());
                        return EntityUtils.toString(response.getEntity());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
}
/// Scratchpad
/// RESTful Java client: https://alvinalexander.com/java/java-apache-httpclient-restful-client-examples/
/// https://www.geeksforgeeks.org/try-with-resources-feature-in-java/
/// Cities names with ISO 3166 compatible country codes : "Tel-Aviv,IL","London,GB","New York,US-NY,US"
/// https://dzone.com/articles/java-concurrency-multi-threading-with-executorserv