package com.italo.papw1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.italo.papw1.domain.ProjectHistory;

public interface ProjectHistoryRepository extends JpaRepository<ProjectHistory, Long> {

}
