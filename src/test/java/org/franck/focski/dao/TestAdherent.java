package org.franck.focski.dao;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.franck.focski.modele.Adherent;
import org.franck.focski.modele.Licencie;
import org.springframework.util.Assert;

public class TestAdherent extends TestCase {
	
	private static final int ID = 1234;
	private static final long DATE_CREATION = System.currentTimeMillis();
	private static final String NOM = "Pellissier";
	private static final String PRENOM = "Franck";
	private static final String FIX1 = "0476761111";
	private static final String FIX2 = "0476762222";;
	private static final String MOB1 = "0608681111";;
	private static final String MOB2 = "0608682222";;
	private static final String MAIL1 = "franck.pellissier@voila.fr";
	private static final String MAIL2 = "pellissierca@orange.fr";
	private static final String RUE = "1590 rue de belledonne";
	private static final String VILLE = "CROLES";
	private static final String CP = "38920";
	private static final String CONTACT_SEC = "mere";

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}

	public void testGetSetLicencies() {
		Adherent a = new Adherent();
		Assert.isNull(a.getLicencies());
		List<Licencie> listLicencies = new ArrayList<Licencie>();
		Licencie l1 = new Licencie();
		listLicencies.add(l1);
		a.setLicencies(listLicencies);
		assertEquals(1, a.getLicencies().size());
		assertEquals(l1, a.getLicencies().get(0));
		Licencie l2 = new Licencie();
		Licencie l3 = new Licencie();
		Licencie l4 = new Licencie();
		Licencie l5 = new Licencie();
		listLicencies.add(l2);
		listLicencies.add(l3);
		listLicencies.add(l4);
		listLicencies.add(l5);		
		a.setLicencies(listLicencies);
		assertEquals(5, a.getLicencies().size());
		assertEquals(l4, a.getLicencies().get(3));
	}

	public void testGetSetDateDeCreation() {
		Adherent a = new Adherent();
		assertEquals(0,a.getDateDeCreation());
		a.setDateDeCreation(DATE_CREATION);
		assertEquals(DATE_CREATION, a.getDateDeCreation());
	}

	public void testGetSetId() {
		Adherent a = new Adherent();
		assertEquals(0,a.getId());
		a.setId(ID);
		assertEquals(ID, a.getId());
	}

	public void testGetSetNom() {
		Adherent a = new Adherent();
		Assert.isNull(a.getNom());
		a.setNom(NOM);
		assertEquals(NOM, a.getNom());
	}

	public void testGetSetPrenom() {
		Adherent a = new Adherent();
		Assert.isNull(a.getPrenom());
		a.setPrenom(PRENOM);
		assertEquals(PRENOM, a.getPrenom());
	}

	public void testGetSetTelFix1() {
		Adherent a = new Adherent();
		Assert.isNull(a.getTelFix1());
		a.setTelFix1(FIX1);
		assertEquals(FIX1, a.getTelFix1());
	}

	public void testGetSetTelFix2() {
		Adherent a = new Adherent();
		Assert.isNull(a.getTelFix2());
		a.setTelFix2(FIX2);
		assertEquals(FIX2, a.getTelFix2());
	}

	public void testGetSetTelMob1() {
		Adherent a = new Adherent();
		Assert.isNull(a.getTelMob1());
		a.setTelMob1(MOB1);
		assertEquals(MOB1, a.getTelMob1());
	}

	public void testGetSetTelMob2() {
		Adherent a = new Adherent();
		Assert.isNull(a.getTelMob2());
		a.setTelMob2(MOB2);
		assertEquals(MOB2, a.getTelMob2());
	}

	public void testGetSeteMail1() {
		Adherent a = new Adherent();
		Assert.isNull(a.geteMail1());
		a.seteMail1(MAIL1);
		assertEquals(MAIL1, a.geteMail1());
	}

	public void testGetSeteMail2() {
		Adherent a = new Adherent();
		Assert.isNull(a.geteMail2());
		a.seteMail2(MAIL2);
		assertEquals(MAIL2, a.geteMail2());
	}

	public void testGetSetRue() {
		Adherent a = new Adherent();
		Assert.isNull(a.getRue1());
		a.setRue1(RUE);
		assertEquals(RUE, a.getRue1());
	}

	public void testGetSetVille() {
		Adherent a = new Adherent();
		Assert.isNull(a.getVille1());
		a.setVille1(VILLE);
		assertEquals(VILLE, a.getVille1());
	}

	public void testGetSetCp() {
		Adherent a = new Adherent();
		Assert.isNull(a.getCp1());
		a.setCp1(CP);
		assertEquals(CP, a.getCp1());
	}

	public void testGetSetContactSecondaireEst() {
		Adherent a = new Adherent();
		Assert.isNull(a.getContactSecondaireEst());
		a.setContactSecondaireEst(CONTACT_SEC);
		assertEquals(CONTACT_SEC, a.getContactSecondaireEst());
	}
}
