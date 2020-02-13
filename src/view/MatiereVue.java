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

import controller.MatiereController;
import model.entity.MatiereEntite;
import view.AjoutMatiere;
import view.EnseignantVue;

@SuppressWarnings("serial")
public class MatiereVue extends JFrame implements ActionListener, TableModelListener {
	
	public static JTable table;
	private JButton addBtn;
	private JButton delBtn;
	private JButton backBtn;
	private static DefaultTableModel dtm;
	private static AjoutMatiere ajout;
	private static EnseignantVue enseignantV;
	
	private int ens;
	
	public MatiereVue(int enseignant) {
		super("Matières");
		JPanel mainPanel = (JPanel) this.getContentPane();
		
		JPanel fenetre = new JPanel();
		fenetre.setLayout(null);
		
		addBtn = new JButton("Ajouter");
		delBtn = new JButton("Effacer");
		backBtn = new JButton("Retour");
		
		table = new JTable();
		dtm = new DefaultTableModel(new String[] {"Id", "Intitulé", "Volume horaire total", "Volume horaire TP et TD"}, 0);
		
		addBtn.setBounds(600,125,100,50);
		delBtn.setBounds(600,250,100,50);
		backBtn.setBounds(600, 450, 100, 50);
		table.setBounds(0,0,550,650);
		

		JScrollPane sp= new JScrollPane(table);
		sp.setBounds(0,0,550,650);
		
		fenetre.add(sp);
		fenetre.add(addBtn);
		fenetre.add(delBtn);
		fenetre.add(backBtn);
		
		mainPanel.add(fenetre);

		this.setSize(750, 650);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
		backBtn.addActionListener(this);
		ens = enseignant;
		MatiereController.updateList(ens);
		table.setModel(dtm);

		dtm.addTableModelListener(this);

		
	}
	
	public static void addRow(int id) {
		MatiereEntite m = new MatiereEntite();
		m = MatiereController.read(id);
		dtm.addRow(new Object[] {
			m.getId(),
			m.getIntitule(),
			m.gethT(),
			m.gethP(),
		});
		table.setModel(dtm);
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		MatiereController.update((int) table.getValueAt(row, 0), table.getValueAt(row, 1).toString(), Integer.parseInt(table.getValueAt(row, 2).toString()), Integer.parseInt(table.getValueAt(row, 3).toString()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String event = e.getActionCommand();
		if (event=="Ajouter") {
			ajout = new AjoutMatiere(ens);
			ajout.setVisible(true);
			this.dispose();
		} else if (event == "Effacer"){
			try {
				int row = table.getSelectedRow();
				MatiereController.delete((int) table.getValueAt(row, 0));
				MatiereVue matiere = new MatiereVue(ens);
				matiere.setVisible(true);
				this.dispose();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Veuillez choisir une matière!");
			}
			
		} else if (event == "Retour"){
			enseignantV = new EnseignantVue();
			enseignantV.setVisible(true);
			this.dispose();
		}
	}

}
