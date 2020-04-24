package com.italo.papw1.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italo.papw1.domain.Project;
import com.italo.papw1.repository.ProjectRepository;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project save(Project project){
        return projectRepository.save(project);
    }

    public Project findById(Long id){
        return projectRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }
}
