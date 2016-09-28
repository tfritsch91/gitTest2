
public class Felin extends Animal{
	
	
	//Attributs
	
	
	
	
	
	//Constructeurs
	public Felin(String unNom, String uneEspece){
		super(unNom, uneEspece);
	}

	@Override
	public String carac() {
		// TODO Auto-generated method stub
		String chaine="chasse";
		return chaine;
	}
	



	public Felin(String unNom) {
		// TODO Auto-generated constructor stub
		super(unNom);
	}
}