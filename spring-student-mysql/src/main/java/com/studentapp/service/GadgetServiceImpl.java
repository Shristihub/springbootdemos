package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentapp.dao.GadgetRepository;
import com.studentapp.exceptions.GadgetsNotFoundException;
import com.studentapp.exceptions.IdNotFoundException;
import com.studentapp.model.Gadgets;

@Service
@Transactional
public class GadgetServiceImpl implements GadgetService{

	@Autowired
	GadgetRepository gadgetRepo;
	
	@Override
	public Gadgets findById(Integer gadgetId) {
		
		return gadgetRepo.findById(gadgetId)
		.orElseThrow(()-> new IdNotFoundException("Id not found "));
		
	}
	@Override
	public List<Gadgets> getGadgetsByStudentId(Integer studentId) {
		List<Gadgets> gadgetsList = gadgetRepo.findByStudentStudentId(studentId);
		if (gadgetsList.isEmpty())
			throw new GadgetsNotFoundException("gadgets for student not available");
		return gadgetsList;
	}
	
	@Override
	public Gadgets getOneGadgetByStudentId(int gadgetId, int studentId) {
		Gadgets gadget = gadgetRepo.findbyStudentGadgetId(gadgetId,studentId);
		if(gadget==null)
				throw new GadgetsNotFoundException("gadget with studentid and gadgetid not available");
		return gadget;
	}

	
}
