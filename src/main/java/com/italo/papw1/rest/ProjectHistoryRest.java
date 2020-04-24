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

import com.italo.papw1.domain.ProjectHistory;
import com.italo.papw1.service.ProjectHistoryService;

@RestController
@RequestMapping("/project-history")
public class ProjectHistoryRest {
    @Autowired
    private ProjectHistoryService projectHistoryService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProjectHistory getProjectHistoryById(@PathVariable Long id) {
        return projectHistoryService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ProjectHistory> getProjectHistorys() {
        return projectHistoryService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProjectHistory save(@RequestBody @Valid ProjectHistory projectHistory) {
        return projectHistoryService.save(projectHistory);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ProjectHistory update(@RequestBody @Valid ProjectHistory projectHistory) {
        return projectHistoryService.save(projectHistory);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable Long id) {
        projectHistoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
