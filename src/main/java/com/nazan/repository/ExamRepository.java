package com.nazan.repository;

import com.nazan.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nazan on 12.01.2017.
 */
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
