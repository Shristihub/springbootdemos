package com.studentapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Gadgets {

	private Integer gadgetId;
	private String gadgetName;
	private String gadgetModel;
	
	private Student student;

	public Gadgets(Integer gadgetId, String gadgetName, String gadgetModel) {
		super();
		this.gadgetId = gadgetId;
		this.gadgetName = gadgetName;
		this.gadgetModel = gadgetModel;
	}

	@Override
	public String toString() {
		return "Gadgets [gadgetName=" + gadgetName + ", gadgetModel=" + gadgetModel + "]";
	}

	

	
}

