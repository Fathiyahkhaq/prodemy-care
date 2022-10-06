package com.app.dao;

import java.util.List;

import com.app.model.Role;

public interface RoleDao {
	public List<Role> findUserRoles(String userName);
}
