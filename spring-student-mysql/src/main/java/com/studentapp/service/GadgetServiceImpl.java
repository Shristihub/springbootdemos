package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.dao.GadgetRepository;
import com.studentapp.model.Gadgets;

@Service
public class GadgetServiceImpl implements GadgetService{

	@Autowired
	GadgetRepository gadgetRepo;

	@Override
	public List<Gadgets> findByStudentName(String studName) {
		return gadgetRepo.findByStudentName(studName);
	}
		

}
