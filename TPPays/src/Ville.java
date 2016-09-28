import java.util.ArrayList;


public class Ville {
	private  String nom;
	private  int nb_habitant;
	private  int superficie;
	
	
public Ville(String unNom, int leNb_habitant,int laSuperficie){
	this.nom= unNom;
	this.nb_habitant=leNb_habitant;
	this.superficie=laSuperficie;
	
}

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
