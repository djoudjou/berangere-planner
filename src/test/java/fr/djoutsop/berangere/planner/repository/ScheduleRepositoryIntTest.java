package fr.djoutsop.berangere.planner.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.time.ZonedDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fr.djoutsop.berangere.planner.BerangerePlannerConfiguration;
import fr.djoutsop.berangere.planner.entity.Adresse;
import fr.djoutsop.berangere.planner.entity.Contact;
import fr.djoutsop.berangere.planner.entity.Prestation;
import fr.djoutsop.berangere.planner.entity.Schedule;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BerangerePlannerConfiguration.class)
@WebAppConfiguration
@IntegrationTest
@Transactional
public class ScheduleRepositoryIntTest {
	@Inject
	private ScheduleRepository scheduleRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	Prestation epilation;
	Prestation vernis;
	Contact contact;
	Adresse adresse;
	
	@Before
	public void setup() {
		epilation = new Prestation("Epilation", "epilation du maillot", 60L);
		vernis = new Prestation("Vernis", "vernis permanant", 30L);
		
		entityManager.persist(epilation);
		entityManager.persist(vernis);
		
		contact = new Contact("Aurelie", 35L);
		entityManager.persist(contact);
		
		adresse = new Adresse("12 rue de la tourelle 91360 Villemoisson sur orge", contact);
		entityManager.persist(adresse);
	}

	@Test
	public void saveValidSchedule_ShouldPersist() {
		// Given
		Schedule schedule = new Schedule(ZonedDateTime.now(),epilation,adresse);

		// When
		scheduleRepository.save(schedule);

		// Then
		List<Schedule> result = scheduleRepository.findAll();
		assertThat(result, containsInAnyOrder(schedule));
	}
}