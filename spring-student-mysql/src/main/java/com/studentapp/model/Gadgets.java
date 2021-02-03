package com.studentapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Gadgets extends RepresentationModel<Courses>{

	@Id 
	private Integer gadgetId;
	private String gadgetName;
	private String gadgetModel;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="student_id")
	@JsonIgnore
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

