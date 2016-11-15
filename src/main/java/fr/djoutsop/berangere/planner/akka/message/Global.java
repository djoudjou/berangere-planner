package fr.djoutsop.berangere.planner.akka.message;

public class Global {
	
	public static class Snapshot implements Command {
		private static final long serialVersionUID = 1L;
	}
	
	public static class Shutdown implements Command {
		private static final long serialVersionUID = 1L;
	}
}
