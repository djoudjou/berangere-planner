package fr.djoutsop.berangere.planner.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
public class PlannerServiceIntTest {

	@Inject
	private PlannerService plannerService;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	Prestation epilation;
	Prestation vernis;
	Contact contact;
	Adresse villemoisson;
	
	
	@Before
	public void setup() {
		epilation = new Prestation("Epilation", "epilation du maillot", 60L);
		vernis = new Prestation("Vernis", "vernis permanant", 30L);
		
		entityManager.persist(epilation);
		entityManager.persist(vernis);
		
		contact = new Contact("Aurelie", 35L);
		entityManager.persist(contact);
		
		villemoisson = new Adresse("12 rue de la tourelle 91360 Villemoisson sur orge", contact);
		entityManager.persist(villemoisson);
		
		entityManager.flush();
	}
	
	@Test
	public void findAvailableTimeSlot_ShouldReturnListOfAvailableTimeSlot() {
		// Given
		// |X___X____|
		
		ZonedDateTime now = ZonedDateTime.now();
		Schedule scheduleEpilation1 = new Schedule(now,epilation,villemoisson);
		Schedule scheduleEpilation2 = new Schedule(now.plusMinutes(3*epilation.getDuration()),epilation,villemoisson);
		entityManager.persist(scheduleEpilation1);
		entityManager.persist(scheduleEpilation2);
		
		// When
		List<ZonedDateTime> result = plannerService.findAvailableTimeSlot(epilation, now, now.plusWeeks(1));
		
		// Then
		ZonedDateTime creneau1 = now.plusMinutes(epilation.getDuration());
		ZonedDateTime creneau2 = creneau1.plusMinutes(30);
		ZonedDateTime creneau3 = creneau2.plusMinutes(30);
		
		assertThat(result, contains(creneau1, creneau2, creneau3));
	}
	
}
