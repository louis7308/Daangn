package com.example.daangnclone.domain.address.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

@RestController
@RequestMapping("/address")
public class LocationController {
    @Value("${kakao.key}")
    String REST_KEY;

    @GetMapping("/")
    public JSONObject test() throws UnsupportedEncodingException {
        System.out.println("hi");
        return loadLocation();
    }

    @GetMapping("/test")
    public String test2() {
        return "hi";
    }
    /** Controller **/
    public JSONObject loadLocation() throws UnsupportedEncodingException {


        Double lon = 126.8639; // 경도
        Double lat = 35.215; // 위도
        String url2 = "https://dapi.kakao.com/v2/local/geo/coord2regioncode.json?x=" + lon + "&y=" + lat;
        String url3 = "https://dapi.kakao.com/v2/local/search/address.json?query=";
        String address = URLEncoder.encode("대구광역시", "UTF-8");


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
