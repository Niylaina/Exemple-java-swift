package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.EnseignantController;
import view.EnseignantVue;


@SuppressWarnings("serial")
public class AjoutEnseignant extends JFrame implements ActionListener{
	private static JTextField matriculeText;
	private static JTextField nomText;
	private static JTextField prenomText;
	private static JTextField adresseText;
	private static JButton ajoutBtn;
	private static JButton backBtn;
	private static JLabel matriculeLabel;
	private static JLabel nomLabel;
	private static JLabel prenomLabel;
	private static JLabel adresseLabel;
	private static EnseignantVue enseignant;
	
	
	public AjoutEnseignant(){
		super("Ajout");
		JPanel formulaire = (JPanel) this.getContentPane();
		formulaire.setLayout(null);
		this.setSize(300, 400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		matriculeLabel = new JLabel("Matricule: ");
		nomLabel = new JLabel("Nom: ");
		prenomLabel = new JLabel("Prenom: ");
		adresseLabel = new JLabel("Adresse: ");
		matriculeText = new JTextField();
		nomText = new JTextField();
		prenomText = new JTextField();
		adresseText = new JTextField();
		ajoutBtn = new JButton("Enregistrer");
		backBtn = new JButton("Retour");
		
		matriculeLabel.setBounds(10, 50, 75, 20);
		nomLabel.setBounds(10, 100, 75, 20);
		prenomLabel.setBounds(10, 150, 75, 20);
		adresseLabel.setBounds(10, 200, 75, 20);
		matriculeText.setBounds(100, 50, 190, 30);
		nomText.setBounds(100, 100, 190, 30);
		prenomText.setBounds(100, 150, 190, 30);
		adresseText.setBounds(100,200,190,30);
		ajoutBtn.setBounds(100, 250, 100, 20);
		backBtn.setBounds(100, 275, 100, 20);
		
		ajoutBtn.addActionListener(this);
		backBtn.addActionListener(this);
		
		formulaire.add(matriculeLabel);
		formulaire.add(nomLabel);
		formulaire.add(prenomLabel);
		formulaire.add(adresseLabel);
		formulaire.add(matriculeText);
		formulaire.add(nomText);
		formulaire.add(prenomText);
		formulaire.add(adresseText);
		formulaire.add(ajoutBtn);
		formulaire.add(backBtn);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		boolean valide = false;
		if (event=="Enregistrer") {
			try {
				Integer.parseInt(matriculeText.getText());
				if ((matriculeText.getText().equals("")) || (nomText.getText().equals("")) || (prenomText.getText().equals("")) || (adresseText.getText().equals(""))) {
					valide = false;	
				}else {
					valide = true;
				}
			} catch (NumberFormatException exc) {
				valide = false;
			}
			if (valide) {
				EnseignantController.create(Integer.parseInt(matriculeText.getText()), nomText.getText(), prenomText.getText(), adresseText.getText());
				JOptionPane.showMessageDialog(null, "Ajouté: "+nomText.getText()+" "+prenomText.getText());
			} else {
				JOptionPane.showMessageDialog(null, "Veuillez vérifier les champs.\n*Matricule est de type entier");
			}
			
		}
		if (event== "Retour") {
			enseignant = new EnseignantVue();
			enseignant.setVisible(true);
			this.dispose();
		}
	}

	
	
}
