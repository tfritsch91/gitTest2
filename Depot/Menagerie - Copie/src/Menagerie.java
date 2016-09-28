import java.util.ArrayList;

public class Menagerie {
	

	//attribut
	
	private ArrayList<Animal> listeAnimaux;
	
	//constructeur
	public Menagerie() {
		
		this.listeAnimaux = new ArrayList<Animal>();
	
	}
	
	//methode
	
	
	public String supprimerAnimal(String unNom, String uneEspece){
		int i=0;
		String chaine=" ";
		boolean trouve = false;
		while(i<this.listeAnimaux.size() && trouve==false){
			
			if(unNom.equals(this.listeAnimaux.get(i).getNom()) && uneEspece.equals(this.listeAnimaux.get(i).getEspece())){
				trouve=true;
				if(trouve==true){
						this.listeAnimaux.remove(i);
						chaine="L'animal a été supprimé.";
				}
				else{
					chaine="L'animal que vous voulez supprimer est introuvable.";
				}
			}
			else{
				i=i+1;
			}
		}

		
		return chaine;
	}
	
	public String rechercheAnimal(String unNom, String uneEspece){
		int i;
		int compteur=0;
		String chaine=" ";
		for(i=0;i<this.listeAnimaux.size();i++){
			if(unNom.equals(this.listeAnimaux.get(i).getNom()) && uneEspece.equals(this.listeAnimaux.get(i).getEspece())){
				chaine+="n°"+(i+1)+".\n";
				chaine+="\nJe me présente :"+this.listeAnimaux.get(i).toString()+"\n";
				chaine+=this.listeAnimaux.get(i).carac()+"\n";
				compteur=compteur+1;
			}
		}
		if(compteur==0){
			chaine="L'animal que vous recherchez est introuvable.";
		}
		return chaine;
	}

	public void arriver(Animal unAnimal){
		this.listeAnimaux.add(unAnimal);
	}
	
	
	public void partir(Animal unAnimal){
		this.listeAnimaux.remove(unAnimal);
	}
	
	
	public String presenter(){
		String chaine=" ";
		if(this.listeAnimaux.size()==0){
			chaine="La ménagerie ne possède aucun animal.";
		}
		else{
			for(int i=0;i<this.listeAnimaux.size();i++){
				chaine+="\nJe me présente :"+this.listeAnimaux.get(i).toString()+"\n";
				chaine+=this.listeAnimaux.get(i).carac()+"\n";
			}
		}
		return chaine;
	}
}