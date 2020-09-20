package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;
import controleur.Membre;

public class ModeleClient {

	private static BDD uneBdd = new BDD ("localhost:8889", "pps11", "root", "root");
	
	public static ArrayList<Client> SelectAllClients(){
		ArrayList<Client> lesClients = new ArrayList<Client>();
		String requete = "Select * from client ;";
		//On se connecte à la base de données
		ModeleClient.uneBdd.seConnecter();
		try {
			//On définit un statement
			Statement unStat = ModeleClient.uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat= unStat.executeQuery(requete); 
			while(unResultat.next()) {
				 Client unClient = new Client(
						unResultat.getInt("idC"),
						unResultat.getString("nomc"),
						unResultat.getString("prenomc"),
						unResultat.getString("adrc"),
						unResultat.getInt("cpc"),
						unResultat.getString("villec"),
						unResultat.getInt("datenaissc")
						);
				lesClients.add(unClient);
			}
			unStat.close();
			unResultat.close();
		}catch(SQLException exp) {
			System.out.println("Erreur execution : " + requete);
		}
		ModeleClient.uneBdd.seDeconnecter();		
		return lesClients;
	}
	
	public static void insertClient(Client unClient) {
		String requete = "insert into client values (null,'"
				+ unClient.getNomc()+"','"
				+ unClient.getPrenomc()+"','"
				+ unClient.getAdrc()+"','"
				+ unClient.getCpc()+"','"
				+ unClient.getVillec()+"','"
				+ unClient.getDatenaissc()+"');";
		 	ModeleClient.uneBdd.seConnecter();
			try {
			Statement unStat = ModeleClient.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			}catch(SQLException exp) {
			System.out.println("Erreur execution : " + requete);
			}
			ModeleClient.uneBdd.seDeconnecter();
	}

	public static void deleteClient(int idC) {
		String requete = "delete from client where idC=" + idC +";";
		ModeleClient.uneBdd.seConnecter();
		try {
		Statement unStat = ModeleClient.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		}catch(SQLException exp) {
		System.out.println("Erreur execution : " + requete);
		}
		ModeleClient.uneBdd.seDeconnecter();
	}
	
	public static void updateClient(Client unClient) {
		String requete = "update client set nomc ='"
				+ unClient.getNomc() +"', prenomc = '"
			    + unClient.getPrenomc() +"', adrc = '"
			    + unClient.getAdrc() +"', cpc ='"
			    + unClient.getCpc()+"', villec = '"
			    + unClient.getVillec()+"' where datnaissc ="
			    + unClient.getDatenaissc()+"', tel = '"
			    + unClient.getIdC()+";";
		ModeleClient.uneBdd.seConnecter();
		try {
		Statement unStat = ModeleClient.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		}catch(SQLException exp) {
		System.out.println("Erreur execution : " + requete);
		}
		ModeleClient.uneBdd.seDeconnecter();
	}
	
	public static ArrayList<Client> SelectWhereClient (String mot){
		ArrayList<Client> lesClients = new ArrayList<Client>();
		String requete = "select * from client where nomc like '%"+mot+"%' " + "or prenomc like '%"+ mot + "%' "
						 + "or adrc like '%"+ mot + "%' "
						 + "or cpc like '%"+ mot + "%' "
						 + "or villec like '%"+ mot + "%' "
						+ "or datenaissc like '%"+ mot + "%'"+";";
		ModeleClient.uneBdd.seConnecter();
		try {
			Statement unStat = ModeleClient.uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while (unRes.next()) {
				Client unClient = new Client(
						unRes.getInt("idC"),
						unRes.getString("nomc"),
						unRes.getString("prenomc"),
						unRes.getString("adrc"),
						unRes.getInt("cpc"),
						unRes.getString("villec"),
						unRes.getInt("datenaissc")
						
						);
				lesClients.add(unClient);
			}
		unStat.close();
		unRes.close();
		}catch(SQLException exp) {
			System.out.println("Erreur execution : " + requete);
	}
	ModeleClient.uneBdd.seDeconnecter();		
	return lesClients;
	}
}
