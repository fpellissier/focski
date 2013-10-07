package org.franck.focski.dao;

import java.util.List;

import org.franck.focski.modele.Adherent;

public interface ItfAdherentEngine {
	public abstract Adherent read(String username);
	public abstract Adherent read(String nom, String prenom);
	public abstract void create(Adherent a);
	public abstract void delete(String username);
	public abstract void update(Adherent a);
	public abstract void updateDonneesAdmin(Adherent a);
	public abstract List<Adherent> getAllAdherents();
  public abstract Adherent searchAdByEmail(String eMail);
}
