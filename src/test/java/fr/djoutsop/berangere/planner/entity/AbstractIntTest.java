package fr.djoutsop.berangere.planner.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fr.djoutsop.berangere.planner.BerangerePlannerConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BerangerePlannerConfiguration.class)
@WebAppConfiguration
@IntegrationTest
@Transactional
public abstract class AbstractIntTest {

	@PersistenceContext
	public EntityManager entityManager;

	public void delete(Object entity) {
		entityManager.remove(entity);
		entityManager.flush();
	}
	
	public void delete(Object... entities) {
		for (Object entity : entities) {
			delete(entity);
		}
	}
	
	
	public void save(Object entity) {
		entityManager.persist(entity);
		entityManager.flush();
	}

	public void save(Object... entities) {
		for (Object entity : entities) {
			save(entity);
		}
	}
}
