package com.learning.quizapp.dao;

import com.learning.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    /* Not required since question table already have category column */
    //@Query(value = "select q.* from Question q where lower(q.category)= lower(:category)",nativeQuery = true)
    //List<Question> getQuestionsByCategory(@Param("category") String category);

    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM Question WHERE lower(category) = lower(:category) ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);
}
