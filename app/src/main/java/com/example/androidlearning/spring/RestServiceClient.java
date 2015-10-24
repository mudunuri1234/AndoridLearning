package com.example.androidlearning.spring;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * Created by fcwl on 6/11/2015.
 *
 * http://sankarganesh-info-exchange.blogspot.com/p/need-and-vital-role-of-asynctas-in.html
 *
 * 1. Void - Must match doInBackground - Params type
 * 2. Void - Must match onProgressUpdate - values parameter
 * 3. Map<String, String> - Must match onPostExecute - parameter
 * 4. Return type of doInBackground must match the onPostExecute method parameter
 *
 * 1. Instance of Async Task needs to be created in UI thread. As shown in  onClick method a new instance of
 *    LongOperation is created there. Also execute method with parameters should be called from UI thread.
 *
 * 2. Methods onPostExecute, onPreExecute and onProgressUpdate should not be explicitly called.
 */
public class RestServiceClient extends AsyncTask<Void, Void, Map<String, String>> {

    private EditText firstName;
    private EditText lastName;

    public RestServiceClient(EditText firstName, EditText lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    protected Map<String, String> doInBackground(Void... params) {
        System.out.println("--------- doInBackground --------" + params);
        Map<String, String> namesMap = invokeRestService();
//            try {
//                invokeRestServiceHttp();
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }

        return namesMap;
    }

    @Override
    protected void onPostExecute(Map<String, String> result) {
        // execution of result of Long time consuming operation
        System.out.println("--------- onPostExecute --------" + result);

        Status status = getStatus();
        System.out.println("------ Status 1 ------" + status.name());

        firstName.setText(result.get("firstName"));
        lastName.setText(result.get("lastName"));
    }

    @Override
    protected void onPreExecute() {
        // Things to be done before execution of long running operation.
        // For example showing Progress Dialog
        System.out.println("--------- onPreExecute --------");
    }

    @Override
    protected void onProgressUpdate(Void... values) {
     /* Things to be done while execution of long running operation
        is in progress. For example updating ProgessDialog */
        System.out.println("--------- onProgressUpdate --------");
    }

    private Map<String, String> invokeRestService() {
        System.out.println("------ invokeRestService called --------");
        try {
            Authenticator.setDefault(new ProxyAuthenticator("fcwl", "3943Round#"));
            System.setProperty("http.proxyHost", "in00pxy1.opr.statefarm.org");
            System.setProperty("http.proxyPort", "8000");

            // Using Spring REST template class to invoke the REST services.
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://grid-nightly.iml.pearson-intl.com/imlgrid/offlinecontent/userName/Srinihaha1@test.com/products";
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
            String xmlData = restTemplate.getForObject(url, String.class);

            Log.i("------ outputXML -----", xmlData);
            // Converting XML to a Java object using Simple XML framework.
            Serializer serializer = new Persister();
            Reader reader = new StringReader(xmlData);
            Products products = serializer.read(Products.class, reader, false);

            // Print the data.
            Log.i("------ First Name -----", products.getFirstName());
            Log.i("------ Last Name  -----", products.getLastName());
            List<Product> prodList = products.getProductList();
            for(Product product : prodList) {
                Log.i("------ Id -----", product.getId());
                Log.i("------ Short Description -----", product.getShortDescription());
                Log.i("------ Long Description -----", product.getLongDescription());
                Log.i("------ Href -----", product.getHref());
            }

            // Build a output map data
            Map<String, String> namesMap = new HashMap<String, String>();
            namesMap.put("firstName", products.getFirstName());
            namesMap.put("lastName", products.getLastName());

            return namesMap;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void invokeHttpRestService() throws Exception {
        Authenticator.setDefault(new ProxyAuthenticator("fcwl", "3943Round#"));
        System.setProperty("http.proxyHost", "in00pxy1.opr.statefarm.org");
        System.setProperty("http.proxyPort", "8000");

        String response;
        String endpointURL = "http://grid-nightly.iml.pearson-intl.com/imlgrid/offlinecontent/userName/Srinihaha1@test.com/products";
        Log.i("-------- subscribeUrl -------->", "" + endpointURL);

        //Invoke REST service
        URL url = new URL(endpointURL);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        // Retrieve result
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
            Log.i("-------- response line -------->", "" + line);
        }

        response = sb.toString();
        Log.i("-------- response -------->", "" + response);

        br.close();
    }

}
