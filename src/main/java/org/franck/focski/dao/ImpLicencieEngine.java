package org.franck.focski.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import org.franck.focski.modele.Licencie;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class ImpLicencieEngine extends SimpleJdbcDaoSupport implements
    ItfLicencieEngine {
  
  private static final Logger logger =
      Logger.getLogger(ImpAdherentEngine.class);
  
  public void create(Licencie l) {

    logger.info("ImpLicencieEngine : creation de " + l.getNom() + " "
        + l.getPrenom());
    // La cle primaire est auto generee par la BDD
    // positionne la date de creation
    l.setDateDeCreation(System.currentTimeMillis());
    
    try {
      getSimpleJdbcTemplate().update(
          "INSERT INTO t_licencies SET date_creation=:date_creation,username=:username,nom=:nom,prenom=:prenom,sexe=:sexe,naissance=:naissance,typelicence=:typelicence,niveau=:niveau,niveauvalide=:niveauvalide,skiousurf=:skiousurf,typeforfait=:typeforfait,arretbus=:arretbus,seance=:seance,numCarteclub=:numCarteclub,numFFS=:numFFS,certif=:certif,status=:status,montant=:montant,solde=:solde,commentaire=:commentaire",
          new MapSqlParameterSource().addValue("date_creation",
              l.getDateDeCreation()).addValue("username", l.getPereUername()).addValue(
              "nom", l.getNom()).addValue("prenom", l.getPrenom()).addValue(
              "sexe", l.getSexe()).addValue("naissance", l.getNaissance()).addValue(
              "typelicence", l.getLicenceType()).addValue("niveau",
              l.getNiveau()).addValue("niveauvalide", l.getNiveauValide()).addValue(
              "skiousurf", l.getSkiOUsurf()).addValue("typeforfait",
              l.getForfaitType()).addValue("arretbus", l.getArretBus()).addValue(
              "seance", l.getSeances()).addValue("numCarteclub",
              l.getNumCarteClub()).addValue("numFFS", l.getNumLicence()).addValue(
              "certif", l.isCertificat()).addValue("status", l.getStatus()).addValue(
              "montant", l.getMontant()).addValue("solde", l.getSolde()).addValue(
              "commentaire", l.getCommentaire()));
      
    } catch (DataAccessException e) {
      logger.error("Insert licence erreur " + e);
    }
  }
  
  public void delete(int idl) {

    logger.info("ImpLicencieEngine : suppression du licencie avec id=" + idl);
    
    try {
      getSimpleJdbcTemplate().update("DELETE FROM t_licencies WHERE idl=:idl",
          new MapSqlParameterSource().addValue("idl", idl));
      
    } catch (DataAccessException e) {
      logger.error("delete licencie erreur " + e);
    }
  }
  
  public Licencie read(int idl) {

    List<Licencie> lesLicencies = null;
    logger.debug("Read adherent with idl=" + idl);
    try {
      String sqlQuery = "SELECT * FROM t_licencies AS t WHERE t.idl = :idl";
      lesLicencies =
          getSimpleJdbcTemplate().query(sqlQuery, new LicencieMapper(),
              new MapSqlParameterSource().addValue("idl", idl));
    } catch (DataAccessException e) {
      e.printStackTrace();
    }
    if (lesLicencies.size() != 1) {
      logger.error("Nombre de licencie est different de 1 : "
          + lesLicencies.size());
      // throws exeception LicencieNotFound a definir
    } else {
      logger.debug("Found Adherent number= " + lesLicencies.size());
    }
    logger.debug("READ licencie by idl : " + "\t\n nom : "
        + lesLicencies.get(0).getNom() + "\t\n prenom : "
        + lesLicencies.get(0).getPrenom() + "\t\n ida : "
        + lesLicencies.get(0).getId() + "\t\n naissance : "
        + lesLicencies.get(0).getNaissance() + "\t\n sexe : "
        + lesLicencies.get(0).getSexe() + "\t\n niveau declare : "
        + lesLicencies.get(0).getNiveau() + "\t\n niveau valide : "
        + lesLicencies.get(0).getNiveauValide() + "\t\n skiousurf : "
        + lesLicencies.get(0).getSkiOUsurf() + "\t\n arretbus : "
        + lesLicencies.get(0).getArretBus() + "\t\n seance : "
        + lesLicencies.get(0).getSeances() + "\t\n typelicence : "
        + lesLicencies.get(0).getLicenceType() + "\t\n typeforfait : "
        + lesLicencies.get(0).getForfaitType() + "\t\n numCarteclub : "
        + lesLicencies.get(0).getNumCarteClub() + "\t\n numFFS : "
        + lesLicencies.get(0).getNumLicence() + "\t\n certif : "
        + lesLicencies.get(0).isCertificat() + "\t\n status : "
        + lesLicencies.get(0).getStatus() + "\t\n montant : "
        + lesLicencies.get(0).getMontant() + "\t\n solde : "
        + lesLicencies.get(0).getSolde() + "\t\n commentaire : "
        + lesLicencies.get(0).getCommentaire());
    // return the first one
    return lesLicencies.get(0);
  }
  
  public void update(Licencie newLi) {

    logger.info("ImpLicencieEngine : update de " + newLi.getNom() + " "
        + newLi.getPrenom());
    try {
      getSimpleJdbcTemplate().update(
          "UPDATE t_licencies SET nom=:nom,prenom=:prenom,sexe=:sexe,naissance=:naissance,typelicence=:typelicence,niveau=:niveau,niveauvalide=:niveauvalide,skiousurf=:skiousurf,typeforfait=:typeforfait,arretbus=:arretbus,seance=:seance,numCarteclub=:numCarteclub,numFFS=:numFFS,certif=:certif,status=:status,montant=:montant,solde=:solde,commentaire=:commentaire WHERE idl=:idl",
          new MapSqlParameterSource().addValue("nom", newLi.getNom()).addValue(
              "prenom", newLi.getPrenom()).addValue("sexe", newLi.getSexe()).addValue(
              "naissance", newLi.getNaissance()).addValue("typelicence",
              newLi.getLicenceType()).addValue("niveau", newLi.getNiveau()).addValue(
              "niveauvalide", newLi.getNiveauValide()).addValue("skiousurf",
              newLi.getSkiOUsurf()).addValue("typeforfait",
              newLi.getForfaitType()).addValue("arretbus", newLi.getArretBus()).addValue(
              "seance", newLi.getSeances()).addValue("numCarteclub",
              newLi.getNumCarteClub()).addValue("numFFS", newLi.getNumLicence()).addValue(
              "certif", newLi.isCertificat()).addValue("status",
              newLi.getStatus()).addValue("montant", newLi.getMontant()).addValue(
              "solde", newLi.getSolde()).addValue("commentaire",
              newLi.getCommentaire()).addValue("idl", newLi.getId()));
    } catch (DataAccessException e) {
      logger.error("Update licencie erreur " + e);
    }
  }
  
  public List<Licencie> getAllLicencies() {

    List<Licencie> lesLicencies = null;
    logger.info("Getting All Licencies list");
    
    try {
      String sqlQuery = "SELECT * FROM t_licencies";
      lesLicencies =
          getSimpleJdbcTemplate().query(sqlQuery, new LicencieMapper());
    } catch (DataAccessException e) {
      e.printStackTrace();
    }
    logger.info("Total Nb licencies is = " + lesLicencies.size());
    return lesLicencies;
  }
  
  public List<Licencie> getLicencies(String username) {

    List<Licencie> lesLicencies = null;
    logger.info("Getting Licencies list from adherent username =" + username);
    
    try {
      String sqlQuery =
          "SELECT * FROM t_licencies where t_licencies.username=:username";
      lesLicencies =
          getSimpleJdbcTemplate().query(sqlQuery, new LicencieMapper(),
              new MapSqlParameterSource().addValue("username", username));
    } catch (DataAccessException e) {
      e.printStackTrace();
    }
    logger.info("Nb licencies Found for adherent : " + username + ", is ="
        + lesLicencies.size());
    
    return lesLicencies;
  }
  
  private static class LicencieMapper implements
      ParameterizedRowMapper<Licencie> {
    public Licencie mapRow(ResultSet rs, int rowNum) throws SQLException {

      logger.debug("***");
      Licencie leli = new Licencie();
      leli.setId(rs.getInt("idl"));
      leli.setPereUername(rs.getString("username"));
      leli.setDateDeCreation(rs.getLong("date_creation"));
      leli.setNom(rs.getString("nom"));
      leli.setPrenom(rs.getString("prenom"));
      leli.setNaissance(rs.getString("naissance"));
      leli.setSexe(rs.getString("sexe"));
      leli.setNiveau(rs.getString("niveau"));
      leli.setNiveauValide(rs.getString("niveauvalide"));
      leli.setSkiOUsurf(rs.getString("skiousurf"));
      leli.setArretBus(rs.getString("arretbus"));
      leli.setSeances(rs.getString("seance"));
      leli.setLicenceType(rs.getString("typelicence"));
      leli.setForfaitType(rs.getString("typeforfait"));
      leli.setNumCarteClub(rs.getString("numCarteclub"));
      leli.setNumLicence(rs.getString("numFFS"));
      leli.setCertificat(rs.getBoolean("certif"));
      leli.setStatus(rs.getString("status"));
      leli.setMontant(rs.getFloat("montant"));
      leli.setSolde(rs.getFloat("solde"));
      leli.setCommentaire(rs.getString("commentaire"));
      return leli;
    }
  }
  
  /*
   * <li>Fixer le niveau de ski observ�</li> <li>Renseigner le type de
   * forfait</li> <li>Fournir le num�ro de la licence</li> <li>Fournir le num�ro
   * de la carte club</li> <li>Certificat re�u et valide ?</li> <li>Montant de
   * l'adh�sion(indicatif)</li> <li>Solde (reste � payer)</li> <li>Etat de
   * l'adh�sion</li> <li>Commentaire ou information utile</li> sexe VARCHAR(15),
   * naissance VARCHAR(15), typelicence VARCHAR(50), niveau VARCHAR(50),
   * niveauvalide VARCHAR(50),skiousurf VARCHAR(15), typeforfait VARCHAR(50),
   * arretbus VARCHAR(50), seance VARCHAR(50), numCarteclub VARCHAR(20), numFFS
   * VARCHAR(20), certif BOOLEAN, status VARCHAR(50), montant INT, solde INT,
   * commentaire VARCHAR(255),
   */
  public void updateDonneesAdmin(Licencie li) {

    logger.info("ImpLicencieEngine : update de " + li.getNom() + " "
        + li.getPrenom());
    try {
      getSimpleJdbcTemplate().update(
          "UPDATE t_licencies SET niveauvalide=:niveauvalide,typeforfait=:typeforfait,numCarteclub=:numCarteclub,numFFS=:numFFS,certif=:certif,status=:status,montant=:montant,solde=:solde,commentaire=:commentaire WHERE t_licencies.idl=:idl",
          new MapSqlParameterSource().addValue("niveauvalide",
              li.getNiveauValide()).addValue("typeforfait", li.getForfaitType()).addValue(
              "numCarteclub", li.getNumCarteClub()).addValue("numFFS",
              li.getNumLicence()).addValue("certif", li.isCertificat()).addValue(
              "status", li.getStatus()).addValue("montant", li.getMontant()).addValue(
              "solde", li.getSolde()).addValue("commentaire",
              li.getCommentaire()).addValue("idl", li.getId()));
      
    } catch (DataAccessException e) {
      logger.error("Update licencie erreur " + e);
    }
  }
}
