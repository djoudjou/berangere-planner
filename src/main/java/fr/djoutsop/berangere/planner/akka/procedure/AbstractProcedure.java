package fr.djoutsop.berangere.planner.akka.procedure;

import akka.japi.Procedure;
import fr.djoutsop.berangere.planner.akka.actor.manageress.ManageressData;
import fr.djoutsop.berangere.planner.akka.message.Event;

public abstract class AbstractProcedure<E extends Event> implements Procedure<E> {
	private static final long serialVersionUID = 1L;

	final ManageressData state;

	public AbstractProcedure(ManageressData state) {
		this.state = state;
	}
}
