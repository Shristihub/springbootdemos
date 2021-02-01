package com.studentapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Audited
@AuditTable("address_audit")
public class Address {

	@Id
	private Integer addressId;
	private String city;
	private String state;
	
	
	
}
