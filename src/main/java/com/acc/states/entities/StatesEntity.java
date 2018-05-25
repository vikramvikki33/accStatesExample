package com.acc.states.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STATES_TB")
public class StatesEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="STATE_CODE", length=2, unique=true)
	private String code;
	
	@Column(name="STATE_NAME", length=30)
	private String name;
	
	@OneToMany(mappedBy="states", cascade=CascadeType.ALL)
	private Set<Cities> cities = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Cities> getCities() {
		return cities;
	}

	public void setCities(Set<Cities> cities) {
		this.cities = cities;
	}
	
	

	@Override
	public String toString() {
		return "StatesEntity [id=" + id + ", code=" + code + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatesEntity other = (StatesEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
