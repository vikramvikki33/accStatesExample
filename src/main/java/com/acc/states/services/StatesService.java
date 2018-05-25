package com.acc.states.services;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.states.entities.Cities;
import com.acc.states.entities.StatesEntity;
import com.acc.states.repositories.StatesReporsitory;

@Service
public class StatesService {

	@Autowired 
	private StatesReporsitory reporsitory;
	
	public void AddStates() {
		prepareStates().stream().forEach(e -> this.reporsitory.addStates(e));
	}
	
	public List<StatesEntity> findAllStates() {
		return this.reporsitory.findAllStates();
	}
	
	private List<StatesEntity> prepareStates() {
		List<StatesEntity> entities = new LinkedList<>();
		StatesEntity entity = new StatesEntity();
		entity.setCode("KA");
		entity.setName("Karnataka");
		Set<Cities> cities = new HashSet<>();
		Cities city = new Cities();
		city.setCityName("Bangalore");
		city.setStates(entity);
		cities.add(city);
		
		city = new Cities();
		city.setCityName("Mangalore");
		city.setStates(entity);
		cities.add(city);
		
		city = new Cities();
		city.setCityName("Mysore");
		city.setStates(entity);
		cities.add(city);
		
		entity.setCities(cities);
		
		entities.add(entity);
		
		return entities;
	}
}
