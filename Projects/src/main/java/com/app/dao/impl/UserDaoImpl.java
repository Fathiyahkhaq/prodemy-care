package com.app.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.UserDao;
import com.app.model.User;

@Repository
public class UserDaoImpl implements UserDao{
private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public User findByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, name);
		return user;
	}

	@Override
	public User update(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		return user;
	}
}
