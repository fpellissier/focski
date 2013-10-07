package org.franck.focski.web;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.franck.focski.modele.Adherent;
import org.franck.focski.modele.Licencie;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelExtractView extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
 
		Map<String,Object> leModel = (Map<String,Object>) model.get("model");
		String now = (String) leModel.get("now");
		logger.debug("now is = "+now);
		List<Adherent> lesAd = (List<Adherent>) leModel.get("adherents");
		logger.debug("Nb key tousLesAd = "+lesAd.size());
		//create a wordsheet
		HSSFSheet sheet = workbook.createSheet("Les adhesions");
 
		HSSFRow title = sheet.createRow(0);
		title.createCell(0).setCellValue("Extraction en date du : " + now);
		HSSFRow header = sheet.createRow(1);
		header.createCell(0).setCellValue("id");
		header.createCell(1).setCellValue("Nom");
		header.createCell(2).setCellValue("Prenom");
		header.createCell(3).setCellValue("Username");
		header.createCell(4).setCellValue("Creation");
		header.createCell(5).setCellValue("TelFixe1");
		header.createCell(6).setCellValue("TelFixe2");
		header.createCell(7).setCellValue("TelBur1");
		header.createCell(8).setCellValue("TelBur2");
		header.createCell(9).setCellValue("Mob1");
		header.createCell(10).setCellValue("Mob2");
		header.createCell(11).setCellValue("Mail1");
		header.createCell(12).setCellValue("Mail2");
		header.createCell(13).setCellValue("Rue");
		header.createCell(14).setCellValue("CP");
		header.createCell(15).setCellValue("Ville");
		header.createCell(16).setCellValue("Contact2est");
		header.createCell(17).setCellValue("Sexe");
		header.createCell(18).setCellValue("Naissance");
		header.createCell(19).setCellValue("TypeLicence");
		header.createCell(20).setCellValue("NiveauDeclare");
		header.createCell(21).setCellValue("NiveauFoc");
		header.createCell(22).setCellValue("TypeForfait");
		header.createCell(23).setCellValue("Seances");
		header.createCell(24).setCellValue("ArretBus");
		header.createCell(25).setCellValue("NumCarteClub");
		header.createCell(26).setCellValue("NumLicence");
		header.createCell(27).setCellValue("Certificat");
		header.createCell(28).setCellValue("Montant");
		header.createCell(29).setCellValue("Solde");
		header.createCell(30).setCellValue("Commentaire");
		header.createCell(31).setCellValue("Etat");
 
		int rowNum = 2;
        Iterator<Adherent> i = lesAd.iterator();
        while(i.hasNext()){
        	Adherent a;
        	a = (Adherent) i.next();
            Iterator<Licencie> j = a.getLicencies().iterator();
	            while(j.hasNext()){
	            	Licencie li = (Licencie) j.next();
	    			HSSFRow row = sheet.createRow(rowNum++);
	    			row.createCell(0).setCellValue(li.getId());
	    			row.createCell(1).setCellValue(li.getNom());
	    			row.createCell(2).setCellValue(li.getPrenom());
	    			row.createCell(3).setCellValue(li.getPereUername());
	    			row.createCell(4).setCellValue(li.getDateDeCreation());
	    			row.createCell(5).setCellValue(a.getTelFix1());
	    			row.createCell(6).setCellValue(a.getTelFix2());
	    			row.createCell(7).setCellValue(a.getTelBur1());
	    			row.createCell(8).setCellValue(a.getTelBur2());
	    			row.createCell(9).setCellValue(a.getTelMob1());
	    			row.createCell(10).setCellValue(a.getTelMob2());
	    			row.createCell(11).setCellValue(a.geteMail1());
	    			row.createCell(12).setCellValue(a.geteMail2());
	    			row.createCell(13).setCellValue(a.getRue1());
	    			row.createCell(14).setCellValue(a.getCp1());
	    			row.createCell(15).setCellValue(a.getVille1());
	    			row.createCell(16).setCellValue(a.getContactSecondaireEst());
	    			row.createCell(17).setCellValue(li.getSexe());
	    			row.createCell(18).setCellValue(li.getNaissance());
	    			row.createCell(19).setCellValue(li.getLicenceType());
	    			row.createCell(20).setCellValue(li.getNiveau());
	    			row.createCell(21).setCellValue(li.getNiveauValide());
	    			row.createCell(22).setCellValue(li.getForfaitType());
	    			row.createCell(23).setCellValue(li.getSeances());
	    			row.createCell(24).setCellValue(li.getArretBus());
	    			row.createCell(25).setCellValue(li.getNumCarteClub());
	    			row.createCell(26).setCellValue(li.getNumLicence());
	    			row.createCell(27).setCellValue(li.isCertificat());
	    			row.createCell(28).setCellValue(li.getMontant());
	    			row.createCell(29).setCellValue(li.getSolde());
	    			row.createCell(30).setCellValue(li.getCommentaire());
	    			row.createCell(31).setCellValue(li.getStatus());
	            }
        }
	}

}
