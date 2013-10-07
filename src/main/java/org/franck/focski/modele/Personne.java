package org.franck.focski.modele;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;

public abstract class Personne {
  
  private static final Logger logger = Logger.getLogger(Personne.class);
  
  private final String DATE_CREATION_FORMAT = "dd-MM-yyyy";
  
  private int id;
  private String nom;
  private String prenom;
  private long dateDeCreation;
  private String sDateDeCreation;
  
  public Personne() {

    super();
    logger.debug("Personne Constructor (super())");
  }
  
  public int getId() {

    return id;
  }
  
  public void setId(int id) {

    this.id = id;
  }
  
  public String getNom() {

    return nom;
  }
  
  public void setNom(String nom) {

    this.nom = nom;
  }
  
  public String getPrenom() {

    return prenom;
  }
  
  public void setPrenom(String prenom) {

    this.prenom = prenom;
  }
  
  public long getDateDeCreation() {

    return dateDeCreation;
  }
  
  public void setDateDeCreation(long dateDeCreation) {

    this.dateDeCreation = dateDeCreation;
    
    this.sDateDeCreation = DateFormatUtils.format(dateDeCreation, DATE_CREATION_FORMAT);
  }

  /**
   * @param sDateDeCreation the sDateDeCreation to set
   */
  public void setsDateDeCreation(String sDateDeCreation) {

    this.sDateDeCreation = sDateDeCreation;

    SimpleDateFormat format = new SimpleDateFormat(DATE_CREATION_FORMAT); 
    try {
      this.dateDeCreation = format.parse(sDateDeCreation).getTime();
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * @return the sDateDeCreation
   */
  public String getsDateDeCreation() {

    return sDateDeCreation;
  }
}
