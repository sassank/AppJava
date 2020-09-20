package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controleur.Habitation;
import modele.modele;

public class PanelAjout  extends Panel implements ActionListener

{
 private JTextField txtNomh = new JTextField();
 private JTextField txtAdrh= new JTextField();
 private JTextField txtNumeroh = new JTextField();
 private JTextField txtCph = new JTextField();
 private JTextField txtVilleh = new JTextField();

 
 
 private JButton btAnnuler = new JButton ("Annuler");
 private JButton btEnregistrer = new JButton ("Enregistrer");
 
 
 public PanelAjout ()
 {
	 super ();
	 this.setLayout(new GridLayout(6,1));
	// this.setBounds(260, 115, 352, 95);
	 this.add(new JLabel ("Nom Habitation:"));
	 this.add(this.txtNomh);
	 this.add(new JLabel ("Adresse :"));
	 this.add(this.txtAdrh);
	 this.add(new JLabel ("Numero  :"));
	 this.add(this.txtNumeroh);
	 this.add(new JLabel ("Code postal  :"));
	 this.add(this.txtCph);
	 this.add(new JLabel ("Ville :"));
	 this.add(this.txtVilleh);
	 this.add(this.btAnnuler);
	 this.add(this.btEnregistrer);
	 
	 this.btAnnuler.addActionListener(this);
	 this.btEnregistrer.addActionListener(this);
 }


@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == this.btAnnuler)
	{
		this.txtNomh.setText("");
		this.txtAdrh.setText("");
		this.txtNumeroh.setText("");
		this.txtCph.setText("");
		this.txtVilleh.setText("");
	
		
	}else if (e.getSource() == this.btEnregistrer)
	{
		if (this.txtNomh.getText().equals("")||
				this.txtNomh.getText().equals("")||
				this.txtAdrh.getText().equals("") ||
				this.txtNumeroh.getText().equals("") ||
				this.txtCph.getText().equals("") ||
				this.txtVilleh.getText().equals("")
				)
		{
			JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs !");
		}
		else
		{
			String nomh= this.txtNomh.getText();
			String adrh = this.txtAdrh.getText();
			String villeh = this.txtVilleh.getText();
			int cph = 0;
			int numeroh = 0;
			try 
			{
				numeroh = Integer.parseInt(this.txtNumeroh.getText());
				cph = Integer.parseInt(this.txtCph.getText());
			}
			catch  (NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Erreur sur le format du nombre !");
			}
			if (numeroh >0 && cph>0)
			{
				Habitation uneHabitation = new Habitation (numeroh, nomh, adrh, numeroh , cph, villeh);
				modele.insertHabitation(uneHabitation);//inqertion de larticle dans la BDD
				PanelLister.insertTable(modele.selectWhereHabitation(uneHabitation));
				
				
				JOptionPane.showMessageDialog(this, "Insertion effectué avec succés !", "Information", JOptionPane.INFORMATION_MESSAGE);//affichage de la creation de l'article
				this.txtNomh.setText("");
				this.txtAdrh.setText("");
				this.txtNumeroh.setText("");
				this.txtCph.setText("");
				this.txtVilleh.setText("");
				this.setVisible(false);
			}
			else if (numeroh < 0)
			{
				this.txtNumeroh.setBackground(Color.red);
			} if (cph<0)
			{
				this.txtCph.setBackground(Color.red);
			}
		}
	}
	
}
 
}
