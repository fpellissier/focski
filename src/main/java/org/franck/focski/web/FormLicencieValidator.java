package org.franck.focski.web;

import org.apache.log4j.Logger;
import org.franck.focski.modele.Licencie;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class FormLicencieValidator implements Validator {
  
  private static final Logger logger =
      Logger.getLogger(FormLicencieValidator.class);
  
  public boolean supports(Class candidate) {

    return Licencie.class.isAssignableFrom(candidate);
  }
  
  public void validate(Object obj, Errors errors) {

    logger.debug("Validation du formulaire de creation");
    
    /* Verification que certains champs sont non vide */
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom",
        "error.field.required", "Field is required.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom",
        "error.field.required", "Field is required.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "naissance",
        "error.field.required", "Field is required.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sexe",
        "error.field.required", "Field is required.");
    // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "licenceType",
    // "error.field.required", "Field is required.");
    
    /* Verification du format de la date de naissance */
    String naissance = ((Licencie) obj).getNaissance();
    if (!verifFormatNaissance(naissance)) {
      errors.rejectValue("naissance", "error.naissance.bad.format", null,
          "Re-Saisir la date");
    }
    
    /* Si Ski loisir alors le champ Niveau doit �tre renseign� */
    // String ski = ((Licencie) obj).getLicenceType();
    // if(ski.contains("loisir")){
    // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "niveau",
    // "error.field.required", "Field is required.");
    // }
  }
  
  private boolean verifFormatNaissance(String naissance) {

    String charOk = "/0123456789";
    boolean test = false;
    if (naissance.length() != 10) {
      return false;
    }// Si naissance n'est pas constitue de 10 lettres
     // Si l'email contient un caractere interdit
    for (int i = 0; i < naissance.length(); i++) {
      for (int j = 0; j < charOk.length(); j++) {
        if ((naissance.charAt(i)) == (charOk.charAt(j))) {
          test = true;
          j = (charOk.length());
        } else {
          test = false;
        }
      }
      if (test == false) {
        return test;
      }
    }
    if (naissance.charAt(2) != charOk.charAt(0)) {
      test = false;
    }
    if (naissance.charAt(5) != charOk.charAt(0)) {
      test = false;
    }
    
    return test;
  }
}
