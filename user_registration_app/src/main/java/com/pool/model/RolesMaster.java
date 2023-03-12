package com.pool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "ROLES_MASTER")
@Cache(region="rolesMaster",usage=CacheConcurrencyStrategy.READ_ONLY)
public class RolesMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer masterRoleId;
	private String roleName;

	public RolesMaster() {

	}

	public Integer getMasterRoleId() {
		return masterRoleId;
	}

	public void setMasterRoleId(Integer masterRoleId) {
		this.masterRoleId = masterRoleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "RolesMaster [masterRoleId=" + masterRoleId + ", roleName=" + roleName + "]";
	}

}
