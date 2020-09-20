package vue;

import java.awt.Color;
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

import controleur.Client;
import controleur.Tableau;
import modele.ModeleClient;

public class PanelClient extends Panel implements ActionListener

{
	private JTable uneTable;
	private Tableau unTableau;
	private JPanel unPanelAjout = new JPanel ();
	private JTextField txtidC = new JTextField ();
	private JTextField txtnomc = new JTextField ();
	private JTextField txtprenomc = new JTextField ();
	private JTextField txtadrc = new JTextField ();
	private JTextField txtcpc = new JTextField ();
	private JTextField txtvillec = new JTextField ();
	private JTextField txtdatenaissc = new JTextField ();
	private JButton btAnnuler = new JButton ("Annuler");
	private JButton btAjouter = new JButton ("Ajouter");
	private JButton btModifier = new JButton ("Modifier");
	private JButton btSupprimer = new JButton ("Supprimer");
	private JButton btOk = new JButton ("Ok");
	private JTextField txtMot = new JTextField ();
	private JPanel unPanelRecherche = new JPanel ();
	private JPanel unPanelBoutons = new JPanel ();

	
	
	
	public PanelClient ()
	{
		super ();
		this.setBackground(Color.white);
		String entetes []= {"Id Client", "Nom", "Prenom", "Adresse", "Email", "Telephone"};
		unTableau = new Tableau (this.getLesClients(ModeleClient.SelectAllClients()), entetes);
		uneTable = new JTable (unTableau);
		JScrollPane uneScroll = new JScrollPane(uneTable);
		uneScroll.setBounds(20, 20, 460, 150);
		this.add(uneScroll);
		
		//Construction du panel recherche
		this.unPanelRecherche.setLayout(new GridLayout (1,3));
		this.unPanelRecherche.add(new JLabel ("Filtre par colonnes :"));
		this.unPanelRecherche.add(txtMot);
		this.unPanelRecherche.add(btOk);
		this.unPanelRecherche.setBounds(100, 170, 200, 30);
		this.add(unPanelRecherche);
		
		
		//construction du panel ajouter
		this.unPanelAjout.setLayout(new GridLayout (4,4));
		
		this.txtidC.setEditable(false); //il n'est pas editable , il s'affiche mais on ne peut le toucher
		
		this.unPanelAjout.add(new JLabel ("Id Client :"));
		this.unPanelAjout.add(txtidC);
		
		this.unPanelAjout.add(new JLabel ("Nom:"));
		this.unPanelAjout.add(txtnomc);
		
		this.unPanelAjout.add(new JLabel ("Prenom:"));
		this.unPanelAjout.add(txtprenomc);
		
		
		this.unPanelAjout.add(new JLabel ("Adresse :"));
		this.unPanelAjout.add(txtadrc);
		
		this.unPanelAjout.add(new JLabel ("Code postal :"));
		this.unPanelAjout.add(txtcpc);
		
		
		this.unPanelAjout.add(new JLabel ("Ville :"));
		this.unPanelAjout.add(txtvillec);
		
		this.unPanelAjout.add(new JLabel ("Date naiss :"));
		this.unPanelAjout.add(txtdatenaissc);
		
		
		
		this.unPanelAjout.setBounds(19, 240, 470, 90);
		this.add(this.unPanelAjout);
		
		
		
		//construction du panel Bouttons
		this.unPanelBoutons.setLayout(new GridLayout (1,2));
		this.unPanelBoutons.setBounds(17,360, 460, 30);
		this.unPanelBoutons.add(this.btAnnuler);
		this.unPanelBoutons.add(this.btAjouter);
		this.unPanelBoutons.add(this.btModifier);
		this.unPanelBoutons.add(this.btSupprimer);
		this.add(this.unPanelBoutons);
		this.btAnnuler.addActionListener(this);
		this.btAjouter.addActionListener(this);
		this.btModifier.addActionListener(this);
		this.btSupprimer.addActionListener(this);
	
		
	
		
		
		this.btOk.addActionListener(this);
		
		uneTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne = uneTable.getSelectedRow();
				txtidC.setText((int)uneTable.getValueAt(ligne, 0)+ "");
				txtnomc.setText((String)uneTable.getValueAt(ligne, 1));
				txtprenomc.setText((String)uneTable.getValueAt(ligne, 2));
				txtadrc.setText((String)uneTable.getValueAt(ligne, 3));
				txtcpc.setText((String)uneTable.getValueAt(ligne, 3));
				txtvillec.setText((String)uneTable.getValueAt(ligne, 0));
				txtdatenaissc.setText((String)uneTable.getValueAt(ligne, 0));
				
				
			}
		});
		
		
	}
	
	
	public Object [][] getLesClients (ArrayList<Client> lesClients)
	{
		
		Object [] [] matrice = new Object [lesClients.size()][6];
		int i=0;
		for (Client unClient : lesClients)
		{
					
				matrice[i][0] = unClient.getIdC();
				matrice[i][1] = unClient.getNomc();
				matrice[i][2] = unClient.getPrenomc();
				matrice[i][3] = unClient.getAdrc ();
				matrice[i][4] = unClient.getVillec ();
				matrice[i][5] = unClient.getDatenaissc();
				i++;
														
		}return matrice;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btOk)
		{
			String mot = this.txtMot.getText();
			Object [] [] matrice = this.getLesClients(ModeleClient.SelectWhereClient(mot));
			unTableau.setDonnees (matrice);
			
		}else if  (e.getSource() == this.btAnnuler)
		{
			txtidC.setText("");
			txtnomc.setText("");
			txtprenomc.setText("");
			txtadrc.setText("");
			txtcpc.setText("");
			txtvillec.setText("");
			txtdatenaissc.setText("");
		}
		else if (e.getSource() == this.btAjouter)
		{
			Client unClient = new Client (
					txtnomc.getText(),
					txtprenomc.getText(),
					txtadrc.getText(),
					txtcpc.getText(),
					txtvillec.getText(),
					txtdatenaissc.getText());
			ModeleClient.insertClient(unClient);
			Object ligne []= { unClient.getIdC(),
							unClient.getNomc(),
							unClient.getPrenomc(),
							unClient.getAdrc (),
							unClient.getCpc(),
							unClient.getVillec(),
							unClient.getDatenaissc()
			};
			unTableau.insertTable(ligne);
			JOptionPane.showMessageDialog(this, "Insertion réussie", "Insertion d'un client", JOptionPane.INFORMATION_MESSAGE);
			txtnomc.setText("");
			txtprenomc.setText("");
			txtadrc.setText("");
			txtcpc.setText("");
			txtvillec.setText("");
			txtdatenaissc.setText("");
		}
		else if (e.getSource() == this.btModifier)
		{
			int idc = Integer.parseInt(txtidC.getText ());
			Client unClient = new Client (
					txtnomc.getText(),
					txtprenomc.getText(),
					txtadrc.getText(),
					txtcpc.getText(),
					txtvillec.getText(),
					txtdatenaissc.getText());
			
			ModeleClient.updateClient(unClient);
			Object ligne []= { unClient.getIdC(),
					unClient.getNomc(),
					unClient.getPrenomc(),
					unClient.getAdrc (),
					unClient.getCpc(),
					unClient.getVillec(),
					unClient.getDatenaissc()};
					int indiceLigne = uneTable.getSelectedRow();
					unTableau.updateTable(ligne, indiceLigne);
			}
		else if (e.getSource() == this.btSupprimer)
		{
			int idC  = Integer.parseInt(txtidC.getText());
			ModeleClient.deleteClient(idC);
			int indiceLigne = uneTable.getSelectedRow();
			unTableau.deleteTable(indiceLigne);
		}
	}
	
}
