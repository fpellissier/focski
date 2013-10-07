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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ExcelExtractCtrl extends AbstractController {

	private static final Logger logger = Logger.getLogger(ExcelExtractCtrl.class);
	private ItfFocskiInscriptionManager focskiService;
    	 
    	protected ModelAndView handleRequestInternal(HttpServletRequest request,
    		HttpServletResponse response) throws Exception {
     
    		logger.debug("ExcelExtractCtrl=>handleRequestInternal");
    		//lecture des donnees ad + li
    		SimpleDateFormat modelDate = new SimpleDateFormat("dd/MM/yyyy");
    		String now = modelDate.format(System.currentTimeMillis());
            List<Adherent> tousLesAd = focskiService.listTousLesAdherents();

            Map<String, Object> myModel = new HashMap<String, Object>();
            myModel.put("now", now);
            myModel.put("adherents", tousLesAd);
            
     		//return Excel view
    		return new ModelAndView("ExcelExt","model",myModel);
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
