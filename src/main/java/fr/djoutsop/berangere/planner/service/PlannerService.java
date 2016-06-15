package fr.djoutsop.berangere.planner.service;

import java.time.ZonedDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.djoutsop.berangere.planner.entity.Prestation;

@Service
@Transactional
public class PlannerService {

	public List<ZonedDateTime> findAvailableTimeSlot(Prestation prestation, ZonedDateTime start, ZonedDateTime end) {
		// TODO Auto-generated method stub
		return null;
	}

}
