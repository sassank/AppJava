package controleur;


public class Membre
{
	private int id;
	private String mail,motdepasse,pseudo,droits;
	
	
public Membre (int id, String mail, String motdepasse, String pseudo, String droits) { //prendre un article de la BDD, j'ai un ID car il est a
		
		this.id = id;
		this.mail = mail;
		this.motdepasse = motdepasse;
		this.pseudo = pseudo;
		this.droits=droits;
		

}
		
		public Membre (String mail, String motdepasse, String pseudo, String droits) {//il n'a pas d'iD, quand on veut inserer un nvl article dans la BDD
			
			this.id = 0;
			this.mail = mail;
			this.motdepasse = motdepasse;
			this.pseudo = pseudo;
			this.droits = droits;
		}
	public Membre () {
			
			this.id = 0;  //id par defaut permettant de tout initialiser
			this.mail = "";
			this.motdepasse = "";
			this.pseudo = "";
			this.droits = "";
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getDroits() {
		return droits;
	}

	public void setDroits(String droits) {
		this.droits = droits;
	}

	
	
}
