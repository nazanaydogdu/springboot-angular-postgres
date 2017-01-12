package com.nazan.controller;

import com.nazan.model.Exam;
import com.nazan.model.Question;
import com.nazan.repository.ExamRepository;
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
@RequestMapping("/questions")
public class QuestionController {
    private final Logger log = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Question> findQuestions(){
        log.info("REST request to find all questions");
        return questionRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Question addQuestion(@RequestBody Question question){
        log.info("REST request to add an question");
        question.setId(null);
        return questionRepository.saveAndFlush(question);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Question updateQuestion(@RequestBody Question question, @PathVariable Long id){
        log.info("REST request to update an question");
        question.setId(id);
        return questionRepository.saveAndFlush(question);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteQuestion(@PathVariable Long id){
        log.info("REST request to delete an question");
        questionRepository.delete(id);
    }
}
