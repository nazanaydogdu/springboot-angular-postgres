package com.nazan.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nazan on 12.01.2017.
 */

@Entity
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String problemdesc;

    @Column
    private boolean ismultichoice;

    @Column
    private Integer orderno;

    @OneToMany(mappedBy = "question")
    private Set<Choice> choices = new HashSet<Choice>();

    @ManyToOne
    @JoinColumn(name = "examid", nullable = false)
    private Exam exam;

    @OneToMany(mappedBy = "question")
    private Set<UserAnswer> userAnswers = new HashSet<UserAnswer>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProblemdesc() {
        return problemdesc;
    }

    public void setProblemdesc(String problemdesc) {
        this.problemdesc = problemdesc;
    }

    public boolean ismultichoice() {
        return ismultichoice;
    }

    public void setIsmultichoice(boolean ismultichoice) {
        this.ismultichoice = ismultichoice;
    }

    public Set<Choice> getChoices() {
        return choices;
    }

    public void setChoices(Set<Choice> choices) {
        this.choices = choices;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }
}
