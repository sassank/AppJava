package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import controleur.Main;

public class VueConnexion extends JFrame implements ActionListener, KeyListener {

		private JPanel unPanel = new JPanel();
		private JTextField txtEmail = new JTextField();
		private JPasswordField txtMdp = new JPasswordField();
		private JButton btAnnuler = new JButton("Annuler");
		private JButton btSeconnecter = new JButton("Se connecter");
		private JMenuBar barre = new JMenuBar();
		private JMenu menuNeige = new JMenu("Neige et Soleil");
		private JMenu menuPreferences = new JMenu("Preferences");
		private JMenuItem itemQuitter = new JMenuItem ("Quitter");
		private JMenuItem itemGeneral = new JMenuItem ("General");
		public VueConnexion() {
			
			this.setTitle("Neige et Soleil");
			this.setResizable(false);
			this.setBounds(200, 200, 700, 300);
			this.setLayout(null);
			this.getContentPane().setBackground(Color.white);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.unPanel.setBounds(300, 40, 350, 200);
			this.unPanel.setBackground(Color.WHITE);
			this.unPanel.setLayout(new GridLayout (3, 2));
			
			JLabel lbEmail = new JLabel ("Email :");
			lbEmail.setForeground(new Color(58,193,242));
			this.unPanel.add(lbEmail);
			this.unPanel.add(this.txtEmail);
			
			
			JLabel lbMdp = new JLabel ("MDP :");
			lbMdp.setForeground(new Color(58,193,242));
			this.unPanel.add(lbMdp);
			
			
			this.unPanel.add(this.txtMdp);
			this.unPanel.add(this.btAnnuler);
			this.unPanel.add(this.btSeconnecter);
			this.add(this.unPanel);
			
			//Changement de la police des objets graphiques du panel
			Font unePolice = new Font ("Arial", Font.ITALIC, 20);
			for(int i = 0 ; i<this.unPanel.getComponentCount(); i++)
			{
				this.unPanel.getComponent(i).setFont(unePolice);
			}
			//Rendre les boutons cliquables
			this.btAnnuler.addActionListener(this);
			this.btSeconnecter.addActionListener(this);
			
			//Rendre les textes ecoutables
			this.txtEmail.addKeyListener(this);
			this.txtMdp.addKeyListener(this);
			
			//insertion de l'image
			ImageIcon uneImage = new ImageIcon ("src/images/neige.png");
			JLabel monImage = new JLabel (uneImage);
			
			
			monImage.setBounds(30, 40, 200, 200);
			this.add(monImage);
			
			
			this.menuNeige.add(this.itemQuitter);
			
			
			
			this.menuPreferences.add(itemGeneral);
			this.menuPreferences.addActionListener(this);
			this.itemQuitter.addActionListener(this);
			this.itemGeneral.addActionListener(this);
			
			this.barre.add(this.menuNeige);
			this.barre.add(this.menuPreferences);
			this.setJMenuBar(this.barre);
		
			
			this.setVisible(true);
		}

		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
				//Permet de switcher selon ce qui est écrit sur le button et non pas le button lui-même
			case "Annuler" : this.txtEmail.setText("");
							 this.txtMdp.setText("");
							 break;
			case "Se connecter" : 
							String email = this.txtEmail.getText();
							String mdp = new String (this.txtMdp.getPassword());
							Main.verifConnexion (email,mdp);
							break;
			}if(e.getSource() == this.itemQuitter) {
				int retour = JOptionPane.showConfirmDialog(this, 
						"Voulez-vous quitter l'application ?", 
						"Quitter l'application", JOptionPane.YES_NO_OPTION);
						if (retour == 0) {
							this.dispose();
							
						}
			}else if (e.getSource() == this.itemGeneral) {
				JOptionPane.showMessageDialog(this, "En cours de réalisation"
						+"\n Dispo avant fin 2019, "
						+" en utilisant le framework Swing,"
						+"par la société Neige et Soleil"
						+"\n Paris, Tous droit réservé à IRIS",
						"Aide sur le logiciel",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
			
			
		
		
		}


		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				String email = this.txtEmail.getText();
				String mdp = new String (this.txtMdp.getPassword());
				Main.verifConnexion (email,mdp);
			}
		}


		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}


		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
}
