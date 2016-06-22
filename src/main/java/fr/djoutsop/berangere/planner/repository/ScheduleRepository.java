package fr.djoutsop.berangere.planner.repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.djoutsop.berangere.planner.entity.Schedule;

/**
 * Spring Data JPA repository for the User source.
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

	Optional<Schedule> findOneById(Long scheduleId);

	@Query("select s from Schedule s where (s.start >= :date1 and s.start <= :date2)"
			+ " or (s.end >= :date1 and s.end <= :date2) order by s.start")
	List<Schedule> findSchedulesBetween(ZonedDateTime date1, ZonedDateTime date2);

}
