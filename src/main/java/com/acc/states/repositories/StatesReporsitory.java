package com.acc.states.repositories;

import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.acc.states.entities.StatesEntity;

@Repository
public class StatesReporsitory {
	
	private static final Logger log = Logger.getLogger(StatesReporsitory.class.getName());
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void addStates(StatesEntity states) {
		log.info(states);
		this.sessionFactory.openSession().save(states);
		/*Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		states.stream().forEach(e -> session.save(e));
		session.getTransaction().commit();
		session.close();*/
	}
	
	@Transactional
	public StatesEntity findStateByCode(String code) {
		TypedQuery<StatesEntity> query = this.sessionFactory.openSession().createQuery("from StatesEntity s WHERE s.code=" + code);
		return query.getSingleResult();
	}
	
	@Transactional
	public List<StatesEntity> findAllStates() {
		TypedQuery<StatesEntity> query = this.sessionFactory.openSession().createQuery("from StatesEntity s");
		return query.getResultList();
		
	}
}
