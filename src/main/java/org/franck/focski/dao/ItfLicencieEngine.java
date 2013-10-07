package org.franck.focski.dao;

import java.util.List;

import org.franck.focski.modele.Licencie;

public interface ItfLicencieEngine {
	public abstract Licencie read(int idl);
	public abstract void create(Licencie l);
	public abstract void delete(int idl);
	public abstract void update(Licencie l);
	public abstract List<Licencie> getAllLicencies();
	public abstract List<Licencie> getLicencies(String username);
	public abstract void updateDonneesAdmin(Licencie li);
}