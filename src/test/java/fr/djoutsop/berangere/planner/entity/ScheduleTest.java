package fr.djoutsop.berangere.planner.entity;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class ScheduleTest {

	Schedule subject;
	
	Prestation epilation;
	Prestation vernis;
	Contact contact;
	Adresse adresse;
	
	@Before
	public void setup() {
		epilation = new Prestation("Epilation", "epilation du maillot", 60L);
		vernis = new Prestation("Vernis", "vernis permanant", 30L);
		contact = new Contact("Aurelie", 35L);
		adresse = new Adresse("12 rue de la tourelle 91360 Villemoisson sur orge", contact);
	}
	
	@Test
	public void newSubject_ShouldSetEnd() {
		// Given
		ZonedDateTime now = ZonedDateTime.now();

		// When
		subject = new Schedule(now, epilation, adresse);
		
		// Then
		assertThat(subject.getEnd(), is(now.plus(epilation.getDuration(), ChronoUnit.MINUTES)));
	}
	
	@Test
	public void newSubject_ShouldSetContact() {
		// Given
		ZonedDateTime now = ZonedDateTime.now();

		// When
		subject = new Schedule(now, epilation, adresse);
		
		// Then
		assertThat(subject.getContact(), is(adresse.getContact()));
	}
	
	
}
