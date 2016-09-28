/**
 * @author pmorcrette
 *
 */
public class Capitale{

		private  String nom;
		private  int nb_habitant;
		private  int superficie;
		
	public Capitale(){
		
	}
//test comm git
	
	public  String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNb_habitant() {
		return nb_habitant;
	}

	public void setNb_habitant(int nb_habitant) {
		this.nb_habitant = nb_habitant;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public String toString(){
		String chaine;
		
		chaine="";
		
		chaine+="Nom:" + this.nom + "\n";
		chaine+="Nombre d'habitant:"+this.nb_habitant +"\n";
		chaine+="Superficie:"+this.superficie+"km\n";
		
		return chaine;
		
	}

}
