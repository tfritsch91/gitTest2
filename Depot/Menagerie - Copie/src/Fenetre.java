// Importation du package permettant de créer l'interface
import javax.swing.*;
// Importation du package awt permettant de gérer certains objets
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Fenetre extends JFrame implements ActionListener{
	//JPanel
	private JPanel panel ;
	private JPanel panel3=new JPanel() ;
	
	//JLabel
	private JLabel lbl= new JLabel(" Bienvenue dans votre Menagerie.");
	private JLabel resultatRecherche = new JLabel ();
	private JLabel resultatSuppression = new JLabel ();
	private JLabel resultatAjout = new JLabel ();
	private JLabel erreurSel = new JLabel();
	
	//JTextField
	private JTextField jtfNomRecherche= new JTextField(10);
	private JTextField jtfNomSupprimer= new JTextField(10);
	private JTextField jtfNomAnimal= new JTextField(10);
	
	private JComboBox combo = new JComboBox();
	//JButton
	private JButton btnAjouter = new JButton("Ajouter");
	private JButton btnSupprimer = new JButton("Supprimer");
	private JButton btnRechercher = new JButton("Rechercher");	
	
	//reste
	private Menagerie maMenagerie = new Menagerie();
	private String espece;
	
	
	
	public Fenetre(){
		this.setTitle("Menagerie"); // Donner un titre à la fenêtre
		
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.setSize(475, 300);
		this.setResizable(true); 
		
		JMenuBar menu= new JMenuBar();
		JMenu menuAction= new JMenu("Action");
		
		JMenuItem ajout=new JMenuItem("Ajouter");
		JMenuItem suppr=new JMenuItem("supprimer");
		JMenuItem chercher=new JMenuItem("Chercher");
		JMenuItem montrer=new JMenuItem("Contenu");
		
		menuAction.add(ajout);
		menuAction.add(suppr);
		menuAction.add(chercher);
		menuAction.add(montrer);
		
		menu.add(menuAction);
		this.setJMenuBar(menu);
		
		ajout.addActionListener(new ActionAdd());
		suppr.addActionListener(new ActionDel());
		montrer.addActionListener(new ActionShow());
		chercher.addActionListener(new ActionSeek());
		
		panel = new JPanel() ;
		panel.setLayout(new BorderLayout());
		
		panel.add(panel3, BorderLayout.NORTH);
		
		combo.setPreferredSize(new Dimension(100,20));
		combo.addItem("Chat");
		combo.addItem("Lion");
		combo.addItem("Manchot");
		combo.addItem("Varan");
		 combo.addItemListener(new ItemState());
		
		panel3.setLayout(new BorderLayout());
		panel3.add(lbl, BorderLayout.NORTH);
		
		
		
		// On ajoute le JPanel au conteneur principal :
		this.getContentPane().add(panel);
				
		this.setVisible(true); 
	}
	
	
	public void panelAdd(){
		
		btnAjouter.setEnabled(false);
		resultatAjout.setText(" ");
		JPanel panelAdd=new JPanel();
		
		


		
		btnAjouter.addActionListener(new CreerAnimal());
		JLabel lblNom=new JLabel("Entrez le nom de l'animal : ");
		
		
		
		JPanel panelNom=new JPanel();
		panelNom.setLayout(new FlowLayout());
		panelNom.add(lblNom);
		panelNom.add(jtfNomAnimal);
		panelNom.add(btnAjouter);
		
		
		JPanel panelEspece=new JPanel();
		panelEspece.setLayout(new GridLayout(6,1));
		panelEspece.add(combo);
		
		
		
		JPanel panelHaut=new JPanel();
		panelHaut.setLayout(new BorderLayout());
		panelHaut.add(panelEspece, BorderLayout.NORTH);
		panelHaut.add(panelNom, BorderLayout.CENTER);
		
		
		panelAdd.setLayout(new BorderLayout());
		panelAdd.add(panelHaut, BorderLayout.NORTH);
		panelAdd.add(resultatAjout, BorderLayout.CENTER);
		

		this.setContentPane(panelAdd);
		this.revalidate();
		
		
	}
		
	public void panelDel(){
				
		resultatSuppression.setText(" ");
		
		JPanel panelSupprimer=new JPanel();
		JPanel panelNomSupp=new JPanel();
		JLabel lblNomSupp=new JLabel("mettez le nom de l'animal à supprimer : ");
		
		btnSupprimer.addActionListener(new ActionDel2());
			
		
		JPanel panelEspeceSupp = new JPanel();
		panelEspeceSupp.setLayout(new FlowLayout());
		
		panelEspeceSupp.add(combo);
		
		
		panelNomSupp.setLayout(new FlowLayout());
		panelNomSupp.add(lblNomSupp);
		panelNomSupp.add(jtfNomSupprimer);
		panelNomSupp.add(btnSupprimer);
		
		JPanel panelHautSupp = new JPanel();
		panelHautSupp.setLayout(new BorderLayout());
		panelHautSupp.add(panelEspeceSupp, BorderLayout.NORTH);
		panelHautSupp.add(panelNomSupp, BorderLayout.CENTER);
		
		panelSupprimer.setLayout(new BorderLayout());
		panelSupprimer.add(panelHautSupp, BorderLayout.NORTH);
		panelSupprimer.add(resultatSuppression, BorderLayout.CENTER);
		
		
		this.setContentPane(panelSupprimer);
		this.revalidate();
		
	}
	
	public void panelShow(){
		JTextArea afficherContenu = new JTextArea();
		afficherContenu.setText(" ");
		JPanel panelAfficher=new JPanel();
		
		
		
		JLabel presentation =new JLabel("Voici les animaux présent dans votre ménagerie :");
		afficherContenu.setText(this.maMenagerie.presenter());
		afficherContenu.setEditable(false);
		
		panelAfficher.setLayout(new BorderLayout());
		panelAfficher.add(presentation, BorderLayout.NORTH); 
		panelAfficher.add(afficherContenu, BorderLayout.CENTER); 
		
		
		this.setContentPane(panelAfficher);
		this.revalidate();
	}
	
	public void panelSeek(){
		
		resultatRecherche.setText(" ");
		JPanel panelRechercher=new JPanel();
		
		JLabel lblNomRecherche=new JLabel("Entrez le nom de l'animal à rechercher : ");
		
		
		btnRechercher.addActionListener(new ActionSeek2());
		JPanel panelEspeceRecherche = new JPanel();
		panelEspeceRecherche.setLayout(new FlowLayout());
		
		panelEspeceRecherche.add(combo);
	
		
		JPanel panelNomRecherche=new JPanel();
		panelNomRecherche.setLayout(new FlowLayout());
		panelNomRecherche.add(lblNomRecherche);
		panelNomRecherche.add(jtfNomRecherche);
		panelNomRecherche.add(btnRechercher);
		
		JPanel panelHautRecherche=new JPanel();
		panelHautRecherche.setLayout(new BorderLayout());
		panelHautRecherche.add(panelEspeceRecherche, BorderLayout.NORTH);
		panelHautRecherche.add(panelNomRecherche, BorderLayout.CENTER);
		
		panelRechercher.setLayout(new BorderLayout());
		panelRechercher.add(panelHautRecherche, BorderLayout.NORTH);
		panelRechercher.add(resultatRecherche, BorderLayout.CENTER);
		
		
		this.setContentPane(panelRechercher);
		this.revalidate();
	
	}
	
	
	
	public class CreerAnimal implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch(espece){
			
			case "Chat":
				Animal unChat = new Chat(jtfNomAnimal.getText(),espece);
				maMenagerie.arriver(unChat);
				btnAjouter.setEnabled(false);
				resultatAjout.setText("L'animal a été ajouté.");
				 
			break;
			
			case "Lion":
				Animal unLion = new Lion(jtfNomAnimal.getText(),espece);
				maMenagerie.arriver(unLion);
				btnAjouter.setEnabled(false);
				resultatAjout.setText("L'animal a été ajouté.");
			break;
			
			case "Manchot":
				Animal unManchot = new Manchot(jtfNomAnimal.getText(),espece);
				maMenagerie.arriver(unManchot);
				btnAjouter.setEnabled(false);
				resultatAjout.setText("L'animal a été ajouté.");
			break;
			
			case "Varan":
				Animal unVaran = new Varan(jtfNomAnimal.getText(),espece);
				maMenagerie.arriver(unVaran);
				btnAjouter.setEnabled(false);
				resultatAjout.setText("L'animal a été ajouté.");
			break;
			
			
			
		}
		}
	}

	public class SelAnimal implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			}
		}


	
	public class ActionDel2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(jtfNomSupprimer.getText()!=null && espece !=null){
				resultatSuppression.setText(maMenagerie.supprimerAnimal(jtfNomSupprimer.getText(),espece));
			}
			else {
				resultatSuppression.setText("L'animal n'existe pas");
			}
		}
		
	}

	
	public class ActionSeek2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			resultatRecherche.setText(maMenagerie.rechercheAnimal(jtfNomRecherche.getText(), espece));
		}
	}
	
	public class ActionAdd implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Fenetre.this.panelAdd();
		}
	}
	
	public class ActionDel implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Fenetre.this.panelDel();
		}
	}
	
	public class ActionShow implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Fenetre.this.panelShow();
		}
	}
	
	public class ActionSeek implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Fenetre.this.panelSeek();
		}
	}
	
	
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
	//Les autres imports
	
	  class ItemState implements ItemListener{
	    public void itemStateChanged(ItemEvent e) {
			if(e.getItem()=="Chat"){
							btnAjouter.setEnabled(true);
							btnRechercher.setEnabled(true);
							btnSupprimer.setEnabled(true);
							espece="Chat";
						}
						else{
							if(e.getItem()=="Lion"){
								btnAjouter.setEnabled(true);
								btnSupprimer.setEnabled(true);
								btnRechercher.setEnabled(true);
								espece="Lion";
								
							}
							else{
									if(e.getItem()=="Manchot"){
										btnAjouter.setEnabled(true);
										btnSupprimer.setEnabled(true);
										btnRechercher.setEnabled(true);
										espece="Manchot";
										
									}
									else{
										if(e.getItem()=="Varan"){
											btnAjouter.setEnabled(true);
											btnSupprimer.setEnabled(true);
											btnRechercher.setEnabled(true);
											espece="Varan";
											
										}
										
									}
					}
				}
	      
	      
	    }

		      
	  }
	
}


