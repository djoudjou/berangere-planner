package fr.djoutsop.berangere.planner.service;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.djoutsop.berangere.planner.entity.Adresse;
import fr.djoutsop.berangere.planner.entity.Prestation;
import fr.djoutsop.berangere.planner.entity.Schedule;
import fr.djoutsop.berangere.planner.entity.Slot;
import fr.djoutsop.berangere.planner.entity.TypeSlot;
import fr.djoutsop.berangere.planner.repository.ScheduleRepository;

@Service
@Transactional
public class PlannerService {

	@Inject
	ScheduleRepository scheduleRepository;

	public List<Slot> findAvailableTimeSlot(Prestation prestation, Adresse adresse, ZonedDateTime start,
			ZonedDateTime end) {

		List<Schedule> schedules = scheduleRepository.findSchedulesBetween(start, end);

		List<Slot> availablesSlot = new ArrayList<>();

		ZonedDateTime date = start;
		do {

			Schedule schedule = findScheduleInList(date, schedules);

			
			if (schedule != null) {
				Slot slot = new Slot(TypeSlot.PRESTATION, date, schedule.getEnd());

			} else {

				if (isPossible(date, prestation, adresse, start, end)) {
				}

			}
			availablesSlot.add(new Slot(TypeSlot.PRESTATION, date, computeEndTime(date, prestation)));

			date = date.plus(prestation.getDuration(), ChronoUnit.MINUTES);
		} while (date.isAfter(end));

		return null;
	}

	ZonedDateTime computeEndTime(ZonedDateTime date, Prestation prestation) {
		// TODO Auto-generated method stub
		return null;
	}

	boolean isPossible(ZonedDateTime date, Prestation prestation, Adresse adresse, ZonedDateTime start,
			ZonedDateTime end) {
		// TODO Auto-generated method stub
		return false;
	}

	Schedule findScheduleInList(ZonedDateTime date, List<Schedule> schedules) {
		// TODO Auto-generated method stub
		return null;
	}

}
