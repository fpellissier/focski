package org.franck.focski.service;

import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.franck.focski.dao.ItfAdherentEngine;
import org.franck.focski.dao.ItfLicencieEngine;
import org.franck.focski.modele.Adherent;
import org.franck.focski.modele.Licencie;
import org.franck.focski.smtp.ItfSmtpConnector;

@SuppressWarnings("serial")
public class ImplFocskiInscriptionManager implements
    ItfFocskiInscriptionManager {
  
  private static final Logger logger =
      Logger.getLogger(ImplFocskiInscriptionManager.class);
  
  private ItfAdherentEngine adherentEngine;
  private ItfLicencieEngine licencieEngine;
  private ItfSmtpConnector smtpConnector;
  
  /*
   * Methodes liees aux adherents
   */
  public void creeUnAdherent(Adherent a) {

    adherentEngine.create(a);
  }
  
  public Adherent liUnAdherent(String username) {

    return adherentEngine.read(username);
  }
  
  public Adherent liUnAdherent(String nom, String prenom) {

    return adherentEngine.read(nom, prenom);
  }
  
  public List<Adherent> listTousLesAdherents() {

    List<Adherent> lesAd;
    lesAd = adherentEngine.getAllAdherents();
    
    Iterator<Adherent> iterAD = lesAd.iterator();
    
    while (iterAD.hasNext()) {
      Adherent a;
      a = (Adherent) iterAD.next();
      a.setLicencies(licencieEngine.getLicencies(a.getDataUser().getLogin()));
    }
    return lesAd;
  }
  
  public List<Adherent> listLesAdherents(String filtre) {

    List<Adherent> lesAd;
    lesAd = adherentEngine.getAllAdherents();
    
    logger.debug("Filtrage de type=" + filtre);
    
    Iterator<Adherent> iterAD = lesAd.iterator();
    
    if (filtre.equalsIgnoreCase("competition")) {
      while (iterAD.hasNext()) {
        Adherent a;
        boolean onLeGarde = false;
        a = (Adherent) iterAD.next();
        List<Licencie> lesLi =
            licencieEngine.getLicencies(a.getDataUser().getLogin());
        Iterator<Licencie> iterLi = lesLi.iterator();
        while (iterLi.hasNext()) {
          Licencie li;
          li = iterLi.next();
          if (li.getLicenceType().contains("comp")) {
            onLeGarde = true;
          }
        }
        a.setLicencies(lesLi);
        if (!onLeGarde)
          iterAD.remove();
      }
    } else if (filtre.equalsIgnoreCase("loisirM")) {
      while (iterAD.hasNext()) {
        Adherent a;
        boolean onLeGarde = false;
        a = (Adherent) iterAD.next();
        List<Licencie> lesLi =
            licencieEngine.getLicencies(a.getDataUser().getLogin());
        Iterator<Licencie> iterLi = lesLi.iterator();
        while (iterLi.hasNext()) {
          Licencie li;
          li = iterLi.next();
          if (li.getLicenceType().contains("loisir")
              && li.getSeances().contains("Mercredi")) {
            onLeGarde = true;
          }
        }
        a.setLicencies(lesLi);
        if (!onLeGarde)
          iterAD.remove();
      }
    } else if (filtre.equalsIgnoreCase("loisirS")) {
      while (iterAD.hasNext()) {
        Adherent a;
        boolean onLeGarde = false;
        a = (Adherent) iterAD.next();
        List<Licencie> lesLi =
            licencieEngine.getLicencies(a.getDataUser().getLogin());
        Iterator<Licencie> iterLi = lesLi.iterator();
        while (iterLi.hasNext()) {
          Licencie li;
          li = iterLi.next();
          if (li.getLicenceType().contains("loisir")
              && li.getSeances().contains("Samedi")) {
            onLeGarde = true;
          }
        }
        a.setLicencies(lesLi);
        if (!onLeGarde)
          iterAD.remove();
      }
    } else if (filtre.equalsIgnoreCase("benevole")) {
      while (iterAD.hasNext()) {
        Adherent a;
        boolean onLeGarde = false;
        a = (Adherent) iterAD.next();
        List<Licencie> lesLi =
            licencieEngine.getLicencies(a.getDataUser().getLogin());
        Iterator<Licencie> iterLi = lesLi.iterator();
        while (iterLi.hasNext()) {
          Licencie li;
          li = iterLi.next();
          if (li.getLicenceType().contains("vole")) {
            onLeGarde = true;
          }
        }
        a.setLicencies(lesLi);
        if (!onLeGarde)
          iterAD.remove();
      }
    }
    
    return lesAd;
  }
  
  public void suppUnAdherent(String username) {

    adherentEngine.delete(username);
  }
  
  public void sauveUnAdherent(Adherent a) {

    adherentEngine.update(a);
  }
  
  public void adminModifAdherent(Adherent a) {

    adherentEngine.updateDonneesAdmin(a);
  }
  
  public Adherent searchAdherentByEmail(String eMail) {

    return adherentEngine.searchAdByEmail(eMail);
  }
  
  public void envoiDonneesConnexionAdherant(String mail, String login,
      String pwd) {

    smtpConnector.sendToAherentConnexionInfo(mail, login, pwd);
  }
  
  /*
   * Methodes liees aux licencies
   */
  public void creeUnLicencie(Licencie l) {

    licencieEngine.create(l);
  }
  
  public Licencie liUnLicencie(int idl) {

    return licencieEngine.read(idl);
  }
  
  public List<Licencie> listTousLesLicencies() {

    return licencieEngine.getAllLicencies();
  }
  
  public List<Licencie> listLesLicenciesDeAdherent(String username) {

    return licencieEngine.getLicencies(username);
  }
  
  public void suppUnLicencie(int idl) {

    licencieEngine.delete(idl);
  }
  
  public void sauveUnLicencie(Licencie l) {

    licencieEngine.update(l);
  }
  
  public void adminModifLicencie(Licencie l) {

    licencieEngine.updateDonneesAdmin(l);
  }
  
  public void envoiMailNotifCreationAdherant(Adherent a) {

    smtpConnector.sendNotificationCreateAccount(a);
  }
  
  public void envoiMailNotifValidationLicence(Licencie li) {

    Adherent ad = adherentEngine.read(li.getPereUername());
    smtpConnector.sendNotificationValidationLicence(ad.geteMail1(),
        li.getNom(), li.getPrenom());
  }
  
  /*
   * Getters & Setters
   */
  public ItfAdherentEngine getAdherentEngine() {

    return adherentEngine;
  }
  
  public void setAdherentEngine(ItfAdherentEngine adherent) {

    this.adherentEngine = adherent;
  }
  
  public ItfLicencieEngine getLicencieEngine() {

    return licencieEngine;
  }
  
  public void setLicencieEngine(ItfLicencieEngine licencieEngine) {

    this.licencieEngine = licencieEngine;
  }
  
  public void setSmtpConnector(ItfSmtpConnector smtpConnector) {

    this.smtpConnector = smtpConnector;
  }
  
  public ItfSmtpConnector getSmtpConnector() {

    return smtpConnector;
  }
}
