package org.franck.focski.web;

import org.apache.log4j.Logger;
import org.franck.focski.modele.Adherent;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class FormAdherentValidator implements Validator {
  
  private static final Logger logger =
      Logger.getLogger(FormAdherentValidator.class);
  
  @SuppressWarnings("rawtypes")
  public boolean supports(Class candidate) {

    return Adherent.class.isAssignableFrom(candidate);
  }
  
  public void validate(Object obj, Errors errors) {

    logger.debug("Validation du formulaire de creation");
    /* Verification que certains champs sont non vide */
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom",
        "error.field.required", "Field is required.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom",
        "error.field.required", "Field is required.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eMail1",
        "error.field.required", "Field is required.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rue1",
        "error.field.required", "Field is required.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ville1",
        "error.field.required", "Field is required.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cp1",
        "error.field.required", "Field is required.");
    
    /* Verification du format des adresses eMail */
    String email = ((Adherent) obj).geteMail1();
    logger.debug("Validation de l'adresse : " + email);
    if (!verifFormatMail(email)) {
      errors.rejectValue("eMail1", "error.email.bad.format", null,
          "Re-Saisir adresse");
    }
    email = ((Adherent) obj).geteMail2();
    if ((null != email) & (email != "")) {
      logger.debug("Validation de l'adresse : " + email);
      if (!verifFormatMail(email)) {
        errors.rejectValue("eMail2", "error.email.bad.format", null,
            "Re-Saisir adresse");
      }
    }
    
    /* Verification format du CP */
    String cp = ((Adherent) obj).getCp1();
    logger.debug("Validation du code postal : " + cp);
    if (!verifFormatCp(cp)) {
      errors.rejectValue("cp1", "error.cp.bad.format", null,
          "Re-Saisir le code postal");
    }
    cp = ((Adherent) obj).getCp2();
    if ((null != cp) & (cp != "")) {
      logger.debug("Validation du code postal : " + cp);
      if (!verifFormatCp(cp)) {
        errors.rejectValue("cp2", "error.cp.bad.format", null,
            "Re-Saisir le code postal");
      }
    }
  }
  
  private boolean verifFormatCp(String cp) {

    cp = cp.toLowerCase();
    String charOk = "ab0123456789";
    boolean test = false;
    if (cp.length() != 5) {
      return false;
    }// Si le CP n'est pas constitue de 5 chiffres
     // Si l'email contient un caractere interdit
    for (int i = 0; i < cp.length(); i++) {
      for (int j = 0; j < charOk.length(); j++) {
        if ((cp.charAt(i)) == (charOk.charAt(j))) {
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
    return test;
  }
  
  private boolean verifFormatMail(String email) {

    email = email.toLowerCase();
    String charOk = "abcdefghijklmnopqrstuvwxyz0123456789_-@.";
    boolean test = false;
    if (email.length() < 8) {
      return false;
    }// Si l'email fait moins de 8 caract�res
    if (email.indexOf('@') < 0) {
      return false;
    }// Si l'email ne contient pas d'@'
    if (email.indexOf('.') < 0) {
      return false;
    }// Si l'email ne contient pas de '.'
    if (((email.indexOf('.', (((email.indexOf('@')) + 1))))) == (email.indexOf('@') + 1)) {
      return false;
    }// Si l'email as un '.' apres l'@
    if (((email.indexOf('.', (((email.indexOf('@')) - 1))))) == (email.indexOf('@') - 1)) {
      return false;
    }// Si l'email as un '.' avant l'@
    if ((email.indexOf('.')) == 0) {
      return false;
    }// Si l'email as un '.' au debut
    if ((email.charAt((email.length() - 1)) == '.')) {
      return false;
    }// Si l'email a un '.' a la fin
    if ((email.indexOf('@')) == 0) {
      return false;
    }// Si l'email as un '@' au debut
    if ((email.charAt((email.length() - 1)) == '@')) {
      return false;
    }// Si l'email a un '@' a la fin
     // Si l'email n'a pas de '.' un peu apres le '@'
    boolean tmp = false;
    for (int i = 1; i < (email.length() - (email.indexOf('@'))); i++) {
      if (email.charAt((email.indexOf('@')) + i) == '.') {
        tmp = true;
        i = (email.length());
      }
    }
    if (tmp == false) {
      return false;
    }
    // Si l'email a plusieurs '@'
    for (int i = 0; i < email.length(); i++) {
      if (email.charAt(i) == '@') {
        for (int j = i + 1; j < email.length(); j++) {
          if (email.charAt(j) == '@') {
            return false;
          }
        }
      }
    }
    // Si l'email a 2 '.' d'affil�
    for (int i = 0; i < (email.length() - 1); i++) {
      if ((email.charAt(i) == '.') && (email.charAt(i + 1) == '.')) {
        return false;
      }
    }
    // Si l'email contient un caract�re interdis
    for (int i = 0; i < email.length(); i++) {
      for (int j = 0; j < charOk.length(); j++) {
        if ((email.charAt(i)) == (charOk.charAt(j))) {
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
    return test;
  }
}
