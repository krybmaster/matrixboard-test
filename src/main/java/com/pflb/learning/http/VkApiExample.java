package com.pflb.learning.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class VkApiExample {
    public static final String VERSION = "5.84";

    public static void main(String[] args) throws IOException {
        Map<String,String> params = new HashMap<>();
        params.put("owner_id", "30681723");

        URL url = buildUrl("wall.get", VERSION, params);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.addRequestProperty("User-Agent", "Pflb Learning system");
        connection.setDoOutput(true);
        InputStream inputStream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static URL buildUrl(String method, String version, Map<String,String> parameters) throws MalformedURLException {
        StringBuilder sb = new StringBuilder();
        sb.append("https://api.vk.com/method/");
        sb.append(method);
        sb.append("?");
        for (String key : parameters.keySet()) {
            sb.append(key);
            sb.append("=");
            sb.append(parameters.get(key));
            sb.append("&");
        }
        sb.append("v=");
        sb.append(version);
        System.out.println(sb);
        return new URL(sb.toString());
    }
}
