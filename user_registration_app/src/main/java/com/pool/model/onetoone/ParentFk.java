package com.pool.model.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class ParentFk {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String parentName;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="child_id",referencedColumnName="id")
	private ChildFk childFk;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public ChildFk getChildFk() {
		return childFk;
	}
	public void setChildFk(ChildFk childFk) {
		this.childFk = childFk;
	}
	
}
