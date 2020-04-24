package com.italo.papw1.dto;

import java.time.LocalDate;

public class TaskDTO {
    private Long id;

    private String title;
    private String description;
    private Long taskPoints;
    private Long status;
    private LocalDate startDate;
    private LocalDate endDate;

    public TaskDTO(Long id, LocalDate startDate, LocalDate endDate, Long status,String title,String description,Long taskPoints) {
        super();
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.title = title;
        this.description = description;
        this.taskPoints = taskPoints;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getTaskPoints() {
		return taskPoints;
	}

	public void setTaskPoints(Long taskPoints) {
		this.taskPoints = taskPoints;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
    
}
