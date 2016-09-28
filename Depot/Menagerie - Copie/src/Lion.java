
public class Lion extends Felin{

	public Lion(String unNom, String uneEspece) {
		super(unNom, uneEspece);
	}

	public Lion(String unNom) {
		// TODO Auto-generated constructor stub
		super(unNom);
	}

	@Override
	public String carac() {
		// TODO Auto-generated method stub
		String chaine="Chasse en meute";
		return chaine;
	}

}