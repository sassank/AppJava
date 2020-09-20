package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import controleur.Main;
import controleur.Membre;


public class VueGenerale extends JFrame implements ActionListener


{
	private JButton btQuitter = new JButton ("Quitter");
	private JPanel panelProfil = new JPanel ();
	private static 	PanelAjout unPanelAjout = new PanelAjout ();
	private JButton btAjouter = new JButton ("Ajouter");
	private static PanelLister unPanelLister = new PanelLister ();
	private JButton btLister = new JButton ("Lister");
	
	private JButton btClient = new JButton ("Clients");
	private PanelClient unPanelClient = new PanelClient ();
	
	public VueGenerale (Membre unMembre)
	{
	
		
		this.setTitle("Administration Neige et Soleil");
		this.setBounds(100, 100, 800, 550);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.white);
		
		//ajout des panels
		this.add (unPanelAjout);
		
		this.btClient.setBounds(500, 10, 80, 40);
		this.add(this.btClient);
		this.btClient.addActionListener(this);
		this.add(this.unPanelClient);
		
		this.btAjouter.setBounds(250, 20, 100, 30);
		this.add(this.btAjouter);
		this.btAjouter.addActionListener(this);
		
		this.btLister.setBounds(370, 20, 100, 30);
		this.add(this.btLister);// on l'ajoute
		this.btLister.addActionListener(this);//on rend le bouton cliquable
		
		this.add(unPanelLister);
		
		
		//construction du panel profil
		this.panelProfil.setBounds(40, 40, 200, 200);
		this.panelProfil.setBackground(Color.white);
		this.panelProfil.setLayout(new GridLayout(6,1));
		this.panelProfil.add(new JLabel("Votre Profil :"));
		
		this.panelProfil.add(new JLabel("Votre prenom :" + unMembre.getPseudo()));
		this.panelProfil.add(new JLabel("Votre email :" + unMembre.getMail()));
		this.panelProfil.add(new JLabel("Votre mot de passe :" + unMembre.getMotdepasse()));
		this.panelProfil.add(new JLabel("Vous avez les droits  :" + unMembre.getDroits()));
		
		this.add(this.panelProfil);
		
		
		this.btQuitter.setBounds(650, 470, 100, 40);
		this.add(this.btQuitter);
		this.btQuitter.addActionListener((ActionListener) this);
		
		this.setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == this.btQuitter)
		{
			this.dispose();
			Main.setVisible(true);
			
		}else if (e.getSource() == this.btAjouter)
		{
			unPanelAjout.setVisible(true);
			unPanelLister.setVisible(false);
			unPanelClient.setVisible(false);
		}
		else if (e.getSource() == this.btLister)
		{
			unPanelAjout.setVisible(false);
			unPanelLister.setVisible(true);
			unPanelClient.setVisible(false);
		
		}
		else if (e.getSource() == this.btClient)
		{
			unPanelClient.setVisible(true);
			unPanelAjout.setVisible(false);
			unPanelLister.setVisible(false);
		}
	
	}
}
