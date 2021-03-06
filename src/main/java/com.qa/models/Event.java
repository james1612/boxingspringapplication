package com.qa.models;

import javax.persistence.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String boxer1;
    private String boxer2;
    private String location;
    private String result;

    public Event(){
        super();
    }

    public Event(Long id, String boxer1, String boxer2, String location, String result) {
        this.id = id;
        this.boxer1 = boxer1;
        this.boxer2 = boxer2;
        this.location = location;
        this.result = result;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoxer1() {
        return boxer1;
    }

    public void setBoxer1(String boxer1) {
        this.boxer1 = boxer1;
    }

    public String getBoxer2() {
        return boxer2;
    }

    public void setBoxer2(String boxer2) {
        this.boxer2 = boxer2;
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
