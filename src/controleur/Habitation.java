package controleur;

public class Habitation 

{
	private int idh;
	private String nomh;
	private String adrh ;
	private int numeroh;
	private int cph;
	private String villeh;
	
	
	public Habitation(int idh, String nomh, String adrh, int numeroh, int cph, String villeh) { //prendre un article de la BDD, j'ai un ID car il est a
		
		this.idh = idh;
		this.nomh = nomh;
		this.numeroh = numeroh;
		this.cph = cph;
		this.villeh = villeh;}
		
		public Habitation (String nomh, String adrh, int numeroh, String cph, String villeh) {//il n'a pas d'iD, quand on veut inserer un nvl article dans la BDD
			
			this.idh= 0;
			this.nomh= nomh;
			this.adrh = adrh;
			this.numeroh = numeroh;
			this.cph = 0;
			this.villeh = villeh;
		}
	public Habitation () {
			
			this.idh = 0;  //id par defaut permettant de tout initialiser
			this.nomh = "";
			this.adrh = "";
			this.numeroh = 0;
			this.cph = 0;
			this.villeh = "";
		}

	public int getIdh() {
		return idh;
	}

	public void setIdh(int idh) {
		this.idh = idh;
	}

	public String getNomh() {
		return nomh;
	}

	public void setNomh(String nomh) {
		this.nomh = nomh;
	}

	public String getAdrh() {
		return adrh;
	}

	public void setAdrh(String adrh) {
		this.adrh = adrh;
	}

	public int getNumeroh() {
		return numeroh;
	}

	public void setNumeroh(int numeroh) {
		this.numeroh = numeroh;
	}

	public int getCph() {
		return cph;
	}

	public void setCph(int cph) {
		this.cph = cph;
	}

	public String getVilleh() {
		return villeh;
	}

	public void setVilleh(String villeh) {
		this.villeh = villeh;
	}

	
	
}
