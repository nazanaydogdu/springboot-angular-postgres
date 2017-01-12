package com.nazan.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by nazan on 12.01.2017.
 */

@Entity
public class UserAnswer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "examid", nullable = false)
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "questionid", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "choiceid", nullable = false)
    private Choice choice;
}
