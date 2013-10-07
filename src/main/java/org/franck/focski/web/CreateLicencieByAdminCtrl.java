package org.franck.focski.web;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.franck.focski.modele.LesArretsDeBus;
import org.franck.focski.modele.LesNiveauxDeSki;
import org.franck.focski.modele.LesSeances;
import org.franck.focski.modele.LesTypesDAdhesion;
import org.franck.focski.modele.Licencie;
import org.franck.focski.service.ItfFocskiInscriptionManager;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * <b>Fichier :</b> CreateLicencieCtrl.java <b>du projet</b> gestionInscriptions<br>
 * <b>Date de cr�ation :</b> 24 sept. 2010<br>
 * <b>Description :</b><br>
 * ...
 * 
 * @author Franck PELLISSIER - France Telecom / NCPI / DPS / DDP
 */
public class CreateLicencieByAdminCtrl extends SimpleFormController {
  
  private static final Logger logger =
      Logger.getLogger(CreateLicencieByAdminCtrl.class);
  private ItfFocskiInscriptionManager focskiService;
  private LesArretsDeBus arretBus;
  private LesSeances lesSeances;
  private LesNiveauxDeSki niveauSki;
  private LesTypesDAdhesion lesAdhesions;
  private String username = null;
  
  protected Map<String, Object> referenceData(HttpServletRequest request)
      throws Exception {

    Map<String, Object> lesDonnees = new HashMap<String, Object>();
    lesDonnees.put("arretbus", arretBus.getListDesArrets());
    lesDonnees.put("seances", lesSeances.getlistDesSeances());
    lesDonnees.put("niveaux", niveauSki.getListDesNiveaux());
    lesDonnees.put("adhesions", lesAdhesions.getListDesTypesAdhesion());
    username = request.getParameter("username");
    lesDonnees.put("username", username);
    return lesDonnees;
  }
  
  public ModelAndView onSubmit(HttpServletRequest request,
      HttpServletResponse response, Object command, BindException errors)
      throws Exception {

    // ModelAndView vue = new ModelAndView( getSuccessView() );
    Map<String, Object> myModel = new HashMap<String, Object>();
    
    logger.debug("The following licencie is going to be created \n\t "
        + command.toString());
    Licencie newLicencie = (Licencie) command;
    newLicencie.setPereUername(username);
    
    // Completer les champs non renseigne dans le formulaire par des valeur par
    // defaut
    newLicencie.setCertificat(false);
    newLicencie.setForfaitType("?To be defined?");
    newLicencie.setMontant(0);
    newLicencie.setNumCarteClub("0000");
    newLicencie.setNumLicence("0000");
    newLicencie.setSolde(0);
    newLicencie.setStatus("Cree");// Valeur � synchroniser avec le bean
                                  // lesStatus
    
    focskiService.creeUnLicencie(newLicencie);
    logger.debug("Adherent : " + newLicencie.getNom() + " has been created !");
    
    return new ModelAndView ( getSuccessView());
  }
  
  /*
   * Getters et Setters
   */
  public ItfFocskiInscriptionManager getFocskiService() {

    return focskiService;
  }
  
  public void setFocskiService(ItfFocskiInscriptionManager focskiService) {

    this.focskiService = focskiService;
  }
  
  public LesArretsDeBus getArretBus() {

    return arretBus;
  }
  
  public void setArretBus(LesArretsDeBus arretBus) {

    this.arretBus = arretBus;
  }
  
  public LesNiveauxDeSki getNiveauSki() {

    return niveauSki;
  }
  
  public void setNiveauSki(LesNiveauxDeSki niveauSki) {

    this.niveauSki = niveauSki;
  }
  
  public LesSeances getLesSeances() {

    return lesSeances;
  }
  
  public void setLesSeances(LesSeances lesSeances) {

    this.lesSeances = lesSeances;
  }
  
  public LesTypesDAdhesion getLesAdhesions() {

    return lesAdhesions;
  }
  
  public void setLesAdhesions(LesTypesDAdhesion lesAdhesions) {

    this.lesAdhesions = lesAdhesions;
  }
}
