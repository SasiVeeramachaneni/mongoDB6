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

import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.example.models.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vagrant
 * @version $ 8/20/20
 */
@RestController
public class EventsController {
    @Autowired
    MongoDatabase database;
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/events")
    public GetResponse getEvents(){
        List<Document> results = new ArrayList<>();
        for (Document pegaEvents : database.getCollection("pegaEvents").find()) {
            results.add(pegaEvents);
        }
        GetResponse response = new GetResponse();
        response.setResults(results);
        return  response;
    }
}
