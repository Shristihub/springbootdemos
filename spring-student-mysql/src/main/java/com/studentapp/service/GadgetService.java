package com.studentapp.service;

import java.util.List;

import com.studentapp.exceptions.GadgetsNotFoundException;
import com.studentapp.model.Gadgets;

public interface GadgetService {

	Gadgets findById(Integer gadgetId) throws GadgetsNotFoundException;
	List<Gadgets> getGadgetsByStudentId(Integer studentId) throws GadgetsNotFoundException;
	Gadgets getOneGadgetByStudentId(int gadgetId,int studentId) throws GadgetsNotFoundException;
}
