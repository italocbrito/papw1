package com.italo.papw1.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectTitle;

    @OneToOne
    private Person manager;
    private Long minSalary;
    private Long maxSalary;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Project_Task",
            joinColumns =  @JoinColumn(name = "project_id") ,
            inverseJoinColumns = @JoinColumn(name = "task_id"))

    Set<Task> tasks= new HashSet<Task>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public Person getManager() {
		return manager;
	}

	public void setManager(Person manager) {
		this.manager = manager;
	}

	public Long getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Long minSalary) {
		this.minSalary = minSalary;
	}

	public Long getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Long maxSalary) {
		this.maxSalary = maxSalary;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
}
