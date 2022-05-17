package com.newcompany.test.company.test.model;

import liquibase.pro.packaged.I;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "questions")
@NoArgsConstructor
@AllArgsConstructor
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "question_name")
    private String name;

    @OneToMany(mappedBy = "questions",cascade = CascadeType.ALL)
    private List<Answers> answersList;


}
