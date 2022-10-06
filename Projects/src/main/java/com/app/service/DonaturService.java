package com.app.service;

import java.util.List;

import com.app.model.ListDonatur;


public interface DonaturService {
	public ListDonatur findById(long id) throws Exception;
	public void deleteById(long id) throws Exception;
	public void insert(ListDonatur donatur) throws Exception;
	public void update(ListDonatur donatur) throws Exception;
	public List<ListDonatur> findAll() throws Exception;

}
