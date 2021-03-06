package com.qa.controllers;

import com.qa.models.Boxer;
import com.qa.repository.BoxerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class BoxerController {

    @Autowired
    private BoxerRepository repository;

    @RequestMapping(value = "boxers", method = RequestMethod.GET)
    public List<Boxer> listAllBoxers(){
        return repository.findAll();
    }

    @RequestMapping(value = "boxers", method = RequestMethod.POST)
    public Boxer addBoxer (@RequestBody Boxer boxer) {
        return repository.saveAndFlush(boxer);
    }

    @RequestMapping(value = "boxers/{id}", method = RequestMethod.GET)
    public Boxer getBoxer(@PathVariable Long id){
        return repository.findOne(id);
    }

    @RequestMapping(value = "boxers/{id}", method = RequestMethod.DELETE)
    public Boxer deleteBoxer(@PathVariable Long id) {
        Boxer existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }


}
