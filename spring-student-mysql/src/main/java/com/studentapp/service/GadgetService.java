package com.studentapp.service;

import java.util.List;

import com.studentapp.model.Gadgets;

public interface GadgetService {

	
	List<Gadgets> findByStudentName(String studName);
}
