package com.example.daangnclone.domain.address.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@RestController
@RequestMapping("/address")
public class LocationController {
    @Value("${kakao.key}")
    String REST_KEY;

    @GetMapping("/")
    public JSONObject test() {
        System.out.println("hi");
        return loadLocation();
    }

    @GetMapping("/test")
    public String test2() {
        return "hi";
    }
    /** Controller **/
    public JSONObject loadLocation() {


        Double lon = 127.423084873712;
        Double lat = 37.0789561558879;
        String url2 = "https://dapi.kakao.com/v2/local/geo/coord2regioncode.json?x=" + lon + "&y=" + lat;

        BufferedReader br = null;
        JSONObject obj = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();

        try {
            URL url = new URL(url2);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Authorization", "KakaoAK " + REST_KEY);
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            if(br != null) obj = mapper.readValue(br, JSONObject.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return obj;

    }
}
