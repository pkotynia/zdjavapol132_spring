package com.sda.demo.repository;

import com.sda.demo.model.InterviewQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewQuestionsRepository extends JpaRepository<InterviewQuestion, Long> {
}
