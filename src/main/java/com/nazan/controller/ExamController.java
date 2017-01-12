package com.nazan.controller;

import com.nazan.model.Exam;
import com.nazan.repository.ExamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nazan on 12.01.2017.
 */

@RestController
@RequestMapping("/exams")
public class ExamController {

    private final Logger log = LoggerFactory.getLogger(ExamController.class);

    @Autowired
    private ExamRepository examRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Exam> findExams(){
        log.info("REST request to find all exams");
        return examRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Exam addExam(@RequestBody Exam exam){
        log.info("REST request to add an exam");
        exam.setId(null);
        return examRepository.saveAndFlush(exam);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Exam updateExam(@RequestBody Exam exam, @PathVariable Long id){
        log.info("REST request to update an exam");
        exam.setId(id);
        return examRepository.saveAndFlush(exam);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteExam(@PathVariable Long id){
        log.info("REST request to delete an exam");
        examRepository.delete(id);
    }
}
