package org.example;

import org.bson.conversions.Bson;
import org.example.dbConnections.processEvents;
import org.bson.Document;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        //to Get the list of Events
        processEvents myEvents = new processEvents();

        Bson bson = myEvents.getEvent(198100);
        System.out.println(bson);
        Document document = (Document) bson;
        System.out.println((int) document.get("account_id"));


        //To delete the event from DB
        //myEvents.deleteEvent(557378);
    }
}
