package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.RoleDao;
import com.app.dao.UserDao;
import com.app.model.Role;
import com.app.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired UserDao userDao;
	@Autowired RoleDao roleDao;
	
	@Override
	public User findByName(String name) {
		return this.userDao.findByName(name);
	}

	@Override
	public User update(User user) {
		return this.userDao.update(user);
	}

	@Override
	public List<Role> findUserRoles(String userName) {
		return this.roleDao.findUserRoles(userName);
	}
}
