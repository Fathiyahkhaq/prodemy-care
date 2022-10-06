package com.app.dao;

import com.app.model.User;

public interface UserDao {
	public User findByName(String name);
	public User update(User user);
}
