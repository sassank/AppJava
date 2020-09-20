package vue;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import controleur.Habitation;
import controleur.Tableau;
import modele.modele;

public class PanelLister extends Panel implements ActionListener 
{
	private JTable uneTable;
	private static Tableau unTableau;
	private JPanel panelModif = new JPanel ();
	private JTextField txtNomh = new JTextField ();
	private JTextField txtAdrh = new JTextField ();
	private JTextField txtNumeroh = new JTextField ();
	private JTextField txtCph = new JTextField ();
	private JTextField txtVilleh = new JTextField ();
	private JButton btModifier = new JButton ("Modifier");
	
	public PanelLister ()
	{
		super ();
		String entetes[] = {"IdH", "Nomh", "Adrh","Numeroh", "Cph", "Villeh"};
		unTableau = new Tableau (this.getLesDonnees(), entetes);
		
		uneTable = new JTable (unTableau); //JTable a besoin de la matrice des données et des entetes
		JScrollPane uneScroll = new JScrollPane (uneTable);
		uneScroll.setBounds(20, 20, 350, 150);
		this.add(uneScroll);
		uneTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne = uneTable.getSelectedRow();
				if (e.getClickCount () ==1)
				{
					txtNomh.setText((String)uneTable.getValueAt(ligne, 1));
					txtAdrh.setText((String)uneTable.getValueAt(ligne, 2)+"");
					txtNumeroh.setText((int)uneTable.getValueAt(ligne, 3)+"");
					txtCph.setText((int)uneTable.getValueAt(ligne, 4)+"");
					txtVilleh.setText((String)uneTable.getValueAt(ligne, 5));
					txtNomh.setText((String)uneTable.getValueAt(ligne, 1));
				}
				
				
				
				else if (e.getClickCount() == 2)
				{
					
					int idH =(int) uneTable.getValueAt(ligne, 0);//on a l'iD
					int retour = JOptionPane.showConfirmDialog(null, "Voule-vous supprimer l'article", "Suppression Article", JOptionPane.YES_NO_OPTION); //Null car on est deja dans une classe , on peut pas faire this
					if (retour ==0)
					{
						modele.deleteHabitation(idH);
						unTableau.deleteTable(ligne);
					}
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		panelModif.setLayout(new GridLayout(6, 100));
		panelModif.setBounds(19, 170, 352, 90);
		panelModif.add(new JLabel ("Nom :"));
		panelModif.add(txtNomh);
		panelModif.add(new JLabel ("Adresse :"));
		panelModif.add(txtAdrh);
		panelModif.add(new JLabel ("Numero :"));
		panelModif.add(txtNumeroh);
		panelModif.add(new JLabel ("Code postal :"));
		panelModif.add(txtCph);
		panelModif.add(new JLabel ("Ville :"));
		panelModif.add(txtVilleh);
		panelModif.add(new JLabel (""));
		panelModif.add(btModifier);
		this.add(panelModif);	
		
		//rendre le bouton cliquable
		this.btModifier.addActionListener(this);
		
	}
	public Object [] [] getLesDonnees ()  //les crochets pour les matrices, sa va les retourner
	{
		ArrayList<Habitation> lesHabitations = modele.selectAllHabitations();
		Object matrice [] [] = new Object[lesHabitations.size()] [6];
		int i = 0;
		for (Habitation uneH : lesHabitations)
		{
			matrice [i] [0] = uneH.getIdh();
			matrice [i] [1] = uneH.getNomh(); //transforme l'arraylist sous forme de tableau
			matrice [i] [2] = uneH.getAdrh(); 
			matrice [i] [3] = uneH.getNumeroh();
			matrice [i] [4] = uneH.getCph(); 
			matrice [i] [5] = uneH.getVilleh(); 
			i++;
		}
		return matrice;
	}
	public static void insertTable(Habitation uneHabitation) {
	Object ligne []= {uneHabitation.getIdh()
, uneHabitation.getNomh(), uneHabitation.getAdrh(), uneHabitation.getNumeroh(), uneHabitation.getCph(), uneHabitation.getVilleh()};
	unTableau.insertTable(ligne);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
