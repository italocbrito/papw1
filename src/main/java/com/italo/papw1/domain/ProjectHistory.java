package com.italo.papw1.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
public class ProjectHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startDate;
    private Date endDate;

    @OneToOne
    private Person manager;

    @OneToOne
    private Project project;

    @OneToOne
    
    private Department departmentName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Person getManager() {
		return manager;
	}

	public void setManager(Person manager) {
		this.manager = manager;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Department getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(Department departmentName) {
		this.departmentName = departmentName;
	}
    
}
