package com.app.service;

import java.util.List;

import com.app.model.Role;
import com.app.model.User;

public interface UserService {
	public User findByName(String name);
	public User update(User user);
	public List<Role> findUserRoles(String userName);
}
