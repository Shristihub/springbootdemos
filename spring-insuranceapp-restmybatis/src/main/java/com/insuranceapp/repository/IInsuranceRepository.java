package com.insuranceapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.insuranceapp.exception.InsuranceNotFoundException;
import com.insuranceapp.model.Insurance;

@Mapper
public interface IInsuranceRepository {
	
	void addInsurance(Insurance insurance);
	void updateInsurance(int insuranceId, double premium);
	void deleteInsurance(int insuranceId);
	
	List<Insurance> getAll();
	List<Insurance> getByBrand(String brand)throws InsuranceNotFoundException;
	List<Insurance> getByBrandAndType(String brand, String type)throws InsuranceNotFoundException;
	List<Insurance> getByTypeAndLesserPremium(String type, double premium)throws InsuranceNotFoundException;
	Insurance getById(int insuranceId) throws InsuranceNotFoundException;
	

}
