package fr.djoutsop.berangere.planner.service;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.djoutsop.berangere.planner.repository.ScheduleRepository;

@Service
@Transactional
public class PlannerService {

//	@Inject
	ScheduleRepository scheduleRepository;

//	public List<Slot> findAvailableTimeSlot(Prestation prestation, Adresse adresse, ZonedDateTime start,
//			ZonedDateTime end) {
//
//		List<Schedule> schedules = scheduleRepository.findSchedulesBetween(start, end);
//
//		List<Slot> availablesSlot = new ArrayList<>();
//
//		ZonedDateTime date = start;
//		do {
//
//			Schedule schedule = findScheduleInList(date, schedules);
//
//			
//			if (schedule != null) {
//				Slot slot = new Slot(TypeSlot.PRESTATION, date, schedule.getEnd());
//
//			} else {
//
//				if (isPossible(date, prestation, adresse, start, end)) {
//				}
//
//			}
//			availablesSlot.add(new Slot(TypeSlot.PRESTATION, date, computeEndTime(date, prestation)));
//
//			date = date.plus(prestation.getDuration(), ChronoUnit.MINUTES);
//		} while (date.isAfter(end));
//
//		return null;
//	}
//
//	ZonedDateTime computeEndTime(ZonedDateTime date, Prestation prestation) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	boolean isPossible(ZonedDateTime date, Prestation prestation, Adresse adresse, ZonedDateTime start,
//			ZonedDateTime end) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	Schedule findScheduleInList(ZonedDateTime date, List<Schedule> schedules) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
