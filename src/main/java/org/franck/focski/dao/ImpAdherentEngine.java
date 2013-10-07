package org.franck.focski.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.franck.focski.modele.Adherent;
import org.franck.focski.modele.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

/**
 * @author fiup6266
 * 
 */
public class ImpAdherentEngine extends SimpleJdbcDaoSupport implements
		ItfAdherentEngine {

	private static final Logger logger = Logger
			.getLogger(ImpAdherentEngine.class);
	private static final String ROLE_ADHERENT = "ROLE_ADHERENT";

	public void create(Adherent a) {
		logger.info("ImpAdherent : creation de " + a.getNom() + " "
				+ a.getPrenom());

		try {
			// creation de l'entree dans les tables users et authorities
			// par defaut, le username est "fpellissier" et le mot de passe est
			// le prenom
			// User user = new User(a.getPrenom().substring(0, 1).toLowerCase()
			// + a.getNom().toLowerCase(), a.getPrenom().toLowerCase(),
			// ROLE_ADHERENT, true);
			int index = a.geteMail1().indexOf("@");
			User user = new User(a.geteMail1().substring(0, index).toLowerCase(),
					a.getPrenom().toLowerCase(), ROLE_ADHERENT,
					true);
			getSimpleJdbcTemplate()
					.update(
							"INSERT INTO users SET username=:username,password=:password,enabled=:enabled",
							new MapSqlParameterSource().addValue("username",
									user.getLogin()).addValue("password",
									user.getPasswd()).addValue("enabled",
									user.isAccessEnabled()));

			getSimpleJdbcTemplate()
					.update(
							"INSERT INTO authorities SET username=:username,authority=:authority",
							new MapSqlParameterSource().addValue("username",
									user.getLogin()).addValue("authority",
									user.getRole()));

			// La cle primaire est auto generee par la BDD
			// positionne la date de creation
			a.setDateDeCreation(System.currentTimeMillis());

			getSimpleJdbcTemplate()
					.update(
							"INSERT INTO t_adherents SET date_creation=:date_creation,username=:username," +
							"nom1=:nom1,prenom1=:prenom1,tel1=:tel1,mob1=:mob1,telbur1=:telbur1,mail1=:mail1,rue1=:rue1,ville1=:ville1,cp1=:cp1," +
							"nom2=:nom2,prenom2=:prenom2,tel2=:tel2,mob2=:mob2,telbur2=:telbur2,mail2=:mail2,rue2=:rue2,ville2=:ville2,cp2=:cp2," +
							"contact2is=:contact2is,commentaire=:commentaire",
							new MapSqlParameterSource().addValue(
									"date_creation", a.getDateDeCreation())
									.addValue("username", user.getLogin())
									.addValue("nom1", a.getNom())
									.addValue("prenom1", a.getPrenom())
									.addValue("tel1", a.getTelFix1())
									.addValue("mob1", a.getTelMob1())
									.addValue("telbur1", a.getTelBur1())
									.addValue("mail1", a.geteMail1())
									.addValue("rue1", a.getRue1())
									.addValue("cp1",a.getCp1())
									.addValue("ville1",a.getVille1())
                  .addValue("nom2", a.getNom2())
                  .addValue("prenom2", a.getPrenom2())
									.addValue("tel2", a.getTelFix2())
									.addValue("mob2", a.getTelMob2())
									.addValue("telbur2", a.getTelBur2())
									.addValue("mail2", a.geteMail2())
                  .addValue("rue2", a.getRue2())
                  .addValue("cp2",a.getCp2())
                  .addValue("ville2",a.getVille2())
									.addValue("contact2is",a.getContactSecondaireEst())
									.addValue("commentaire", a.getCommentaire()));
		} catch (DataAccessException e) {
			logger.error("Insert adherent erreur " + e);
		}
	}

	public void delete(String username) {
		logger.info("ImpAdherent : suppression de " + username);

		try {
			// supp de l entree dans la tables users
			// la supp de lentree dans autorities et adherent est assuree par
			// mysql
			getSimpleJdbcTemplate().update(
					"DELETE FROM users WHERE username=:username",
					new MapSqlParameterSource().addValue("username", username));
		} catch (DataAccessException e) {
			logger.error("Delete adherent erreur " + e);
		}
	}

	public List<Adherent> getAllAdherents() {
		List<Adherent> lesAdherents = null;
		logger.debug("Getting adherents list !");
		try {
			lesAdherents = getSimpleJdbcTemplate()
					.query(
							"SELECT * FROM t_adherents AS t,authorities AS a, users AS u WHERE t.username=a.username AND t.username=u.username",
							new AdherentMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lesAdherents;
	}

	private static class AdherentMapper implements
			ParameterizedRowMapper<Adherent> {
		public Adherent mapRow(ResultSet rs, int rowNum) throws SQLException {
			logger.debug("***");
			Adherent a = new Adherent();
			User u = new User();
			a.setId(rs.getInt("ida"));
			a.setDateDeCreation(rs.getLong("date_creation"));
			a.setNom(rs.getString("nom1"));
			a.setPrenom(rs.getString("prenom1"));
			a.setTelFix1(rs.getString("tel1"));
			a.setTelBur1(rs.getString("telbur1"));
			a.setTelMob1(rs.getString("mob1"));
			a.seteMail1(rs.getString("mail1"));
			a.setRue1(rs.getString("rue1"));
			a.setVille1(rs.getString("ville1"));
			a.setCp1(rs.getString("cp1"));
      a.setNom2(rs.getString("nom2"));
      a.setPrenom2(rs.getString("prenom2"));
			a.setTelFix2(rs.getString("tel2"));
			a.setTelMob2(rs.getString("mob2"));
			a.setTelBur2(rs.getString("telbur2"));
			a.seteMail2(rs.getString("mail2"));
      a.setRue2(rs.getString("rue2"));
      a.setVille2(rs.getString("ville2"));
      a.setCp2(rs.getString("cp2"));
      a.setContactSecondaireEst(rs.getString("contact2is"));
			a.setCommentaire(rs.getString("commentaire"));
			u.setLogin(rs.getString("username"));
			u.setPasswd(rs.getString("password"));
			u.setRole(rs.getString("authority"));
			u.setAccessEnabled(rs.getBoolean("enabled"));
			a.setDataUser(u);
			return a;
		}
	}

	public Adherent read(String username) {
		List<Adherent> lesAdherents = null;
		logger.debug("Read adherent with: " + username);
		try {
			String sqlQuery = "SELECT * FROM t_adherents AS t, users AS u, authorities AS a WHERE t.username=u.username AND t.username=a.username AND u.username = :username";
			lesAdherents = getSimpleJdbcTemplate().query(sqlQuery,
					new AdherentMapper(),
					new MapSqlParameterSource().addValue("username", username));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if (lesAdherents.size() != 1) {
			logger.error("Nombre Adherent est different de 1 : "
					+ lesAdherents.size());
			// throws exeception UsernameNotFound a definir
		} else {
			logger.debug("Found Adherent number= " + lesAdherents.size());
		}
		logger.debug("READ adherent by username : "
				+ "\t\n nom : " + lesAdherents.get(0).getNom()
				+ "\t\n prenom : " + lesAdherents.get(0).getPrenom()
				+ "\t\n ida : "	+ lesAdherents.get(0).getId()
				+ "\t\n telMaison1 : " + lesAdherents.get(0).getTelFix1()
				+ "\t\n mob1 : " + lesAdherents.get(0).getTelMob1()
				+ "\t\n telBureau1 : " + lesAdherents.get(0).getTelBur1()
				+ "\t\n rue cp ville : " + lesAdherents.get(0).getRue1() + lesAdherents.get(0).getCp1()+ lesAdherents.get(0).getVille1() 
        + "\t\n nom2 : " + lesAdherents.get(0).getNom2()
        + "\t\n prenom2 : " + lesAdherents.get(0).getPrenom2()
				+ "\t\n telMaison2 : " + lesAdherents.get(0).getTelFix2()
				+ "\t\n mob2 : " + lesAdherents.get(0).getTelMob2()
				+ "\t\n telBureau2 : " + lesAdherents.get(0).getTelBur2()
        + "\t\n rue cp ville : " + lesAdherents.get(0).getRue2() + lesAdherents.get(0).getCp2()+ lesAdherents.get(0).getVille2() 
				+ "\t\n ContactSecIs : " + lesAdherents.get(0).getContactSecondaireEst()
				+ "\t\n username : " + lesAdherents.get(0).getDataUser().getLogin()
				+ "\t\n password : " + lesAdherents.get(0).getDataUser().getPasswd()
				+ "\t\n role : " + lesAdherents.get(0).getDataUser().getRole()
				+ "\t\n enabled : "	+ lesAdherents.get(0).getDataUser().isAccessEnabled());
		// return the first one
		return lesAdherents.get(0);
	}

	public Adherent read(String nom, String prenom) {
		List<Adherent> lesAdherents = null;
		logger.debug("Read adherent with: " + nom + " " + prenom);
		try {
			String sqlQuery = 
			  "SELECT * FROM t_adherents AS t, users AS u, authorities AS a WHERE t.username=u.username AND t.username=a.username AND t.nom1 = :nom1 AND t.prenom1 = :prenom1";
			lesAdherents = getSimpleJdbcTemplate().query(
					sqlQuery,
					new AdherentMapper(),
					new MapSqlParameterSource().
					addValue("nom1", nom).
					addValue("prenom1", prenom));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if (lesAdherents.size() != 1) {
			logger.error("Nombre Adherent est different de 1 : "
					+ lesAdherents.size());
			// throws exception UsernameNotFound a definir
		} else {
			logger.debug("Found Adherent number= " + lesAdherents.size());
		}
    logger.debug("READ adherent by username : "
        + "\t\n nom : " + lesAdherents.get(0).getNom()
        + "\t\n prenom : " + lesAdherents.get(0).getPrenom()
        + "\t\n ida : " + lesAdherents.get(0).getId()
        + "\t\n telMaison1 : " + lesAdherents.get(0).getTelFix1()
        + "\t\n mob1 : " + lesAdherents.get(0).getTelMob1()
        + "\t\n telBureau1 : " + lesAdherents.get(0).getTelBur1()
        + "\t\n rue cp ville : " + lesAdherents.get(0).getRue1() + lesAdherents.get(0).getCp1()+ lesAdherents.get(0).getVille1() 
        + "\t\n nom2 : " + lesAdherents.get(0).getNom2()
        + "\t\n prenom2 : " + lesAdherents.get(0).getPrenom2()
        + "\t\n telMaison2 : " + lesAdherents.get(0).getTelFix2()
        + "\t\n mob2 : " + lesAdherents.get(0).getTelMob2()
        + "\t\n telBureau2 : " + lesAdherents.get(0).getTelBur2()
        + "\t\n rue cp ville : " + lesAdherents.get(0).getRue2() + lesAdherents.get(0).getCp2()+ lesAdherents.get(0).getVille2() 
        + "\t\n ContactSecIs : " + lesAdherents.get(0).getContactSecondaireEst()
        + "\t\n username : " + lesAdherents.get(0).getDataUser().getLogin()
        + "\t\n password : " + lesAdherents.get(0).getDataUser().getPasswd()
        + "\t\n role : " + lesAdherents.get(0).getDataUser().getRole()
        + "\t\n enabled : " + lesAdherents.get(0).getDataUser().isAccessEnabled());
		// return the first one
		return lesAdherents.get(0);
	}

	/*
	 * Change que les donnees de la table adherent
	 */
	public void update(Adherent new_ad) {
		logger.info("ImpAdherentEngine : update de " + new_ad.getNom() + " "+ new_ad.getPrenom());
		try {
			getSimpleJdbcTemplate()
					.update(
							"UPDATE t_adherents SET nom1=:nom1,prenom1=:prenom1,tel1=:tel1,mob1=:mob1,telbur1=:telbur1,mail1=:mail1,rue1=:rue1,ville1=:ville1,cp1=:cp1," +
							"nom2=:nom2,prenom2=:prenom2,tel2=:tel2,mob2=:mob2,telbur2=:telbur2,mail2=:mail2,rue2=:rue2,ville2=:ville2,cp2=:cp2," +
							"contact2is=:contact2is,commentaire=:commentaire WHERE t_adherents.username=:username",
							new MapSqlParameterSource()
							.addValue("nom1",new_ad.getNom())
							.addValue("prenom1",new_ad.getPrenom())
							.addValue("tel1",new_ad.getTelFix1())
							.addValue("mob1",new_ad.getTelMob1())
							.addValue("telbur1",new_ad.getTelBur1())
							.addValue("mail1",new_ad.geteMail1())
							.addValue("rue1",new_ad.getRue1())
							.addValue("cp1",new_ad.getCp1())
							.addValue("ville1",new_ad.getVille1())
              .addValue("nom2",new_ad.getNom2())
              .addValue("prenom2",new_ad.getPrenom2())
							.addValue("tel2",new_ad.getTelFix2())
							.addValue("mob2",new_ad.getTelMob2())
							.addValue("telbur2",new_ad.getTelBur2())
							.addValue("mail2",new_ad.geteMail2())
              .addValue("rue2",new_ad.getRue2())
              .addValue("cp2",new_ad.getCp2())
              .addValue("ville2",new_ad.getVille2())
							.addValue("contact2is",new_ad.getContactSecondaireEst())
							.addValue("commentaire",new_ad.getCommentaire())
							.addValue("username",new_ad.getDataUser().getLogin()));
		} catch (DataAccessException e) {
			logger.error("Insert adherent erreur " + e);
		}
	}
	/*
	 * Change que les donnees de la table User et Autorities
	 */
	public void updateDonneesAdmin(Adherent a) {
		logger.info("ImpAdherentEngine : update de " + a.getNom() + " "+ a.getPrenom());
		try {
			getSimpleJdbcTemplate().update(
							"UPDATE users SET password=:password,enabled=:enabled WHERE users.username=:username",
							new MapSqlParameterSource()
							.addValue("password",a.getDataUser().getPasswd())
							.addValue("enabled",a.getDataUser().isAccessEnabled())
							.addValue("username",a.getDataUser().getLogin()));
			getSimpleJdbcTemplate().update(
					"UPDATE authorities SET authority=:authority WHERE authorities.username=:username",
					new MapSqlParameterSource()
					.addValue("authority",a.getDataUser().getRole())
					.addValue("username",a.getDataUser().getLogin()));

			getSimpleJdbcTemplate().update(
					"UPDATE t_adherents SET commentaire=:commentaire WHERE t_adherents.username=:username",
					new MapSqlParameterSource()
					.addValue("commentaire",a.getCommentaire())
					.addValue("username",a.getDataUser().getLogin()));
		} catch (DataAccessException e) {
			logger.error("Update adherent erreur " + e);
		}
	}

  public Adherent searchAdByEmail(String eMail) {

    List<Adherent> lesAdherents = null;
    logger.debug("Search adherent with: " + eMail);
    try {
      String sqlQuery = "SELECT * FROM t_adherents AS t, users AS u, authorities AS a WHERE t.username=u.username AND t.username=a.username AND (t.mail1 = :mail OR t.mail2 = :mail)";
      lesAdherents = getSimpleJdbcTemplate().query(sqlQuery,
          new AdherentMapper(),
          new MapSqlParameterSource().addValue("mail", eMail));
    } catch (DataAccessException e) {
      e.printStackTrace();
    }
    if (lesAdherents.size() != 1) {
      logger.error("Nombre Adherent est different de 1 : "
          + lesAdherents.size());
      return null;
      // throws exeception UsernameNotFound a definir
    } else {
      logger.debug("1 Adherent a été trouvé: " + lesAdherents.get(0).getNom());
    }
    return lesAdherents.get(0);
  }
}
