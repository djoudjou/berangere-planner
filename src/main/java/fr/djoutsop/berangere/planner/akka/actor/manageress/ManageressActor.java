package fr.djoutsop.berangere.planner.akka.actor.manageress;

import java.util.UUID;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.persistence.UntypedPersistentActor;
import fr.djoutsop.berangere.planner.akka.message.GrammarMateriel.*;
import fr.djoutsop.berangere.planner.akka.procedure.MaterielAjouteProcedure;

public class ManageressActor extends UntypedPersistentActor {

	private String id;
	private String nom;
	private String prenom;
	private String adresseEmail;
	private final ActorSystem system;

	private ManageressData state;

	public ManageressActor(ActorSystem system, String nom, String prenom, String adresseEmail) {
		super();
		this.id = UUID.randomUUID().toString();
		this.system = system;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseEmail = adresseEmail;
	}

	public static Props props(ActorSystem system, String nom, String prenom, String adresseEmail) {
		return Props.create(ManageressActor.class, () -> new ManageressActor(system, nom, prenom, adresseEmail));
	}

	@Override
	public String persistenceId() {
		return id;
	}

	@Override
	public void onReceiveCommand(Object command) throws Throwable {
		if (command instanceof AjouterNouveauMateriel) {
			AjouterNouveauMateriel ajouterNouveauMateriel = (AjouterNouveauMateriel) command;

			persist(new MaterielAjoute(ajouterNouveauMateriel.materiel), new MaterielAjouteProcedure(this.state));
		}
	}

	@Override
	public void onReceiveRecover(Object event) throws Throwable {
		// TODO Auto-generated method stub

	}

}
