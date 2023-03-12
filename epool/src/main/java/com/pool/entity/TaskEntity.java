package com.pool.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_TASK")
public class TaskEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TASK_ID")
	private Long taskId;
	
	@Column(name = "TASK_TITLE")
	private String taskTitle;
	
	@Column(name = "TASK_DESC")
	private String taskDescription;
	
	@Column(name = "TASK_START")
	private Date startDate;
	
	@Column(name = "TASK_END")
	private Date endDate;
	
	@Column(name = "USER_ID")
	private Long userId;

}
