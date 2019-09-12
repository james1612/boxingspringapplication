package com.qa.controllers;

import com.qa.models.Event;
import com.qa.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class EventController {

    @Autowired
    private EventRepository repository;

    @RequestMapping(value = "events", method = RequestMethod.GET)
    public List<Event> listAllEvent(){
        return repository.findAll();
    }

    @RequestMapping(value = "events", method = RequestMethod.POST)
    public Event addEvent (@RequestBody Event event) {
        return repository.saveAndFlush(event);
    }

    @RequestMapping(value = "events/{id}", method = RequestMethod.GET)
    public Event getEvent(@PathVariable Long id){
        return repository.findOne(id);
    }

    @RequestMapping(value = "events/{id}", method = RequestMethod.DELETE)
    public Event deleteEvent(@PathVariable Long id) {
        Event existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }
}
