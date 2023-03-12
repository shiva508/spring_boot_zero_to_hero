package com.pool.model.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
//Using a Shared Primary Key
public class ParentSPK {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	private String parentName;
	@OneToOne(mappedBy="parentSPK",cascade=CascadeType.ALL)
	private ChildSPK childSPK;
	
	public ParentSPK() {
		
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
	public ChildSPK getChildSPK() {
		return childSPK;
	}
	public void setChildSPK(ChildSPK childSPK) {
		this.childSPK = childSPK;
	}
	
	
}
