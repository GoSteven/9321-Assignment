package com.entities;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
public class Role extends AbstractRole implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(String roleId, String roleName) {
		super(roleId, roleName);
	}

}
