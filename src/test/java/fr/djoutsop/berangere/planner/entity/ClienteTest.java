package fr.djoutsop.berangere.planner.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

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
public class ClienteTest {

	@PersistenceContext
	private EntityManager entityManager;

	Cliente subject;

	Prestation epilation;
	Prestation vernis;
	Adresse adresse;

	@Before
	public void setup() {
		epilation = new Prestation("Epilation sourcil", 15, 900);
		entityManager.persist(epilation);

		vernis = new Prestation("Vernis", 30, 990);
		entityManager.persist(vernis);

		adresse = new Adresse("12", "rue de la tourelle", "91360", "Villemoisson sur orge");
		entityManager.persist(adresse);

	}

	@Test(expected = PersistenceException.class)
	public void persist_ShouldFailWithoutDatas() {
		// Given
		subject = new Cliente();

		// When
		entityManager.persist(subject);
		entityManager.flush();

		// Then
	}

	@Test
	public void persist_ShouldPersistNomPrenom() {
		// Given
		subject = new Cliente("Djoutsop", "Aurélien");

		// When
		entityManager.persist(subject);
		entityManager.flush();

		Cliente result = entityManager.find(Cliente.class, subject.getId());

		// Then
		assertThat(result, is(not(nullValue())));
		assertThat(result.getNom(), is("Djoutsop"));
		assertThat(result.getPrenom(), is("Aurélien"));
	}
	
	@Test
	public void persist_ShouldPersistAdresse() {
		// Given
		subject = new Cliente("Djoutsop", "Aurélien");
		subject.setAdresse(adresse);

		// When
		entityManager.persist(subject);
		entityManager.flush();

		Cliente result = entityManager.find(Cliente.class, subject.getId());

		// Then
		assertThat(result, is(not(nullValue())));
		assertThat(result.getNom(), is("Djoutsop"));
		assertThat(result.getPrenom(), is("Aurélien"));
		assertThat(result.getAdresse(), is(adresse));
	}
	
	@Test
	public void persist_ShouldPersistDateNaissance() {
		// Given
		LocalDate dateNaissanceLD = LocalDate.of(1980, Month.OCTOBER, 5);
		Date dateNaissance = Date.from(dateNaissanceLD.atStartOfDay().atZone(ZoneOffset.systemDefault()).toInstant());
		
		subject = new Cliente("Djoutsop", "Aurélien");
		subject.setDateNaissance(dateNaissance);

		// When
		entityManager.persist(subject);
		entityManager.flush();

		Cliente result = entityManager.find(Cliente.class, subject.getId());

		// Then
		assertThat(result, is(not(nullValue())));
		assertThat(result.getNom(), is("Djoutsop"));
		assertThat(result.getPrenom(), is("Aurélien"));
		assertThat(result.getDateNaissance(), is(dateNaissance));
	}
	
	@Test
	public void persist_ShouldPersistEmail() {
		// Given
		subject = new Cliente("Djoutsop", "Aurélien");
		subject.setEmail("a.djoutsop@gmail.com");

		// When
		entityManager.persist(subject);
		entityManager.flush();

		Cliente result = entityManager.find(Cliente.class, subject.getId());

		// Then
		assertThat(result, is(not(nullValue())));
		assertThat(result.getNom(), is("Djoutsop"));
		assertThat(result.getPrenom(), is("Aurélien"));
		assertThat(result.getEmail(), is("a.djoutsop@gmail.com"));
	}
	
	@Test
	public void persist_ShouldPersistTelephone() {
		// Given
		subject = new Cliente("Djoutsop", "Aurélien");
		subject.setTelephone("6666666666");;

		// When
		entityManager.persist(subject);
		entityManager.flush();

		Cliente result = entityManager.find(Cliente.class, subject.getId());

		// Then
		assertThat(result, is(not(nullValue())));
		assertThat(result.getNom(), is("Djoutsop"));
		assertThat(result.getPrenom(), is("Aurélien"));
		assertThat(result.getTelephone(), is("6666666666"));
	}

}
