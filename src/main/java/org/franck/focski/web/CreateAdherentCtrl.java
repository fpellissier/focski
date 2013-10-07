package org.franck.focski.web;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.franck.focski.modele.Adherent;
import org.franck.focski.service.ItfFocskiInscriptionManager;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * <b>Fichier :</b> CreateAdherent.java <b>du projet</b> gestionInscriptions<br>
 * <b>Date de creation :</b> 30 aout 2010<br>
 * <b>Description :</b><br>
 * ...
 * 
 * @author Franck PELLISSIER - France Telecom / NCPI / DPS / DDP
 */
public class CreateAdherentCtrl extends SimpleFormController {
  
  private static final Logger logger = Logger.getLogger(CreateAdherentCtrl.class);
  private ItfFocskiInscriptionManager focskiService;
  
  public ModelAndView onSubmit(HttpServletRequest request,
      HttpServletResponse response, Object command, BindException errors)
      throws Exception {

    Map<String, Object> myModel = new HashMap<String, Object>();
    
    logger.debug("The following adherent is going to be created \n\t "
        + command.toString());
    Adherent nouvelAdherent = (Adherent) command;
    
    focskiService.creeUnAdherent(nouvelAdherent);
    logger.debug("Adherent : " + nouvelAdherent.getNom()
        + " has been created !");
    
    Adherent ad =
        focskiService.liUnAdherent(nouvelAdherent.getNom(),
            nouvelAdherent.getPrenom());
    
    focskiService.envoiMailNotifCreationAdherant(ad);
    
    myModel.put("adherent", ad);
    return new ModelAndView(getSuccessView(), "model", myModel);
  }
  
  /*
   * Getters et Setters
   */
  public ItfFocskiInscriptionManager getFocskiService() {

    logger.debug("***");
    return focskiService;
  }
  
  public void setFocskiService(ItfFocskiInscriptionManager focskiService) {

    logger.debug("***");
    this.focskiService = focskiService;
  }
}
