package org.franck.focski.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.franck.focski.modele.Adherent;
import org.franck.focski.modele.Licencie;
import org.franck.focski.service.ItfFocskiInscriptionManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ShowListAdherentCtrl implements Controller {
  
  private static final Logger logger =
      Logger.getLogger(ShowListAdherentCtrl.class);
  
  private ItfFocskiInscriptionManager focskiService;
  private String vue;
  
  public ModelAndView handleRequest(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {

    Map<String, Object> myModel = new HashMap<String, Object>();
    SimpleDateFormat modelDate = new SimpleDateFormat("dd/MM/yyyy");

    // lecture des donnees ad + li pour le retour a accueil admin
    String now = modelDate.format(System.currentTimeMillis());
    String filtre = request.getParameter("filtre");
    List<Adherent> tousLesAd = null;
    
    if (null == filtre) tousLesAd = focskiService.listTousLesAdherents();
    else tousLesAd = focskiService.listLesAdherents(filtre);
    myModel.put("now", now);
    myModel.put("adherents", tousLesAd);
    
    // On ecrit dans le log
    logger.info("Nb d'adherents =" + tousLesAd.size());
    Iterator<Adherent> i = tousLesAd.iterator();
    while (i.hasNext()) {
      Adherent a;
      a = (Adherent) i.next();
      logger.debug("Pour l'adherent = " + a.getNom() + " " + a.getPrenom()
          + ", la liste des licencies est :");
      Iterator<Licencie> j = a.getLicencies().iterator();
      while (j.hasNext()) {
        Licencie li;
        li = (Licencie) j.next();
        logger.debug("\n\t - licencie : " + li.getNom() + " " + li.getPrenom()
            + " " + li.getNaissance() + ";");
      }
    }
    logger.info("Nb d'adherents =" + tousLesAd.size());
    
    return new ModelAndView(getVue(), "model", myModel);
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
  
  public String getVue() {

    return vue;
  }
  
  public void setVue(String vue) {

    this.vue = vue;
  }
}
