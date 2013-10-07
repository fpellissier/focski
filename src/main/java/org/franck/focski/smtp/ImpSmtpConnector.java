package org.franck.focski.smtp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.franck.focski.modele.Adherent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class ImpSmtpConnector implements ItfSmtpConnector {
  
  @Autowired
  private MailSender mailSender;
  
  @Autowired
  private SimpleMailMessage mailMessage;
  
  private static final Logger LOGGER = Logger.getLogger(ImpSmtpConnector.class);
  
  /**
   * {@inheritDoc}
   */
  public void sendNotificationCreateAccount(Adherent ad) {

    String subject = "[focski] Votre compte a bien ete cree";
    String content =
        "Bonjour "
            + ad.getPrenom()
            + " "
            + ad.getNom()
            + ",\n"
            + "Veuillez trouver ci-dessous certaines de vos coordonnees enregistrees\n"
            + "Vous pouvez à tout moment changer et modifier vos donnees sur le site\n"
            + "Pour cela noter vos données d'identification :\nVotre identifiant :"
            + ad.getDataUser().getLogin() + "\nVotre mot de passe : "
            + ad.getDataUser().getPasswd()
            + "\n\n*****************\nVotre eMail: " + ad.geteMail1()
            + "\nVotre téléphone à la maison: " + ad.getTelFix1()
            + "\nVotre téléphone mobile: " + ad.getTelMob1()
            + "\nVotre adresse: " + ad.getRue1() + " " + ad.getCp1() + " "
            + ad.getVille1();
    
    sendNotification(ad.geteMail1(), subject, content);
  }
  
  /**
   * {@inheritDoc}
   */
  public void sendToAherentConnexionInfo(String mail, String login, String pwd) {

    String subject = "[focski] Information sur votre compte";
    String content =
        "Bonjour,\n"
            + "Veuillez trouver ci-dessous vos donnees de connexion sur votre compte.\n"
            + "Vous pouvez a tout moment changer et modifier vos donnees sur le site\n"
            + "Pour cela noter vos donnees d'identification :\nVotre identifiant :"
            + login + "\nVotre mot de passe : " + pwd
            + "\n\n*****************A tres bientot.";
    
    sendNotification(mail, subject, content);
  }
  
  /**
   * {@inheritDoc}
   */
  public void sendNotificationValidationLicence(String mail, String nom,
      String prenom) {

    String subject = "[focski] Validation d'une licence";
    String content =
        "Bonjour,\n" + "La licence de " + prenom + " " + nom
            + " a ete validees par le club."
            + "Vous pouvez consulter toutes les informations sur le site\n"
            + "\n\n*****************A tres bientot sur la neige !!!.";
    
    sendNotification(mail, subject, content);
  }
  
  /**
   * Envoi d'un mail sur l'adresse fournie
   * 
   * @param mailAdress l'adresse sur laquelle il faut envoyer le mail
   * @param subject le sujet du mail à envoyer
   * @param content le corps du mail à envoyer
   */
  protected void sendNotification(String mailAdress, String subject,
      String content) {

    if (isMailFieldOK(mailAdress) && isMailFieldOK(mailMessage.getFrom())) {
      LOGGER.info("Envoi d'un message sur l'adresse " + mailAdress
          + " avec le sujet " + subject + "le message " + content);
      
      SimpleMailMessage msg = new SimpleMailMessage(mailMessage);
      msg.setSubject(subject);
      msg.setTo(mailAdress);
      msg.setText(content);
      try {
        mailSender.send(msg);
      } catch (MailException me) {
        LOGGER.warn("Problème technique lors de l'envoi du mail de notification");
        LOGGER.warn(me.getMessage(), me.getCause());
      }
    } else {
      LOGGER.info("Le message a: " + mailAdress + ", n'a pas été envoyer");
    }
  }

  private static boolean isMailFieldOK(String mail) {

    String masque = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$";
    
    Pattern pattern = Pattern.compile(masque);
    Matcher controler = pattern.matcher(mail.toUpperCase());
    
    if (controler.matches()) {
      LOGGER.debug("Le format d'adresse est correct pour: " + mail);
      return true;
    }
    LOGGER.debug("Mauvais format de l'adresse: " + mail
        + "; ne respecte pas le masque" + masque);
    return false;
  }
 
  /*
   * GETTERS and SETTERS
   */
  public MailSender getMailSender() {

    return mailSender;
  }
  
  public void setMailSender(MailSender mailSender) {

    this.mailSender = mailSender;
  }
  
  public SimpleMailMessage getMailMessage() {

    return mailMessage;
  }
  
  public void setMailMessage(SimpleMailMessage mailMessage) {

    this.mailMessage = mailMessage;
  } 
}
