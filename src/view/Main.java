package view;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import view.EnseignantVue;

public class Main {

	private static EnseignantVue enseignant;
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		enseignant = new EnseignantVue();
		enseignant.setVisible(true);
	}

}
