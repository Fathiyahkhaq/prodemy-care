package com.app.service;

import java.util.List;

import com.app.model.Donation;

public interface DonationService {
	public Donation findById(long id) throws Exception;
	public void deleteById(long id) throws Exception;
	public void insert(Donation donation) throws Exception;
	public void update(Donation donation) throws Exception;
	public List<Donation> findAll() throws Exception;
}
