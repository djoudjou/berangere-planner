package fr.djoutsop.berangere.planner.akka.message;

public class CrudMessages {

	public static class CreationSucces implements Message {
		private static final long serialVersionUID = 1L;
		public final String id;

		public CreationSucces(final String id) {
			this.id = id;
		}
	}

	public static class ModificationSucces implements Message {
		private static final long serialVersionUID = 1L;
	}

	public static class SuppressionSucces implements Message {
		private static final long serialVersionUID = 1L;
	}

	public static class Errors implements Message {
		private static final long serialVersionUID = 1L;
		public final String[] errorMessages;

		public Errors(String... errorMessages) {
			this.errorMessages = errorMessages;
		}
	}
}
