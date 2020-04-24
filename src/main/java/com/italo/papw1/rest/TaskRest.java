package com.italo.papw1.rest;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.italo.papw1.domain.Task;
import com.italo.papw1.service.TaskService;
import com.italo.papw1.dto.TaskDTO;

@RestController
@RequestMapping("/task")
public class TaskRest {
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Task getTaskById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @GetMapping(value = {"/", "/search/{status}", "/search/{startDate}/{endDate}", "/search/{startDate}/{endDate}/{status}"})
    public List<TaskDTO> getTasks(@PathVariable(value = "startDate",required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                  @PathVariable(value = "endDate",required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                                  @PathVariable(value = "status",required = false) Long status) {

        if (startDate == null && endDate == null && status == null) {

            return taskService.findAll();

        } else if (startDate != null && endDate != null && status != null) {

            return taskService.findByStartDateGreaterThanEqualAndEndDateLessThanEqualAndStatusIs(startDate, endDate, status);

        } else if (startDate != null && endDate != null && status == null) {

            return taskService.findByStartDateGreaterThanEqualAndEndDateLessThanEqual(startDate, endDate);

        } else if (status != null && endDate == null && startDate == null){

            return taskService.findByStatus(status);

        } else {

            return taskService.findAll();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Task save(@RequestBody @Valid Task task) {
        return taskService.save(task);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Task update(@RequestBody @Valid Task task) {
        return taskService.save(task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable Long id) {
        taskService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
