package com.facio.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.facio.business.LibraryManager;
import com.facio.domain.Author;

public class AuthorDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(AuthorDAOTest.class);

	@Test
	public void testFindByName() {
		
		logger.info("begin testFindByName");
		
		EntityManagerFactory factory = null;
		EntityManager em  = null;
		try {
			factory = Persistence.createEntityManagerFactory("library");
			
			em = factory.createEntityManager();
			AuthorDAO adao = new AuthorDAO();
			
			adao.setEntityManager(em);
			
			Author a = adao.findByName("Isaac Asimov");
			
			assertNotNull("Isaac Asimo is in database", a);
			
			assertEquals("Wrong Author returned", "Isaac Asimov", a.getName());
		}
		finally {
		
			if ( em != null) {
				em.close();
			}
			
			if (factory != null) {
				factory.close();
			}
			
			logger.info("end testFindByName");
		}
	}

}
