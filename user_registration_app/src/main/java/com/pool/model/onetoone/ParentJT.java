package com.pool.model.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
// Using a Join Table
public class ParentJT {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String parentName;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "pjt_cjt", joinColumns = {
			@JoinColumn(referencedColumnName = "id", name = "pjt_id") }, inverseJoinColumns = {
			@JoinColumn(referencedColumnName = "id", name = "cjt_id") })
	private ChildJT childJT;

	public ParentJT() {

	}

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

	public ChildJT getChildJT() {
		return childJT;
	}

	public void setChildJT(ChildJT childJT) {
		this.childJT = childJT;
	}

}
