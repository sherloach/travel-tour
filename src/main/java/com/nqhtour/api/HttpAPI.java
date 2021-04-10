package com.nqhtour.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nqhtour.dto.EmployeeDTO;
import com.nqhtour.dto.TourDTO;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HttpAPI {

    public String getContentAPI(String api, DefaultHttpClient httpClient) throws IOException {
        //Define a HttpGet request; You can choose between HttpPost, HttpDelete or HttpPut also.
        //Choice depends on type of method you will be invoking.
        HttpGet getRequest = new HttpGet(api);

        //Set the API media type in http accept header
        getRequest.addHeader("accept", "application/json");

        //Send the request; It will immediately return the response in HttpResponse object
        HttpResponse response = httpClient.execute(getRequest);

        //verify the valid error code first
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200)
        {
            throw new RuntimeException("Failed with HTTP error code : " + statusCode);
        }

        // Now pull back the response object
        HttpEntity httpEntity = response.getEntity();
        String apiOutput = EntityUtils.toString(httpEntity);
        return apiOutput;
    }

    public EmployeeDTO getEmplDTO(String api) {
        EmployeeDTO model = new EmployeeDTO();
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            String apiOutput = getContentAPI(api, httpClient);
            ObjectMapper mapper = new ObjectMapper();
            model = mapper.readValue(apiOutput, EmployeeDTO.class);
        }
        finally
        {
            // Important: Close the connect
            httpClient.getConnectionManager().shutdown();
            return model;
        }
    }

    public int getTotal(String api) {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String apiOutput = "";
        try {
            apiOutput = getContentAPI(api, httpClient);
        }
        finally
        {
            // Important: Close the connect
            httpClient.getConnectionManager().shutdown();
            return Integer.parseInt(apiOutput);
        }
    }

    public TourDTO getTourDTO(String api) {
        TourDTO model = new TourDTO();
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try
        {
            /*
            //Define a HttpGet request; You can choose between HttpPost, HttpDelete or HttpPut also.
            //Choice depends on type of method you will be invoking.
            HttpGet getRequest = new HttpGet(api);

            //Set the API media type in http accept header
            getRequest.addHeader("accept", "application/json");

            //Send the request; It will immediately return the response in HttpResponse object
            HttpResponse response = httpClient.execute(getRequest);

            //verify the valid error code first
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200)
            {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }

            // Now pull back the response object
            HttpEntity httpEntity = response.getEntity();
            String apiOutput = EntityUtils.toString(httpEntity);*/

            String apiOutput = getContentAPI(api, httpClient);
            ObjectMapper mapper = new ObjectMapper();
            model = mapper.readValue(apiOutput, TourDTO.class);
        }
        finally
        {
            // Important: Close the connect
            httpClient.getConnectionManager().shutdown();
            return model;
        }
    }
}
