package com.italo.papw1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.italo.papw1.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
