package org.franck.focski.modele;

import java.util.ArrayList;
import java.util.Arrays;

public class LesArretsDeBus {

    private ArrayList<String> listeDesArrets;
    
    
    public ArrayList<String> getListDesArrets() {
        return listeDesArrets;
    }

    public void setLaListeDesArretsDuMercredi(String liste) {

    	this.listeDesArrets = new ArrayList<String>(Arrays.asList(liste.split(",")));
    }
}
