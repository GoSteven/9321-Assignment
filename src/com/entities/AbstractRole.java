package com.entities;

/**
 * AbstractRole entity provides the base persistence definition of the Role
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractRole implements java.io.Serializable {

	// Fields

	private String roleId;
	private String roleName;

	// Constructors

	/** default constructor */
	public AbstractRole() {
	}

	/** full constructor */
	public AbstractRole(String roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	// Property accessors

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}