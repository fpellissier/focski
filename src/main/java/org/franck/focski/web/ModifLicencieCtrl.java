package org.franck.focski.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.franck.focski.modele.LesArretsDeBus;
import org.franck.focski.modele.LesSeances;
import org.franck.focski.modele.LesTypesDAdhesion;
import org.franck.focski.modele.Licencie;
import org.franck.focski.modele.LesNiveauxDeSki;
import org.franck.focski.service.ItfFocskiInscriptionManager;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;


/**
 * <b>Fichier :</b> ModifAdherent.java <b>du projet</b> gestionInscriptions<br>
 * <b>Date de creation :</b> 30 aout 2010<br>
 * <b>Description :</b><br>
 * ...
 * @author Franck PELLISSIER - France Telecom / NCPI / DPS / DDP
 */
public class ModifLicencieCtrl extends SimpleFormController {

	private static final Logger logger = Logger.getLogger(ModifLicencieCtrl.class);
	private ItfFocskiInscriptionManager focskiService;
	private LesSeances lesSeances;
	private LesArretsDeBus arretBus;
	private LesNiveauxDeSki niveauSki;
	private LesTypesDAdhesion lesAdhesions;

	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map lesDonnees = new HashMap();
		lesDonnees.put("arretbus", arretBus.getListDesArrets());
		lesDonnees.put("seances", lesSeances.getlistDesSeances());
		lesDonnees.put("niveaux", niveauSki.getListDesNiveaux());
		lesDonnees.put("adhesions", lesAdhesions.getListDesTypesAdhesion());
		return lesDonnees;
	}

	protected Object formBackingObject(HttpServletRequest request){

        //Recupere dans le context, l'id du licencie
		int idl = Integer.parseInt(request.getParameter("idl"));
		Licencie li = focskiService.liUnLicencie(idl);
		if(li.getPereUername().equals(getUsernameAdherentConnecte())){
			return li;
		}
		//on plante l'application - tentative de frode
		return null;
	}
	
	public ModelAndView onSubmit (HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors) throws Exception {
		
        Map<String, Object> myModel = new HashMap<String, Object>();
		
        //Recupere dans le context, le username de l'adherent
        String username = getUsernameAdherentConnecte();
		
		Licencie li = (Licencie) command;
		String action = request.getParameter("modifOUsupp");
		logger.debug("Controler edit licence action="+action);
		if("modif".equals(action)){
			//modification de licencie
			focskiService.sauveUnLicencie(li);
			logger.debug("... has beeing modified successfully !!");
		} else {
			if ("supp".equals(action)){
				//suppression de licencie
				focskiService.suppUnLicencie(li.getId());
			}
			else {
				//autre => retour � la page d'accueil via getSuccessView()
			}
		}
		myModel.put("adherent", focskiService.liUnAdherent(username));
		myModel.put("licencies", focskiService.listLesLicenciesDeAdherent(username));
		return new ModelAndView ( getSuccessView(), "model", myModel );

	}

	private String getUsernameAdherentConnecte(){
        //Recupere dans le context, le username de l'adherent
        String username;
		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (obj instanceof UserDetails) {
			username = ((UserDetails) obj).getUsername();
		} else {
			username = obj.toString();
		}
		return username;
	}
	
	/*
	 * Getters & Setters
	 */
	public ItfFocskiInscriptionManager getFocskiService() {
        logger.debug("***");
		return focskiService;
	}
	public void setFocskiService(ItfFocskiInscriptionManager focskiService) {
        logger.debug("***");
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
