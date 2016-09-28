import java.util.ArrayList;


/**
 * @author pmorcrette
 *
 */
public class Pays {
	private String noms;
	private String langue;
	private String monnaie;
	private Capitale capitale;
	private static int compteur_pays=0;
	private ArrayList <Ville> lesVilles; 
	private Ville uneVille;
	
	
	/**
	 * Constructeur Classe Pays
	 */
	public Pays(){
		compteur_pays=compteur_pays+1;
		this.lesVilles = new ArrayList<Ville>();
	}
	
	/**
	 * @return retourne le noms en majuscule
	 */
	//Retourne le Nom du pays en majuscule
	public String getNoms() {
		return noms.toUpperCase();
	}
	/**
	 * @param noms
	 */
	public void setNoms(String noms) {
		this.noms = noms;
	}
	/**
	 * @return retourne la langue 
	 */
	public String getLangue() {
		return langue;
	}
	/**
	 * @param langue
	 */
	public void setLangue(String langue) {
		this.langue = langue;
	}
	/**
	 * @return retourne la monnaie
	 */
	public String getMonnaie() {
		return monnaie;
	}
	/**
	 * @param monnaie
	 */
	public void setMonnaie(String monnaie) {
		this.monnaie = monnaie;
	}
	public Capitale getCapitale(){
		return this.capitale;
	}
	public void setCapitale(Capitale capitale){
		
	}
	
	/**
	 * @return la première lettre du nom du pays en majuscule dans la méthode toString
	 */
	private String premMaj(){
		 String chaine=this.noms.toLowerCase();
	     String chaineMaj=chaine.replaceFirst(".",(chaine.charAt(0)+"").toUpperCase());
	    	
		return chaineMaj;
	}
	
	
	/**
	 * @return retourne la totalité des 
	 * information d'un pays
	 * 
	 */
	public String toString(){
		String chaine;
		
		chaine="";
		chaine+="Nom:" + this.premMaj() + "\n";
		chaine+="Langue:"+this.langue+ "\n";
		chaine+="Monnaie:"+this.monnaie+ "\n";
		
		return chaine;
		
	}

	

	/**
	 * @return retourne le nombre de pays
	 */
	public static int getCompteur_pays() {
		return compteur_pays;
	}
	public int getTailleCollec(){
		int x=lesVilles.size();
		return x;
		
	}
	public void ajouterVille(String unNom, String unelangue){
		lesVilles.add(this.uneVille);
		
	}
	

}
