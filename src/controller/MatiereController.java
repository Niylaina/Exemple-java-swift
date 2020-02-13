package controller;

import java.util.ArrayList;
import java.util.Iterator;

import model.transaction.MatiereTransaction;
import view.MatiereVue;;

public class MatiereController extends MatiereTransaction {
	@SuppressWarnings("rawtypes")
	public static void updateList(int enseignant) {
		
		ArrayList list = readall(enseignant);
		Iterator i = list.iterator();
		
		while (i.hasNext()) {
			MatiereVue.addRow((int) i.next());
		}
	}
	
	public static void create(String intitule, int hT, int hP, int enseignant) {
		MatiereTransaction m = new MatiereTransaction();
		m.setIntitule(intitule);
		m.sethT(hT);
		m.sethP(hP);
		m.setEnseignant(enseignant);
		m.create();
	}
	
	public static MatiereTransaction read(int id) {
		MatiereTransaction m = new MatiereTransaction();
		m.setId(id);
		m.read();
		return m;
	}
	
	public static void update(int id, String intitule, int hT, int hP) {
		MatiereTransaction m = new MatiereTransaction();
		m.setId(id);
		m.setIntitule(intitule);
		m.sethT(hT);
		m.sethP(hP);
		m.update();
	}
	
	public static void delete(int id) {
		MatiereTransaction m = new MatiereTransaction();
		m.setId(id);
		m.delete();
	}
	
}
