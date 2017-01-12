package com.nazan.controller;

import com.nazan.model.Choice;
import com.nazan.model.Question;
import com.nazan.repository.ChoiceRepository;
import com.nazan.repository.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nazan on 12.01.2017.
 */

@RestController
@RequestMapping("/choices")
public class ChoiceController {
    private final Logger log = LoggerFactory.getLogger(ChoiceController.class);

    @Autowired
    private ChoiceRepository choiceRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Choice> findChoices(){
        log.info("REST request to find all choices");
        return choiceRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Choice addChoice(@RequestBody Choice choice){
        log.info("REST request to add an choice");
        choice.setId(null);
        return choiceRepository.saveAndFlush(choice);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Choice updateChoice(@RequestBody Choice choice, @PathVariable Long id){
        log.info("REST request to update an choice");
        choice.setId(id);
        return choiceRepository.saveAndFlush(choice);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteChoice(@PathVariable Long id){
        log.info("REST request to delete an choice");
        choiceRepository.delete(id);
    }
}
