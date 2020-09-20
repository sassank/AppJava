package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Habitation;
import controleur.Membre;

public class ModeleMembre 
{
	private static BDD uneBdd = new BDD("localhost:8889", "pps11", "root", "root");
	public static ArrayList<Membre> selectAllMembre()
	{
		ArrayList<Membre> lesHabitations = new ArrayList<Membre>();//definit l'arrayList
		String requete = "Select * from habitation;";
		ModeleMembre.uneBdd.seConnecter(); //connexion a la BDD
		
		try
		{
			Statement unStat = ModeleMembre.uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);//pour donner la liste des article
			while (desResultats.next()) //parcourir la liste des résultats & voir si il y a tjr un résultat
			{
				Membre unMembre = new Membre (desResultats.getInt("idmembres"),
									             desResultats.getString("pseudo"),
									             desResultats.getString("mail"),
									             desResultats.getString("motdepasse"),
									        
									             desResultats.getString("droitsenum")
						); //recuperer les infos de la BDD
						lesHabitations.add(unMembre);
			}
			unStat.close();
			desResultats.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur execution : " + requete);
		}
		
		ModeleMembre.uneBdd.seDeconnecter(); //se deconnecter a la BDD
		
		return lesHabitations;
	}
	public static void insertMembre(Membre unMembre)
	{
		String requete ="insert into membres values (null,'" 
				+ unMembre.getPseudo()+" ', "//pour dire qu'il n'y a pas de caractere (' = cote de sql, "=cote de java)
				+ unMembre.getMail()+","
				+ unMembre.getMotdepasse()+"');";
			
				
				
		ModeleMembre.uneBdd.seConnecter ();
				
				try
				{
					Statement unStat = ModeleMembre.uneBdd.getMaConnexion().createStatement();
					unStat.execute(requete);
					unStat.close ();
				}
				catch (SQLException exp)
				{
					System.out.println("Erreur execution :" + requete);
				}
				ModeleMembre.uneBdd.seDeconnecter();
				
				
	}
	
	public static void deleteMembre (int id)
	{
		String requete ="delete from article where idarticle =" + id+";";
		
		ModeleMembre.uneBdd.seConnecter ();
		
		try
		{
			Statement unStat = ModeleMembre.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close ();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur execution :" + requete);
		}
		ModeleMembre.uneBdd.seDeconnecter();
	}
	public static void updateUser (Membre unMembre) {
		String requete = "update membres set mail ='"
				+ unMembre.getMail() +"', motdepasse = '"
			    + unMembre.getMotdepasse() +"', pseudo= '"
			    + unMembre.getPseudo() +"', nom ='"
			    + unMembre.getDroits()+"' where idmembres ="
			    + unMembre.getId()+";";
		ModeleMembre.uneBdd.seConnecter();
		try {
		Statement unStat = ModeleMembre.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		}catch(SQLException exp) {
		System.out.println("Erreur execution : " + requete);
		}
		ModeleMembre.uneBdd.seDeconnecter();
	}
	public static Membre selectWhereMembre(String mail, String motdepasse)
	{
		Membre unMembre= null;//on cree un user
		String requete = "select * from membres where mail='" + mail +"' and motdepasse='"+ motdepasse +"' ;";
		ModeleMembre.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleMembre.uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next())
			{
				unMembre = new Membre 
						      (
						    		  unRes.getInt("idmembres"),
						    		  unRes.getString("mail"),
						    		  unRes.getString("motdepasse"),
						    		  unRes.getString("pseudo"),
						    		
						    		  unRes.getString("droits")
								
								
								);
			}
			unStat.close();
			unRes.close();
		}
		catch  (SQLException exp)
		{
			System.out.println("Erreur execution :" +requete);
		}
		ModeleMembre.uneBdd.seDeconnecter();
		return unMembre;
		
				}
}

