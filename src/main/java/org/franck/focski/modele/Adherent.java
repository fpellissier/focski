package org.franck.focski.modele;

import java.util.List;

/**
 * <b>Fichier :</b> Adherent.java <b>du projet</b> gestionInscriptions<br>
 * <b>Date de cr�ation :</b> 5 oct. 2010<br>
 * <b>Description :</b><br>
 * ...
 * @author Franck PELLISSIER - France Telecom / NCPI / DPS / DDP
 */
public class Adherent extends Personne {
    
  private List<Licencie> licencies;
  private User dataUser; 
	
	private String telFix1;
	private String telFix2;
	private String telMob1;
	private String telMob2;
	private String telBur1;
	private String telBur2;
	private String eMail1;
	private String eMail2;
  private String rue1;
  private String ville1;
  private String cp1;
  private String nom2;
  private String prenom2;
  private String rue2;
  private String ville2;
  private String cp2;
	private String contactSecondaireEst;
	private String commentaire;
	
	public List<Licencie> getLicencies() {
		return licencies;
	}
	public void setDataUser(User dataUser) {
		this.dataUser = dataUser;
	}
	public User getDataUser() {
		return dataUser;
	}
	public void setLicencies(List<Licencie> licencies) {
		this.licencies = licencies;
	}
	public String getTelFix1() {
		return telFix1;
	}
	public void setTelFix1(String telFix1) {
		this.telFix1 = telFix1;
	}
	public String getTelFix2() {
		return telFix2;
	}
	public void setTelFix2(String telFix2) {
		this.telFix2 = telFix2;
	}
	public String getTelMob1() {
		return telMob1;
	}
	public void setTelMob1(String telMob1) {
		this.telMob1 = telMob1;
	}
	public String getTelMob2() {
		return telMob2;
	}
	public void setTelMob2(String telMob2) {
		this.telMob2 = telMob2;
	}
	public void setTelBur1(String telBur1) {
		this.telBur1 = telBur1;
	}
	public void setTelBur2(String telBur2) {
		this.telBur2 = telBur2;
	}
	public String getTelBur2() {
		return telBur2;
	}
	public String getTelBur1() {
		return telBur1;
	}
	public String geteMail1() {
		return eMail1;
	}
	public void seteMail1(String eMail1) {
		this.eMail1 = eMail1;
	}
	public String geteMail2() {
		return eMail2;
	}
	public void seteMail2(String eMail2) {
		this.eMail2 = eMail2;
	}
  public String getRue1() {
    return rue1;
  }
  public void setRue1(String rue) {
    this.rue1 = rue;
  }
  public String getVille1() {
    return ville1;
  }
  public void setVille1(String ville) {
    this.ville1 = ville;
  }
  public String getCp1() {
    return cp1;
  }
  public void setCp1(String cp) {
    this.cp1 = cp;
  }
  public String getNom2() {
    return nom2;
  }
  public void setNom2(String nom) {
    this.nom2 = nom;
  }
  public String getPrenom2() {
    return prenom2;
  }
  public void setPrenom2(String prenom) {
    this.prenom2 = prenom;
  }
  public String getRue2() {
    return rue2;
  }
  public void setRue2(String rue) {
    this.rue2 = rue;
  }
  public String getVille2() {
    return ville2;
  }
  public void setVille2(String ville) {
    this.ville2 = ville;
  }
  public String getCp2() {
    return cp2;
  }
  public void setCp2(String cp) {
    this.cp2 = cp;
  }
	public void setContactSecondaireEst(String contactSecondaireEst) {
		this.contactSecondaireEst = contactSecondaireEst;
	}
	public String getContactSecondaireEst() {
		return contactSecondaireEst;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
}
