package com.qa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String boxer1Name;
    private String boxer2Name;
    private String location;
    private String result;
    private Long winnerId;


    public Long getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoxer1Name() {
        return boxer1Name;
    }

    public void setBoxer1Name(String boxer1Name) {
        this.boxer1Name = boxer1Name;
    }

    public String getBoxer2Name() {
        return boxer2Name;
    }

    public void setBoxer2Name(String boxer2Name) {
        this.boxer2Name = boxer2Name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
