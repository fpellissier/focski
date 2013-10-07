package org.franck.focski.service;

import java.io.Serializable;
import java.util.List;

import org.franck.focski.modele.Adherent;
import org.franck.focski.modele.Licencie;

public interface ItfFocskiInscriptionManager extends Serializable {

	public void creeUnAdherent(Adherent a);
	public void suppUnAdherent(String username);
	public Adherent liUnAdherent(String username);
	public Adherent liUnAdherent(String nom, String prenom);
	public void sauveUnAdherent(Adherent a);
	public void adminModifAdherent(Adherent a);
	public List<Adherent> listTousLesAdherents();
	public List<Adherent> listLesAdherents(String filtre);

	public void creeUnLicencie(Licencie l);
	public void suppUnLicencie(int idl);
	public Licencie liUnLicencie(int idl);
	public void sauveUnLicencie(Licencie l);
	public void adminModifLicencie(Licencie l); //permet de valoriser des champs de validation
	public List<Licencie> listTousLesLicencies();
	public List<Licencie> listLesLicenciesDeAdherent(String username);
	
	public Adherent searchAdherentByEmail(String eMail);
	public void envoiMailNotifCreationAdherant(Adherent a);
  public void envoiDonneesConnexionAdherant(String mail,String login,String pwd);
  public void envoiMailNotifValidationLicence(Licencie li);
}