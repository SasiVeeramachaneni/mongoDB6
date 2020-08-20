package org.example.dbConnections;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class Connection {
    MongoDatabase database;

    public Connection(){

        MongoDatabase database;
        MongoClientURI uri = new MongoClientURI("mongodb+srv://dbUser:dbPassword@cluster0-1bxg9.mongodb.net/sample_analytics?retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        this.database = mongoClient.getDatabase("sample_analytics");


    }


}
