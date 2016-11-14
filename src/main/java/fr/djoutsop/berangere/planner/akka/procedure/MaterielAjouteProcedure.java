package fr.djoutsop.berangere.planner.akka.procedure;

import fr.djoutsop.berangere.planner.akka.actor.manageress.ManageressData;
import fr.djoutsop.berangere.planner.akka.message.GrammarMateriel.MaterielAjoute;

public class MaterielAjouteProcedure extends AbstractProcedure<MaterielAjoute> {

	public MaterielAjouteProcedure(ManageressData state) {
		super(state);
	}


	@Override
	public void apply(MaterielAjoute materielAjoute) throws Exception {
		// TODO Auto-generated method stub

	}
}
