package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MatiereController;
import view.MatiereVue;

@SuppressWarnings("serial")
public class AjoutMatiere extends JFrame implements ActionListener, EventListener{
	private static JTextField intituleText;
	private static JTextField htText;
	private static JTextField hpText;
	private static JButton ajoutBtn;
	private static JButton backBtn;
	private static JLabel intituleLabel;
	private static JLabel htLabel;
	private static JLabel hpLabel;
	private static MatiereVue matiere;
	private int ens;
	
	
	public AjoutMatiere(int enseignant){
		super("Ajout de matières");
		JPanel formulaire = (JPanel) this.getContentPane();
		formulaire.setLayout(null);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		intituleLabel = new JLabel("Intitulé: ");
		htLabel = new JLabel("Volume horaire total: ");
		hpLabel = new JLabel("Volume horaire TP et TD: ");
		intituleText = new JTextField();
		htText = new JTextField();
		hpText = new JTextField();
		ajoutBtn = new JButton("Enregistrer");
		backBtn = new JButton("Retour");
		
		intituleLabel.setBounds(10, 50, 175, 20);
		htLabel.setBounds(10, 100, 175, 20);
		hpLabel.setBounds(10, 150, 175, 20);
		intituleText.setBounds(200, 50, 190, 30);
		htText.setBounds(200, 100, 190, 30);
		hpText.setBounds(200, 150, 190, 30);
		ajoutBtn.setBounds(150, 250, 100, 20);
		backBtn.setBounds(150, 275, 100, 20);
		
		ajoutBtn.addActionListener(this);
		backBtn.addActionListener(this);
		
		formulaire.add(intituleLabel);
		formulaire.add(htLabel);
		formulaire.add(hpLabel);
		formulaire.add(intituleText);
		formulaire.add(htText);
		formulaire.add(hpText);
		formulaire.add(ajoutBtn);
		formulaire.add(backBtn);
		
		ens = enseignant;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		boolean valide = false;
		if (event=="Enregistrer") {
			try {
				Integer.parseInt(htText.getText());
				Integer.parseInt(hpText.getText());
				if (((intituleText.getText().equals("")) || (htText.getText().equals("")) || (hpText.getText().equals(""))) || (Integer.parseInt(htText.getText()) <= Integer.parseInt(hpText.getText()))){
					valide = false;	
				}else {
					valide = true;
				}
			} catch (NumberFormatException exc) {
				valide = false;
			}
			if (valide) {
				MatiereController.create(intituleText.getText().toString(), Integer.parseInt(htText.getText()), Integer.parseInt(hpText.getText()), ens);
				matiere = new MatiereVue(ens);
				matiere.setVisible(true);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Veuillez vérifier les champs.\n*Les volumes horaires sont de type entier");
			}
		}
		if (event== "Retour") {
			matiere = new MatiereVue(ens);
			matiere.setVisible(true);
			this.dispose();
		}
	}


}
