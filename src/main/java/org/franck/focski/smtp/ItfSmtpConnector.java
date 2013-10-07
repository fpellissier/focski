package org.franck.focski.smtp;

import org.franck.focski.modele.Adherent;

public interface ItfSmtpConnector {

  /**
   * Envoi d'un mail de notification lors de la création d'un compte focski
   * @param mailAdress l'adresse sur laquelle il faut envoyer le mail
   */
  public void sendNotificationCreateAccount(Adherent ad);

  public void sendToAherentConnexionInfo(String mail, String login, String pwd);

  public void sendNotificationValidationLicence(String geteMail1, String nom,
      String prenom);

}
