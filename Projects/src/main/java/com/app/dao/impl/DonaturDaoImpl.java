package com.app.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.DonaturDao;
import com.app.model.ListDonatur;

@Repository
public class DonaturDaoImpl implements DonaturDao {
	private static final Logger logger = LoggerFactory.getLogger(DonaturDaoImpl.class);

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public ListDonatur findById(long id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		ListDonatur donatur = (ListDonatur) session.get(ListDonatur.class, id);
		return donatur;
	}

	@Override
	public void deleteById(long id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		ListDonatur donatur = (ListDonatur) session.load(ListDonatur.class, id);
		session.delete(donatur);
	}

	@Override
	public void insert(ListDonatur donatur) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(donatur);
		logger.debug("Donatur saved -> {0}", donatur);
	}

	@Override
	public void update(ListDonatur donatur) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(donatur);
		logger.debug("Donatur updated -> {0}", donatur);
	}

	@Override
	public List<ListDonatur> findAll() throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		List<ListDonatur> result = session.createQuery("from ListDonatur").list();
		return result;
	}
}
