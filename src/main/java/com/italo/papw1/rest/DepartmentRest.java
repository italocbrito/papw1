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

import com.italo.papw1.domain.Department;
import com.italo.papw1.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentRest {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Department> getDepartment() {
        return departmentService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Department save(@RequestBody @Valid Department department) {
        return departmentService.save(department);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Department update(@RequestBody @Valid Department department) {
        return departmentService.save(department);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable Long id) {
    	departmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
