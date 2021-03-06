package org.example.dbConnections;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Connection {

    @Bean
    public MongoDatabase getConnection(){

        MongoDatabase database;
        MongoClientURI uri = new MongoClientURI("mongodb+srv://dbUser:dbPassword@cluster0-1bxg9.mongodb.net/sample_analytics?retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        return mongoClient.getDatabase("sample_analytics");

    }


}
