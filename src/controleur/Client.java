package controleur;

public class Client

{
	private int idC, cpc, datenaissc;
	private String nomc, prenomc, adrc, villec;
	public Client(int idClient, String nomc, String prenomc, String adrc,int cpc,  String villec, int datenaissc) {
		super();
		this.idC = idC;
		this.nomc = nomc;
		this.prenomc = prenomc;
		this.adrc = adrc;
		this.cpc = cpc;
		this.datenaissc = datenaissc;
	}
	
	public Client (String nomc, String prenomc, String adrc,  String villec)
	{
		this.idC= 0;
		this.nomc= nomc;
		this.prenomc = prenomc;
		this.adrc = adrc;
		
		
	}
	
	
	public Client ()
	{
		this.idC = 0;
		this.nomc = "";
		this.prenomc = "";
		this.adrc = "";
		this.cpc = 0;
		this.villec = "";
		this.datenaissc = 0;
	}

	public Client(String text, String text2, String text3, String text4, String text5, String text6) {
		// TODO Auto-generated constructor stub
	}

	public int getIdC() {
		return idC;
	}

	public void setIdC(int idC) {
		this.idC = idC;
	}

	public int getCpc() {
		return cpc;
	}

	public void setCpc(int cpc) {
		this.cpc = cpc;
	}

	public int getDatenaissc() {
		return datenaissc;
	}

	public void setDatenaissc(int datenaissc) {
		this.datenaissc = datenaissc;
	}

	public String getNomc() {
		return nomc;
	}

	public void setNomc(String nomc) {
		this.nomc = nomc;
	}

	public String getPrenomc() {
		return prenomc;
	}

	public void setPrenomc(String prenomc) {
		this.prenomc = prenomc;
	}

	public String getAdrc() {
		return adrc;
	}

	public void setAdrc(String adrc) {
		this.adrc = adrc;
	}

	public String getVillec() {
		return villec;
	}

	public void setVillec(String villec) {
		this.villec = villec;
	}

	
	
}
