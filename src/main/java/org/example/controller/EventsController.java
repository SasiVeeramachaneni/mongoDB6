package org.example.controller;/*
 * $
 *
 * Copyright (c) 2020  Pegasystems Inc.
 * All rights reserved.
 *
 * This  software  has  been  provided pursuant  to  a  License
 * Agreement  containing  restrictions on  its  use.   The  software
 * contains  valuable  trade secrets and proprietary information  of
 * Pegasystems Inc and is protected by  federal   copyright law.  It
 * may  not be copied,  modified,  translated or distributed in  any
 * form or medium,  disclosed to third parties or used in any manner
 * not provided for in  said  License Agreement except with  written
 * authorization from Pegasystems Inc.
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bson.Document;
import org.example.models.Event;
import org.example.models.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vagrant
 * @version $ 8/20/20
 */
@RestController
@RequestMapping("/events")
public class EventsController {
    @Autowired
    MongoDatabase database;
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/events")
    @GetMapping
    public GetResponse getEvents(){
        List<Document> results = new ArrayList<>();
        for (Document pegaEvents : database.getCollection("pegaEvents").find()) {
            results.add(pegaEvents);
        }
        GetResponse response = new GetResponse();
        response.setResults(results);
        return  response;
    }


    @PostMapping
    public void addEvent(@RequestBody Event event) {

        System.out.println(event.getAuthor());
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonStr = mapper.writeValueAsString(event);
            TypeReference<HashMap<String, Object>> typeRef
                    = new TypeReference<HashMap<String, Object>>() {
            };

            HashMap<String, Object> document = mapper.readValue(jsonStr, typeRef);
            database.getCollection("pegaEvents").insertOne(new Document(document));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

   /* @RequestMapping("/events/{ID}")
    @GetMapping
    public ResponseEntity<Document> getEvent(@PathParam("ID") String id) {
        Document doc = database.getCollection("pegaEvents").find(Filters.and(Filters.eq("id", id))).first();
        return new ResponseEntity<Document>(doc, HttpStatus.OK);
    }*/
}
