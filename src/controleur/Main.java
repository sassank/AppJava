package controleur;

import javax.swing.JOptionPane;

import modele.BDD;
import modele.ModeleMembre;
import modele.modele;
import vue.VueConnexion;
import vue.VueGenerale;

public class Main {
	
	private static VueConnexion uneVueConnexion ;
	private static VueGenerale uneVueGenerale;
	
	
	public static void  setVisible (boolean action)
	{
		uneVueConnexion.setVisible(action);
	}

	public static void main(String[] args) 
	{
		uneVueConnexion = new VueConnexion ();
	
	}

	public static void verifConnexion(String mail, String motdepasse)
	{
		if (mail.equals("") || motdepasse.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Veuillez remplir les identifiants !", "Erreur", JOptionPane.ERROR_MESSAGE);
		}else 
		{
			Membre unMembre = ModeleMembre.selectWhereMembre (mail,motdepasse);
			if (unMembre == null)
			{
				JOptionPane.showMessageDialog(null, "Veuillez vérifier les identifiants !", "Erreur", JOptionPane.ERROR_MESSAGE);
			}else
			{
				JOptionPane.showMessageDialog(null, "Bienvenue Mm/M." + unMembre.getPseudo() +  " " + unMembre.getMail(), "Erreur", JOptionPane.INFORMATION_MESSAGE);
				uneVueGenerale = new VueGenerale (unMembre);
				uneVueConnexion.setVisible(false); //on ferme la page de connexion 
			}
		}
	}
}