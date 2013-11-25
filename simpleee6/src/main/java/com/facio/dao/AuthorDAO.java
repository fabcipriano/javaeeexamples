package com.facio.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.facio.domain.Author;

@Stateless
public class AuthorDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Author findByName(String name) {
		TypedQuery<Author> q = entityManager.createQuery("SELECT a FROM Author a WHERE a.name = :name", 
				Author.class);
		
		q.setParameter("name", name);
		
		return q.getSingleResult();
	}
}
