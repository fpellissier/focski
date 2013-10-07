package org.franck.focski.web;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
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
 * <b>Fichier :</b> ModifAdherent.java <b>du projet</b> gestionInscriptions<br>
 * <b>Date de creation :</b> 30 aout 2010<br>
 * <b>Description :</b><br>
 * ...
 * @author Franck PELLISSIER - France Telecom / NCPI / DPS / DDP
 */
public class GererAdherentsCtrl extends SimpleFormController {

	private static final Logger logger = Logger.getLogger(GererAdherentsCtrl.class);
	private ItfFocskiInscriptionManager focskiService;
	
	protected Object formBackingObject(HttpServletRequest request){
        //Recupere dans le context, le username de l'adherent
		String username = request.getParameter("username");
		return focskiService.liUnAdherent(username);
	}
	
	public ModelAndView onSubmit (HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors) throws Exception {
		
		Adherent ad = (Adherent) command;
		String action = request.getParameter("modifOUsupp");
		logger.debug("L'adherent suivant="+ad.getNom()+ " " +ad.getPrenom()+" va etre="+action);

		if("modif".equals(action)){
			//modification adherent
			focskiService.adminModifAdherent(ad);
			logger.debug("... has beeing modified successfully !!");
		} else {
			if ("supp".equals(action)){
				//suppression adherent
				focskiService.suppUnAdherent(ad.getDataUser().getLogin());
			}
			else {
				//autre => retour � la page d'accueil via getSuccessView()
			}
		}

		//lecture des donnees ad + li pour le retour a accueil admin
		SimpleDateFormat modelDate = new SimpleDateFormat("dd/MM/yyyy");
		String now = modelDate.format(System.currentTimeMillis());
        Map<String, Object> myModel = new HashMap<String, Object>();
        List<Adherent> tousLesAd = focskiService.listTousLesAdherents();
        myModel.put("now", now);
        myModel.put("adherents", tousLesAd);
 
		return new ModelAndView( getSuccessView(),"model",myModel );
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
