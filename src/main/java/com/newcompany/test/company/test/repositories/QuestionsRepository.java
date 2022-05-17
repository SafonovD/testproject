package com.newcompany.test.company.test.repositories;

import com.newcompany.test.company.test.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long> {

//    Questions save(Questions questions);

    Optional<Integer> findById(String name);

    Questions findByName(String name);
}
