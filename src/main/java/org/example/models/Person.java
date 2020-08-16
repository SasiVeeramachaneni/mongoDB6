package org.example.models;

public class Person {
    Person(String id){
        this.id = id;
    }

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        //Get name based pega ID. connect with Server
        return name;
    }

}