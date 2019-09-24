package com.qa.controllers;

import com.qa.models.Event;
import com.qa.repository.EventRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventControllerTest {

    @InjectMocks
    private EventController eventController;

    @Mock
    private EventRepository repository;

    @Test
    public void testGetAllBoxers(){
        List<Event> eventList = new ArrayList<>();

        Event event = new Event();
        event.setId(1L);
        event.setBoxer1("Floyd Mayweather");
        event.setBoxer2("Canelo Alvarez");
        event.setLocation("Las Vegas");
        event.setResult("UD12");
        eventList.add(event);

        Event event2 = new Event();
        event2.setId(1L);
        event2.setBoxer1("Tyson Fury");
        event2.setBoxer2("Deontay Wilder");
        event2.setLocation("Staples Center");
        event2.setResult("KO5");
        eventList.add(event2);

        when(repository.findAll()).thenReturn(eventList);
        assertEquals(
                eventController.listAllEvent().get(0).getBoxer1(),
                "Floyd Mayweather"
        );
        assertEquals(
                eventController.listAllEvent().get(1).getBoxer2(),
                "Deontay Wilder"
        );
    }

    @Test
    public void testGetOneEvent(){
        Event event = new Event();
        event.setId(100L);
        event.setBoxer1("Anthony Fowler");
        event.setBoxer2("Scott Fitzgerald");
        event.setLocation("Liverpool");
        event.setResult("SD12");
        when(repository.findOne(100L)).thenReturn(event);
        assertEquals(eventController.getEvent(100L).getBoxer2(), "Scott Fitzgerald" );
    }

    @Test
    public void addEventTest(){
        Event event = new Event();
        event.setId(420L);
        event.setBoxer1("Chris Perrins");
        event.setBoxer2("Tadas Vaidotas");
        event.setLocation("Manchester Arena");
        event.setResult("KO1");

        when(repository.saveAndFlush(event)).thenReturn(event);
        assertEquals(eventController.addEvent(event).getResult(), "KO1");
    }



    @Test
    public void deleteEventTest(){
        Event event = new Event(1L, "Chris Perrins", "Tadas Vaidotas", "Manchester Arena", "KO1");


        when(repository.findOne(1L)).thenReturn(event);

        assertEquals(eventController.deleteEvent(1L).getResult(), "KO1");
    }






}
