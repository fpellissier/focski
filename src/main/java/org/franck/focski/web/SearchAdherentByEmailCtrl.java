package org.franck.focski.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.franck.focski.modele.Adherent;
import org.franck.focski.service.ItfFocskiInscriptionManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * <b>Fichier :</b> CreateAdherent.java <b>du projet</b> gestionInscriptions<br>
 * <b>Date de creation :</b> 30 aout 2010<br>
 * <b>Description :</b><br>
 * ...
 * 
 * @author Franck PELLISSIER - France Telecom / NCPI / DPS / DDP
 */
public class SearchAdherentByEmailCtrl implements Controller {
  
  private static final Logger logger =
      Logger.getLogger(SearchAdherentByEmailCtrl.class);
  
  private ItfFocskiInscriptionManager focskiService;
  
  public ModelAndView handleRequest(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {

    Map<String, Object> myModel = new HashMap<String, Object>();
    String eMail = request.getParameter("email");
    String returnText = null;
    
    Adherent adherent = focskiService.searchAdherentByEmail(eMail);
    
    if (null == adherent) {
      logger.info("Demande de mot de passe sur email inconnu: " + eMail);
      returnText =
          "L'adresse " + eMail
              + " n'a pas ete trouve dans la base d'inscription. "
              + "Verifiez votre adresse ou essayez en une autre. "
              + "Merci de vous creer un compte.";
    } else {
      logger.info("Demande de mot de passe sur email connu: " + eMail);
      returnText =
          "L'adresse "
              + eMail
              + " a ete trouve !!!!!. Un message va etre envoye avec vos informations de connexion. Merci.";
      // Envoi un email
      focskiService.envoiDonneesConnexionAdherant(eMail,
          adherent.getDataUser().getLogin(), adherent.getDataUser().getPasswd());
    }
    
    myModel.put("text", returnText);
    return new ModelAndView("default", "model", myModel);
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
}
