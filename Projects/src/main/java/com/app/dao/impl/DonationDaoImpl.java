package com.app.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.DonationDao;
import com.app.model.Donation;


@Repository
public class DonationDaoImpl implements DonationDao {

private static final Logger logger = LoggerFactory.getLogger(DonationDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public Donation findById(long id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		Donation donation = (Donation) session.get(Donation.class, id);
		return donation;
	}

	@Override
	public void deleteById(long id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		Donation donation = (Donation) session.load(Donation.class, id);
		session.delete(donation);
		
	}

	@Override
	public void insert(Donation donation) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(donation);
		logger.debug("Donation saved -> {0}", donation);
		
	}

	@Override
	public void update(Donation donation) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(donation);
		logger.debug("Donation updated -> {0}", donation);
		
	}

	@Override
	public List<Donation> findAll() throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		List<Donation> result = session.createQuery("from Donation").list();
		return result;
	}

}
