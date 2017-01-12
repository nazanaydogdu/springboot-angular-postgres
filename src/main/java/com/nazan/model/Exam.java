package com.nazan.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nazan on 12.01.2017.
 */

@Entity
public class Exam implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private double passscore;

    @Column
    private double totalscore;

    @Column
    private Integer duration;

    @OneToMany(mappedBy = "exam")
    private Set<Question> questions = new HashSet<Question>();

    @OneToMany(mappedBy = "exam")
    private Set<UserAnswer> userAnswers = new HashSet<UserAnswer>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPassscore() {
        return passscore;
    }

    public void setPassscore(double passscore) {
        this.passscore = passscore;
    }

    public double getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(double totalscore) {
        this.totalscore = totalscore;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
