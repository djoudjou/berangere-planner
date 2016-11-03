package fr.djoutsop.berangere.planner.entity;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
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
public class RendezVousTest {

	@PersistenceContext
	private EntityManager entityManager;

	RendezVous subject;

	Prestation epilation;
	Prestation vernis;
	Cliente cliente;
	Adresse adresse;

	@Before
	public void setup() {
		epilation = new Prestation("Epilation sourcil", 15, 900);
		entityManager.persist(epilation);

		vernis = new Prestation("Vernis", 30, 990);
		entityManager.persist(vernis);

		cliente = new Cliente("Aurelie", "Dupuy");
		entityManager.persist(cliente);

		adresse = new Adresse("12", "rue de la tourelle", "91360", "Villemoisson sur orge");
		entityManager.persist(adresse);

	}

	@Test(expected = PersistenceException.class)
	public void persist_ShouldFailWithoutDate() {
		// Given
		subject = new RendezVous();

		// When
		entityManager.persist(subject);
		entityManager.flush();

		// Then
	}

	@Test
	public void persist_ShouldPersistDatas() {
		// Given
		ZonedDateTime now = ZonedDateTime.now();
		Date date = Date.from(now.toInstant());
		Date fin = Date.from(now.plusMinutes(10).toInstant());

		subject = new RendezVous();
		subject.setDate(date);
		subject.setAdresse(adresse);
		subject.setCliente(cliente);
		subject.setDuree(15);
		subject.setMontant(30);
		subject.setFin(fin);
		subject.setPrestation(epilation);
		subject.setNote("Note sur le rendez vous");

		// When
		entityManager.persist(subject);
		entityManager.flush();

		RendezVous result = entityManager.find(RendezVous.class, date);

		// Then
		assertThat(result, is(not(nullValue())));
		assertThat(result.getAdresse(), is(adresse));
		assertThat(result.getCliente(), is(cliente));
		assertThat(result.getMontant(), is(30l));
		assertThat(result.getDuree(), is(15l));
		assertThat(result.getFin(), is(fin));
		assertThat(result.getDate(), is(date));
		assertThat(result.getPrestation(), is(epilation));
		assertThat(result.getNote(), is("Note sur le rendez vous"));
	}
	
	
	@Test(expected = EntityExistsException.class)
	public void date_ShouldBeUnique() {
		// Given
		ZonedDateTime now = ZonedDateTime.now();
		Date date = Date.from(now.toInstant());
		Date fin = Date.from(now.plusMinutes(10).toInstant());

		subject = new RendezVous();
		subject.setDate(date);
		subject.setAdresse(adresse);
		subject.setCliente(cliente);
		subject.setDuree(15);
		subject.setMontant(30);
		subject.setFin(fin);
		subject.setPrestation(epilation);
		subject.setNote("Note sur le rendez vous");
		entityManager.persist(subject);
		entityManager.flush();

		// When
		RendezVous rendezVous = new RendezVous();
		rendezVous.setDate(date);
		rendezVous.setAdresse(new Adresse("14", "rue de la tourelle", "91360", "Villemoisson sur orge"));
		rendezVous.setCliente(cliente);
		rendezVous.setDuree(20);
		rendezVous.setMontant(30);
		rendezVous.setFin(fin);
		rendezVous.setPrestation(vernis);
		rendezVous.setNote("Note sur le rendez vous vernis");
		entityManager.persist(rendezVous);
		entityManager.flush();


		// Then
		
	}

}
