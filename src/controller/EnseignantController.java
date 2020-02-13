package controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

import model.transaction.EnseignantTransaction;
import view.EnseignantVue;

public class EnseignantController extends EnseignantTransaction {
	public static DefaultTableModel dtm;
	
	@SuppressWarnings("rawtypes")
	public static void updateList() {
		
		ArrayList list = readall();
		Iterator i = list.iterator();
		
		while (i.hasNext()) {
			EnseignantVue.addRow((int) i.next());
		}
	}
	
	public static void create(int matricule, String nom, String prenom, String adresse) {
		EnseignantTransaction e = new EnseignantTransaction();
		e.setMatricule(matricule);
		e.setNom(nom);
		e.setPrenom(prenom);
		e.setAdresse(adresse);
		e.create();
	}
	
	public static EnseignantTransaction read(int id) {
		EnseignantTransaction e = new EnseignantTransaction();
		e.setId(id);
		e.read();
		return e;
	}
	
	public static void update(int id, int matricule, String nom, String prenom, String adresse) {
		EnseignantTransaction e = new EnseignantTransaction();
		e.setId(id);
		e.setMatricule(matricule);
		e.setNom(nom);
		e.setPrenom(prenom);
		e.setAdresse(adresse);
		e.update();
	}
	
	public static void delete(int id) {
		EnseignantTransaction e = new EnseignantTransaction();
		e.setId(id);
		e.delete();
	}
}
