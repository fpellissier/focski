package org.franck.focski.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.franck.focski.modele.Adherent;
import org.franck.focski.modele.Licencie;
import org.franck.focski.service.ItfFocskiInscriptionManager;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class AccueilAdherentCtrl implements Controller {
  
  private static final String ROLE_ADMIN = "ROLE_ADMIN";
  
  private static final Logger logger =
      Logger.getLogger(AccueilAdherentCtrl.class);
  
  private ItfFocskiInscriptionManager focskiService;
  
  public ModelAndView handleRequest(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {

    SimpleDateFormat modelDate = new SimpleDateFormat("dd/MM/yyyy");
    String now = modelDate.format(System.currentTimeMillis());
    
    Map<String, Object> myModel = new HashMap<String, Object>();
    myModel.put("now", now);
    
    // Recupere dans le context, le username de l'adherent
    String username;
    Object obj =
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (obj instanceof UserDetails) {
      username = ((UserDetails) obj).getUsername();
    } else {
      username = obj.toString();
    }
    
    // li les donnees adherent en BDD
    logger.info("Accueil pour : " + username);
    Adherent ad = focskiService.liUnAdherent(username);
    myModel.put("adherent", ad);
    logger.info("Renvoi l'object adherent = " + username);
    
    // li les donnees de tous les licencies en BDD
    List<Licencie> lesLi = focskiService.listLesLicenciesDeAdherent(username);
    myModel.put("licencies", lesLi);
    logger.info("Renvoi l'object list de " + lesLi.size() + "licencies.");
    
    ModelAndView vue = null;
    logger.info("Acces a la page accueil par : " + username
        + ", avec le role : " + ad.getDataUser().getRole());
    if (ROLE_ADMIN.equals(ad.getDataUser().getRole())) {
      vue = new ModelAndView("accueilAdherentAdmin", "model", myModel);
    } else {
      vue = new ModelAndView("accueilAdherent", "model", myModel);
    }
    return vue;
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
