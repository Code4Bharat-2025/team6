package com.bharat.team6.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;


@Service
public class SwiftChatSenderService {

    private static final String API_URL = "https://v1-api.swiftchat.ai/api/bots/0239994858346620/messages";
    private static final String API_KEY = "21bda582-e8d0-45bc-bb8b-a5c6c555d176";
    private static final String BOT_ID = "0239994858346620";

    public void sendMessage(String to, String message) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(API_KEY);

        //Map<String, Object> textBody = Map.of("body", message);
        JSONObject textBody = new JSONObject();
        textBody.put("body", message);

        //Map<String, Object> requestBody = new HashMap<>();
        JSONObject requestBody = new JSONObject();
        requestBody.put("to", "+919009638270");
        requestBody.put("type", "text");
        requestBody.put("text", textBody);



        HttpEntity<JSONObject> request = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(API_URL, request, String.class);
            System.out.println("Message sent: " + response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

