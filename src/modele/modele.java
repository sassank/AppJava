package modele;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controleur.Habitation;



public class modele 


{
	private static BDD uneBdd = new BDD("localhost:8889", "pps11", "root", "root");
	
	public static ArrayList<Habitation> selectAllHabitations ()
	{
		ArrayList<Habitation> lesHabitations = new ArrayList<Habitation>();//definit l'arrayList
		String requete = "Select * from habitation ;";
		modele.uneBdd.seConnecter(); //connexion a la BDD
		
		try
		{
			Statement unStat = modele.uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);//pour donner la liste des article
			while (desResultats.next()) //parcourir la liste des résultats & voir si il y a tjr un résultat
			{
				Habitation uneHabitation  = new Habitation (desResultats.getInt("idh"),
									             desResultats.getString("nomh"),
									             desResultats.getString("adrh"),
									             desResultats.getInt("numeroh"),
									             desResultats.getInt("cph"),
									             desResultats.getString("villeh")
						); //recuperer les infos de la BDD
						lesHabitations.add(uneHabitation);
			}
			unStat.close();
			desResultats.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur execution : " + requete);
		}
		
		modele.uneBdd.seDeconnecter(); //se deconnecter a la BDD
		
		return lesHabitations;
	}
		
	public static void insertHabitation(Habitation uneHabitation)
	{
		String requete ="insert into article values (null,'" 
						+ uneHabitation.getNomh()+" ',' "//pour dire qu'il n'y a pas de caractere (' = cote de sql, "=cote de java)
						+ uneHabitation.getAdrh()+"',"
						+ uneHabitation.getNumeroh()+","
						+ uneHabitation.getCph()+",'"
						+ uneHabitation.getVilleh()+"');";
						
						modele.uneBdd.seConnecter ();
						
						try
						{
							Statement unStat = modele.uneBdd.getMaConnexion().createStatement();
							unStat.execute(requete);
							unStat.close ();
						}
						catch (SQLException exp)
						{
							System.out.println("Erreur execution :" + requete);
						}
						modele.uneBdd.seDeconnecter();
						
						
	}
	
	public static void deleteHabitation(int idH)
	{
		String requete ="delete from article where idarticle =" + idH+";";
				
				modele.uneBdd.seConnecter ();
				
				try
				{
					Statement unStat = modele.uneBdd.getMaConnexion().createStatement();
					unStat.execute(requete);
					unStat.close ();
				}
				catch (SQLException exp)
				{
					System.out.println("Erreur execution :" + requete);
				}
				modele.uneBdd.seDeconnecter();
				
	}
	
	public static void updateHabitation (Habitation uneHabitation)
	{
		String requete ="update habitation set designation =' " 
						+uneHabitation.getNomh()+"',adrh= '"
						+ uneHabitation.getAdrh()+"', numeroh = "
						+ uneHabitation.getNumeroh () +", cph= "
						+ uneHabitation.getCph() + " where idh="
						+ uneHabitation.getVilleh() +";";
						
						
						
						modele.uneBdd.seConnecter ();
		
		try
		{
			Statement unStat = modele.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close ();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur execution :" + requete);
		}
		modele.uneBdd.seDeconnecter();
	}

	public static Habitation selectWhereHabitation(Habitation uneHabitation) {
		Habitation uneH = null;
		String requete = "select idh from habitation where " + " nomh = '"+uneHabitation.getNomh()
																+ "' and adrh = '"+uneHabitation.getAdrh()
																+"' and numeroh = "+uneHabitation.getNumeroh()
																+" and cph = "+uneHabitation.getCph()
																+ " and villeh = '"+uneHabitation.getVilleh()+"';";
		modele.uneBdd.seConnecter();
		try {
			Statement unSat = modele.uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unSat.executeQuery(requete);
			if (unRes.next())
			{
				uneH = new Habitation (unRes.getInt("idh"),
					  uneHabitation.getNomh(),
					  uneHabitation.getAdrh(), uneHabitation.getNumeroh(),
					  uneHabitation.getCph(),
					  uneHabitation.getVilleh());
						
			}
			}
		catch (SQLException exp)
		{
			System.out.println("Erreur requete : " +requete);
		}
		modele.uneBdd.seDeconnecter();
		return uneH;
	}
}
