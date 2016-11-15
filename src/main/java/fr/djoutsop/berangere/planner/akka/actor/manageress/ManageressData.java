package fr.djoutsop.berangere.planner.akka.actor.manageress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import fr.djoutsop.berangere.planner.akka.message.Event;
import fr.djoutsop.berangere.planner.akka.message.GrammarMateriel.AjouterNouveauMateriel;
import fr.djoutsop.berangere.planner.akka.message.GrammarMateriel.DetailMaterielModifie;
import fr.djoutsop.berangere.planner.akka.message.GrammarMateriel.MaterielAjoute;
import fr.djoutsop.berangere.planner.akka.message.GrammarMateriel.ModifierDetailMateriel;
import fr.djoutsop.berangere.planner.entity.Materiel;
import fr.djoutsop.berangere.planner.exception.FunctionalException;

public class ManageressData {

	private Map<String, Materiel> inventaire = new HashMap<String, Materiel>();

	public List<Materiel> getInventaire() {
		return new ArrayList<>(inventaire.values());
	}

	public Materiel addMateriel(Materiel materiel) {
		materiel.setId(UUID.randomUUID().toString());
		this.inventaire.put(materiel.getId(), materiel);
		return materiel;
	}

	public Materiel updateMateriel(Materiel materiel) {
		this.inventaire.put(materiel.getId(), materiel);
		return materiel;
	}

	public void deleteMateriel(String id) {
		this.inventaire.remove(id);
	}

}
