package org.franck.focski.modele;

import org.apache.log4j.Logger;

public class Licencie extends Personne {
  
  @SuppressWarnings("unused")
  private static final Logger logger = Logger.getLogger(Licencie.class);
  
  private String pereUername;
  private String sexe;
  private String naissance;
  private String licenceType;
  private String skiOUsurf;
  private String niveau;
  private String niveauValide;
  private String forfaitType;
  private String arretBus;
  private String seances;
  private String numCarteClub;
  private String numLicence;
  private boolean certificat;
  private String status;
  private float montant;
  private float solde;
  private String commentaire;
  
  public void setPereUername(String pereUername) {

    this.pereUername = pereUername;
  }
  
  public String getPereUername() {

    return pereUername;
  }
  
  public String getSexe() {

    return sexe;
  }
  
  public void setSexe(String sexe) {

    this.sexe = sexe;
  }
  
  public String getNaissance() {

    return naissance;
  }
  
  public void setNaissance(String naissance) {

    this.naissance = naissance;
  }
  
  public String getLicenceType() {

    return licenceType;
  }
  
  public void setLicenceType(String licenceType) {

    this.licenceType = licenceType;
  }
  
  public void setSkiOUsurf(String skiOUsurf) {

    this.skiOUsurf = skiOUsurf;
  }
  
  public String getSkiOUsurf() {

    return skiOUsurf;
  }
  
  public String getNiveau() {

    return niveau;
  }
  
  public void setNiveau(String niveau) {

    this.niveau = niveau;
  }
  
  public void setNiveauValide(String niveauValide) {

    this.niveauValide = niveauValide;
  }
  
  public String getNiveauValide() {

    return niveauValide;
  }
  
  public String getForfaitType() {

    return forfaitType;
  }
  
  public void setForfaitType(String forfaitType) {

    this.forfaitType = forfaitType;
  }
  
  public String getArretBus() {

    return arretBus;
  }
  
  public void setArretBus(String arretBus) {

    this.arretBus = arretBus;
  }
  
  public String getSeances() {

    return seances;
  }
  
  public void setSeances(String seances) {

    this.seances = seances;
  }
  
  public String getNumCarteClub() {

    return numCarteClub;
  }
  
  public void setNumCarteClub(String numCarteClub) {

    this.numCarteClub = numCarteClub;
  }
  
  public String getNumLicence() {

    return numLicence;
  }
  
  public void setNumLicence(String numLicence) {

    this.numLicence = numLicence;
  }
  
  public boolean isCertificat() {

    return certificat;
  }
  
  public void setCertificat(boolean certificat) {

    this.certificat = certificat;
  }
  
  public String getStatus() {

    return status;
  }
  
  public void setStatus(String status) {

    this.status = status;
  }
  
  public void setMontant(float montant) {

    this.montant = montant;
  }
  
  public float getMontant() {

    return this.montant;
  }
  
  public void setSolde(float solde) {

    this.solde = solde;
  }
  
  public float getSolde() {

    return this.solde;
  }
  
  public void setCommentaire(String commentaire) {

    this.commentaire = commentaire;
  }
  
  public String getCommentaire() {

    return commentaire;
  }
}