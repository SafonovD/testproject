package com.newcompany.test.company.test.repositories;

import com.newcompany.test.company.test.model.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answers, Long> {

    Answers findByName(String name);


}
