package com.italo.papw1.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.italo.papw1.domain.Project;
import com.italo.papw1.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectRest {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Project getProjectById(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Project> getProjects() {
        return projectService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Project save(@RequestBody @Valid Project project) {
        return projectService.save(project);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Project update(@RequestBody @Valid Project project) {
        return projectService.save(project);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable Long id) {
        projectService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
