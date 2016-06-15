package fr.djoutsop.berangere.planner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.djoutsop.berangere.planner.entity.Schedule;

/**
 * Spring Data JPA repository for the User source.
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

	Optional<Schedule> findOneById(Long scheduleId);
	
}
