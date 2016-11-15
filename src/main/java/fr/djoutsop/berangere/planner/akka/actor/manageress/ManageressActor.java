package fr.djoutsop.berangere.planner.akka.actor.manageress;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.persistence.UntypedPersistentActor;
import fr.djoutsop.berangere.planner.akka.message.Command;
import fr.djoutsop.berangere.planner.akka.message.CrudMessages.Errors;
import fr.djoutsop.berangere.planner.akka.message.Event;
import fr.djoutsop.berangere.planner.akka.message.GrammarMateriel.AjouterNouveauMateriel;
import fr.djoutsop.berangere.planner.akka.message.GrammarMateriel.DetailMaterielModifie;
import fr.djoutsop.berangere.planner.akka.message.GrammarMateriel.MaterielAjoute;
import fr.djoutsop.berangere.planner.akka.message.GrammarMateriel.ModifierDetailMateriel;
import fr.djoutsop.berangere.planner.exception.FunctionalException;

public class ManageressActor extends UntypedPersistentActor {

	Logger logger = LoggerFactory.getLogger(ManageressActor.class);

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

		this.state = new ManageressData();
	}

	public static Props props(ActorSystem system, String nom, String prenom, String adresseEmail) {
		return Props.create(ManageressActor.class, () -> new ManageressActor(system, nom, prenom, adresseEmail));
	}

	@Override
	public String persistenceId() {
		return id;
	}

	@Override
	public void onReceiveCommand(Object message) {
		if (message instanceof Command) {
			List<Event> events;
			try {
				events = handleCommand(message);
				persistAll(events, event -> applyEvent(event));
			} catch (FunctionalException e) {
				logger.error(e.getMessage(), e);
				getSender().tell(new Errors(e.getMessage()), this.getSelf());
			}
		}
	}

	@Override
	public void onReceiveRecover(Object event) {
		applyEvent(event);
	}

	public List<Event> handleCommand(Object command) throws FunctionalException {
		List<Event> events = new ArrayList<>();
		if (command instanceof AjouterNouveauMateriel) {
			AjouterNouveauMateriel ajouterNouveauMateriel = (AjouterNouveauMateriel) command;
			events.add(new MaterielAjoute(ajouterNouveauMateriel.materiel));
		} else if (command instanceof ModifierDetailMateriel) {
			ModifierDetailMateriel modifierDetailMateriel = (ModifierDetailMateriel) command;
			events.add(new DetailMaterielModifie(modifierDetailMateriel.materiel));
		}
		return events;
	}

	public void applyEvent(Object event) {
		if (event instanceof MaterielAjoute) {
			state.addMateriel(((MaterielAjoute) event).materiel);
		} else if (event instanceof DetailMaterielModifie) {
			state.updateMateriel(((DetailMaterielModifie) event).materiel);
		}
	}

}
