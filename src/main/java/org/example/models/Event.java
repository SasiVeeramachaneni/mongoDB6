package org.example.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Event {
    Event(String title, String author, LocalDateTime eventTime, String documentsLink, String webExLink){
        super();
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.eventTime = eventTime;
        this.documentsLink = documentsLink;
        this.webExLink = webExLink;
    }

    Event() {
        this.id = UUID.randomUUID().toString();
    }

    private String id;
    private String title;
    private String author;
    private LocalDateTime eventTime;
    private String webExLink;
    private String documentsLink;

    public String getWebExLink() {
        return webExLink;
    }

    public void setWebExLink(String webExLink) {
        this.webExLink = webExLink;
    }

    public String getDocumentsLink() {
        return documentsLink;
    }

    public void setDocumentsLink(String documentsLink) {
        this.documentsLink = documentsLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor() {
        this.author = author;
    }

    public LocalDateTime getEventTime(){
        return eventTime;
    }

    public void setEventTime() {
        this.eventTime = eventTime;
    }

}