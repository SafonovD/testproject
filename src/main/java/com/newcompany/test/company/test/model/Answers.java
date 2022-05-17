package com.newcompany.test.company.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@Entity
@Table(name = "answers")
@NoArgsConstructor
@AllArgsConstructor
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "answer_name")
    private String name;
    @Column(name = "correct_answer_of_question")
    private boolean correctAnswerOfQuestion;
    @Column(name = "questions_id")
    private Long questions_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questions_id",referencedColumnName = "id",insertable = false, updatable = false)
    private Questions questions;

}
