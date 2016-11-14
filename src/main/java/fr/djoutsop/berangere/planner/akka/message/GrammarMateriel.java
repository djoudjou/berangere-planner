package fr.djoutsop.berangere.planner.akka.message;

import fr.djoutsop.berangere.planner.entity.Materiel;

public class GrammarMateriel {
	
	private GrammarMateriel() {
		
	}

	public static class AjouterNouveauMateriel implements Command {
		private static final long serialVersionUID = 1L;
		public final Materiel materiel;

		public AjouterNouveauMateriel(final Materiel materiel) {
			super();
			this.materiel = materiel;
		}
	}

	public static class ModifierDetailMateriel implements Command {
		private static final long serialVersionUID = 1L;
		public final Materiel materiel;

		public ModifierDetailMateriel(final Materiel materiel) {
			super();
			this.materiel = materiel;
		}
	}

	public static class SupprimerMateriel implements Command {
		private static final long serialVersionUID = 1L;
		public final String id;

		public SupprimerMateriel(final String id) {
			super();
			this.id = id;
		}
	}

	public static class ConsulterInventaire implements Command {
		private static final long serialVersionUID = 1L;

		public ConsulterInventaire() {
			super();
		}
	}

	public static class MaterielAjoute implements Event {
		private static final long serialVersionUID = 1L;
		public final Materiel materiel;

		public MaterielAjoute(final Materiel materiel) {
			super();
			this.materiel = materiel;
		}
	}

	public static class DetailMaterielModifie implements Event {
		private static final long serialVersionUID = 1L;
		public final Materiel materiel;

		public DetailMaterielModifie(final Materiel materiel) {
			super();
			this.materiel = materiel;
		}
	}

	public static class MaterielSupprime implements Event {
		private static final long serialVersionUID = 1L;
		public final String id;

		public MaterielSupprime(final String id) {
			super();
			this.id = id;
		}
	}
}
