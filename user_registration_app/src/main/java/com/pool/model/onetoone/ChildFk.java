package com.pool.model.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class ChildFk {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String childName;
	@OneToOne(mappedBy="childFk")
	private ParentFk parentFk;
	public ChildFk() {
	
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getChildName() {
		return childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	
}
