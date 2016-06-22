package fr.djoutsop.berangere.planner.entity;

import java.time.ZonedDateTime;

public class Slot {
	public final TypeSlot type;
	public final ZonedDateTime start;
	public final ZonedDateTime end;

	public Slot(TypeSlot type, ZonedDateTime start, ZonedDateTime end) {
		super();
		this.type = type;
		this.start = start;
		this.end = end;
	}

}
