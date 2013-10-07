package org.franck.focski.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.franck.focski.modele.Adherent;
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
public class ModifAdherentCtrl extends SimpleFormController {

	private static final Logger logger = Logger.getLogger(ModifAdherentCtrl.class);
	private ItfFocskiInscriptionManager focskiService;
	
	protected Object formBackingObject(HttpServletRequest request){

        //Recupere dans le context, le username de l'adherent
        String username;
		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (obj instanceof UserDetails) {
			username = ((UserDetails) obj).getUsername();
		} else {
			username = obj.toString();
		}

        logger.debug("ModifAdherentCtrl - username =" +username);
		Adherent adherent = focskiService.liUnAdherent(username);
		if (adherent.getDataUser().getRole()=="ROLE_ADMIN"){
			// remplace le username du user connecte par celui recherche
			username = request.getParameter("username");
			if( !(null == username) ){
				adherent = focskiService.liUnAdherent(username);
		        logger.debug("ModifAdherentCtrl - username est finalement =" +username);
			}
		}
        logger.debug("Found adherent is : " +adherent.getNom() + adherent.getPrenom()+adherent.geteMail1());		
		return adherent;
	}
	
	public ModelAndView onSubmit (HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors) throws Exception {
		
        Map<String, Object> myModel = new HashMap<String, Object>();
		
		Adherent ad = (Adherent) command;
		logger.debug("The following adherent is going to be modified : " + ad.getNom() + " " +ad.getPrenom());

		focskiService.sauveUnAdherent(ad);
		logger.debug("Adherent : " + ad.getNom()+" has beeing modified successfully !!");
		myModel.put("adherent", focskiService.liUnAdherent(ad.getNom(), ad.getPrenom()));
		return new ModelAndView( getSuccessView(),"model", myModel );
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
}
