package fr.djoutsop.berangere.planner.entity;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class SimplyBeautyIntTest extends AbstractIntTest {

	@Test
	public void sample_data() {
		Objectifs objectifs = new Objectifs();
		objectifs.setCaQuotiden(100.d);
		objectifs.setCaHebdomadaire(600.d);
		objectifs.setCaMensuel(2400.d);
		save(objectifs);

		Gerante berangere = new Gerante();
		berangere.setNom("Guilley");
		berangere.setPrenom("Berangere");
		berangere.setObjectifs(objectifs);
		save(berangere);

		Materiel cire = new Materiel();
		cire.setGerante(berangere);
		cire.setNom("Cire");
		cire.setQuantite(200);
		Materiel bandes = new Materiel();
		bandes.setGerante(berangere);
		bandes.setNom("Bande");
		bandes.setQuantite(100);

		Materiel fauxCils = new Materiel();
		fauxCils.setGerante(berangere);
		fauxCils.setNom("faux Cils");
		fauxCils.setQuantite(300);
		save(cire, bandes, fauxCils);

		Prestation epilation = new Prestation();
		epilation.setDuree(10);
		epilation.setMontant(30.d);
		epilation.setNom("Epilation");
		epilation.setGerante(berangere);

		Prestation extensionsCil = new Prestation();
		extensionsCil.setDuree(30);
		extensionsCil.setMontant(10.d);
		extensionsCil.setNom("Extensions cil");
		extensionsCil.setGerante(berangere);

		Prestation tatouageSourcil = new Prestation();
		tatouageSourcil.setDuree(60);
		tatouageSourcil.setMontant(200.d);
		tatouageSourcil.setNom("tatouage sourcil");
		tatouageSourcil.setGerante(berangere);
		save(epilation, extensionsCil, tatouageSourcil);

		PrestationMateriel epilationMaterielCire = new PrestationMateriel();
		epilationMaterielCire.setMateriel(cire);
		epilationMaterielCire.setPrestation(epilation);
		save(epilationMaterielCire);

		PrestationMateriel epilationMaterielBandes = new PrestationMateriel();
		epilationMaterielBandes.setMateriel(bandes);
		epilationMaterielBandes.setPrestation(epilation);
		save(epilationMaterielBandes);

		PrestationMateriel extensionsMaterielFauxCil = new PrestationMateriel();
		extensionsMaterielFauxCil.setMateriel(fauxCils);
		extensionsMaterielFauxCil.setPrestation(extensionsCil);
		save(extensionsMaterielFauxCil);

		PrestationRdv prestationRdv1 = new PrestationRdv();
		prestationRdv1.setPrestation(epilation);
		prestationRdv1.setDuree(epilation.getDuree()+10);
		prestationRdv1.setMontant(epilation.getMontant());

		PrestationRdv prestationRdv2 = new PrestationRdv();
		prestationRdv2.setPrestation(extensionsCil);
		prestationRdv2.setDuree(extensionsCil.getDuree()+10);
		prestationRdv2.setMontant(extensionsCil.getMontant());

		RappelRdvMail alerteMail1 = new RappelRdvMail();
		alerteMail1.setDate(new Date());
		alerteMail1.setMessage("Email message");
		alerteMail1.setSujet("Sujet");
		RappelRdvMail alerteMail2 = new RappelRdvMail();
		alerteMail2.setDate(new Date());
		alerteMail2.setMessage("Email message2");
		alerteMail2.setSujet("Sujet2");
		
		RendezVous rendezVous1 = new RendezVous();
		rendezVous1.setCommentaires("Commentaire 1");
		rendezVous1.setDate(new Date());
		rendezVous1.setRealise(true);
		rendezVous1.setGerante(berangere);
		rendezVous1.getPrestationRdvs().add(prestationRdv1);
		rendezVous1.getPrestationRdvs().add(prestationRdv2);
		rendezVous1.getRappelsMail().add(alerteMail1);
		rendezVous1.getRappelsMail().add(alerteMail2);

		save(rendezVous1);
		
		delete(rendezVous1);
		
		System.out.println("??");

	}

}
