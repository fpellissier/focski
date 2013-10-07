package org.franck.focski.web;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.franck.focski.modele.Adherent;
import org.franck.focski.modele.LesArretsDeBus;
import org.franck.focski.modele.LesStatus;
import org.franck.focski.modele.LesTypesDeForfaits;
import org.franck.focski.modele.Licencie;
import org.franck.focski.service.ItfFocskiInscriptionManager;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * <b>Fichier :</b> ModifAdherent.java <b>du projet</b> gestionInscriptions<br>
 * <b>Date de creation :</b> 30 aout 2010<br>
 * <b>Description :</b><br>
 * ...
 * 
 * @author Franck PELLISSIER - France Telecom / NCPI / DPS / DDP
 */
public class GererLicenciesCtrl extends SimpleFormController {
  
  private static final Logger logger =
      Logger.getLogger(GererLicenciesCtrl.class);
  private ItfFocskiInscriptionManager focskiService;
  private LesStatus lesStatus;
  private LesTypesDeForfaits lesForfaits;
  private LesArretsDeBus arretBus;
  private boolean isValidStatusBefore = false;
  
  protected Map<String, Object> referenceData(HttpServletRequest request)
      throws Exception {

    Map<String, Object> lesDonnees = new HashMap<String, Object>();
    lesDonnees.put("lesEtats", lesStatus.getListDesStatus());
    lesDonnees.put("lesForfaits", lesForfaits.getListDesTypesDeForfaits());
    lesDonnees.put("lesArretsDeBus", arretBus.getListDesArrets());
    return lesDonnees;
  }
  
  protected Object formBackingObject(HttpServletRequest request) {

    // Recupere dans le context, le username de l'adherent
    int idl = Integer.parseInt(request.getParameter("idl"));
    Licencie licenceAvantModification = focskiService.liUnLicencie(idl);
    logger.debug("Status licence avant modification= "
        + licenceAvantModification.getStatus());
    if ("Valide".equalsIgnoreCase(licenceAvantModification.getStatus())) {
      isValidStatusBefore = true;
    }
    return licenceAvantModification;
  }
  
  public ModelAndView onSubmit(HttpServletRequest request,
      HttpServletResponse response, Object command, BindException errors)
      throws Exception {

    Licencie li = (Licencie) command;
    String action = request.getParameter("modifOUsupp");
    logger.debug("La licence suivante=" + li.getNom() + " " + li.getPrenom()
        + " va etre=" + action);
    
    if ("modif".equals(action)) {
      // modification de la licencie
      focskiService.adminModifLicencie(li);
      logger.debug("Status licence après modification = " + li.getStatus());
      if (!isValidStatusBefore && "Valide".equalsIgnoreCase(li.getStatus())) {
        // Envoi d'un mail d'information que la licence est passée à l'état
        // validé
        focskiService.envoiMailNotifValidationLicence(li);
      }
      logger.debug("... has beeing modified successfully !!");
    } else {
      if ("supp".equals(action)) {
        // suppression de licencie
        focskiService.suppUnLicencie(li.getId());
      } else {
        // autre => retour a la page d'accueil via getSuccessView()
      }
    }
    
    // lecture des donnees ad + li pour le retour a accueil admin
    SimpleDateFormat modelDate = new SimpleDateFormat("dd/MM/yyyy");
    String now = modelDate.format(System.currentTimeMillis());
    Map<String, Object> myModel = new HashMap<String, Object>();
    List<Adherent> tousLesAd = focskiService.listTousLesAdherents();
    myModel.put("now", now);
    myModel.put("adherents", tousLesAd);
    return new ModelAndView(getSuccessView(), "model", myModel);
  }
  
  /*
   * Getters & Setters
   */
  public ItfFocskiInscriptionManager getFocskiService() {

    logger.debug("***");
    return this.focskiService;
  }
  
  public void setFocskiService(ItfFocskiInscriptionManager focskiService) {

    logger.debug("***");
    this.focskiService = focskiService;
  }
  
  public void setLesStatus(LesStatus listDesStatus) {

    this.lesStatus = listDesStatus;
  }
  
  public LesStatus getLesStatus() {

    return this.lesStatus;
  }
  
  public LesTypesDeForfaits getLesForfaits() {

    return lesForfaits;
  }
  
  public void setLesForfaits(LesTypesDeForfaits lesForfaits) {

    this.lesForfaits = lesForfaits;
  }
  
  public LesArretsDeBus getArretBus() {

    return arretBus;
  }
  
  public void setArretBus(LesArretsDeBus arretBus) {

    this.arretBus = arretBus;
  }
}
