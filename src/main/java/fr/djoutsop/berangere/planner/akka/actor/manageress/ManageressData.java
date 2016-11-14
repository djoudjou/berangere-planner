package fr.djoutsop.berangere.planner.akka.actor.manageress;

import java.util.List;

import fr.djoutsop.berangere.planner.entity.Materiel;

public class ManageressData {
	private List<Materiel> inventaire;

	public List<Materiel> getInventaire() {
		return inventaire;
	}

	public void setInventaire(List<Materiel> inventaire) {
		this.inventaire = inventaire;
	}
	
	
}
