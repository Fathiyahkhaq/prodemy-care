package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.DonaturDao;
import com.app.model.ListDonatur;

@Service
@Transactional
public class DonaturServiceImpl implements DonaturService {

	@Autowired
	private DonaturDao dao;

	@Override
	public void insert(ListDonatur donatur) throws Exception {
		dao.insert(donatur);		
	}

	@Override
	public void update(ListDonatur donatur) throws Exception {
		dao.update(donatur);
	}

	@Override
	public List<ListDonatur> findAll() throws Exception {
		return dao.findAll();
	}

	@Override
	public ListDonatur findById(long id) throws Exception {
		return dao.findById(id);
	}

	@Override
	public void deleteById(long id) throws Exception {
		dao.deleteById(id);
	}
	

}
