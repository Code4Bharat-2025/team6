package com.bharat.team6.controller;

import com.bharat.team6.dto.SwiftChatRequestDTO;
import com.bharat.team6.service.NumberNuggetService;
import com.bharat.team6.service.SwiftChatSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swiftchat/webhook")
public class SwiftChatWebhookController {

    @Autowired
    private SwiftChatSenderService senderService;

    @PostMapping
    public ResponseEntity<String> processData(@RequestBody SwiftChatRequestDTO request) throws Exception{
        //System.out.println(request);
        String message = request.getMessage();
        String userId = request.getSender();

        String fact = NumberNuggetService.generateFact(message);

        senderService.sendMessage(userId, fact);
        return ResponseEntity.ok().build();
    }
}

