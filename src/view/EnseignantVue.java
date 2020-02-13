package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import controller.EnseignantController;
import model.entity.EnseignantEntite;
import view.AjoutEnseignant;
import view.MatiereVue;

@SuppressWarnings("serial")
public class EnseignantVue extends JFrame implements ActionListener, TableModelListener {

	public static JTable table;
	private JButton addBtn;
	private JButton delBtn;
	private JButton mBtn;
	private static DefaultTableModel dtm;
	private static AjoutEnseignant ajout;
	private static MatiereVue matiere;
	
	public EnseignantVue() {
		super("Andrianina Rajoeliarijery");
		JPanel mainPanel = (JPanel) this.getContentPane();
		
		JPanel fenetre = new JPanel();
		fenetre.setLayout(null);
		
		addBtn = new JButton("Ajouter");
		delBtn = new JButton("Effacer");
		mBtn = new JButton("Matières");
		
		table = new JTable();
		dtm = new DefaultTableModel(new String[] {"Id", "Matricule", "Nom", "Prenom", "Adresse"}, 0);
		
		addBtn.setBounds(500,125,100,50);
		delBtn.setBounds(500,250,100,50);
		mBtn.setBounds(500, 450, 100, 50);
		table.setBounds(0,0,450,650);
		

		JScrollPane sp= new JScrollPane(table);
		sp.setBounds(0,0,450,650);
		
		fenetre.add(sp);
		fenetre.add(addBtn);
		fenetre.add(delBtn);
		fenetre.add(mBtn);
		
		mainPanel.add(fenetre);

		this.setSize(650, 650);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
		mBtn.addActionListener(this);
		
		EnseignantController.updateList();
		table.setModel(dtm);

		dtm.addTableModelListener(this);
		
	}
	
	public static void addRow(int id) {
		
		EnseignantEntite e = new EnseignantEntite();
		e = EnseignantController.read(id);
		dtm.addRow(new Object[] {
				e.getId(),
				e.getMatricule(),
				e.getNom(),
				e.getPrenom(),
				e.getAdresse()
		});
		table.setModel(dtm);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String event = e.getActionCommand();
		if (event=="Ajouter") {
			ajout = new AjoutEnseignant();
			ajout.setVisible(true);
			this.dispose();
		} else if (event == "Effacer"){
			try {
				int row = table.getSelectedRow();
				EnseignantController.delete((int) table.getValueAt(row, 0));
				EnseignantVue enseignant = new EnseignantVue();
				enseignant.setVisible(true);
				this.dispose();
			} catch (Exception exc) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Veuillez choisir une personne!");
			}
			
		} else if (event == "Matières") {
			try {
				int row = table.getSelectedRow();
				int enseignant = (int) table.getValueAt(row, 1);
				matiere = new MatiereVue(enseignant);
				matiere.setVisible(true);
				this.dispose();
			} catch (Exception exc) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Veuillez choisir une personne!");
			}
			
		}
		
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		int row = table.getSelectedRow();
		EnseignantController.update((int) table.getValueAt(row, 0), (int) table.getValueAt(row, 1), table.getValueAt(row, 2).toString(), table.getValueAt(row, 3).toString(), table.getValueAt(row, 4).toString());
	}
	
	

}
