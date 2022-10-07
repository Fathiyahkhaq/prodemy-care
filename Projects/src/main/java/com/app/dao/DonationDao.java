package com.app.dao;

import java.util.List;

import com.app.model.Donation;

public interface DonationDao {
	public Donation findById(long id) throws Exception;
	public void deleteById(long id) throws Exception;
	public void insert(Donation donation) throws Exception;
	public void update(Donation donation) throws Exception;
	public List<Donation> findAll() throws Exception;

}
