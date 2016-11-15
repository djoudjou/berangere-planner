package fr.djoutsop.berangere.planner.exception;

public class FunctionalException extends Exception {
	private static final long serialVersionUID = -512152734446118578L;

	public FunctionalException(String message) {
		super(message);
	}

	public FunctionalException(String message, Exception ex) {
		super(message, ex);
	}

}
