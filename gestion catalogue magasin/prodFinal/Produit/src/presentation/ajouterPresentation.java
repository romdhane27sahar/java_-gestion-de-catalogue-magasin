package presentation;

import java.awt.BorderLayout;



import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import dao.CatalogueDao;
import dao.CatalogueDaoImpl;
import entity.Categorie;
import entity.Produit;

public class ajouterPresentation extends JFrame {

	//JPanel JPanelTous = new JPanel(new GridLayout(3, 1, 5, 5));
	JPanel pc = new JPanel(new BorderLayout());
	JPanel pp = new JPanel(new BorderLayout());
	JPanel bas = new JPanel(new BorderLayout());
	JButton quitter = new JButton("quitter");
	JPanel p1 = new JPanel(new GridLayout(6, 2, 10, 10));
	JButton btn1 = new JButton("annuller");
	
	JPanel p2 = new JPanel(new GridLayout(3, 2, 10, 10));
	JButton btn2 = new JButton("annuller");
	JButton ajouterC = new JButton("Ajouter une categorie");


	JPanel btnQ = new JPanel();
	JComboBox<String> nomCat = new JComboBox<>(new String[] {});
	

	

	JLabel nom = new JLabel("nom", JLabel.RIGHT);
	JTextField tnom = new JTextField();
	JLabel prix = new JLabel("prix", JLabel.RIGHT);
	JTextField tprix = new JTextField();
	JLabel nomC = new JLabel("Categorie");
	JTextField tnomC = new JTextField();
	JLabel quantite = new JLabel("quantite", JLabel.RIGHT);
	JTextField tquantite = new JTextField();
	JButton ajouter = new JButton("ajouter");
JLabel vide = new JLabel("        ");
	CatalogueDao catalogueDao = new CatalogueDaoImpl();
														
	JPanel prs = new JPanel(new GridLayout(1, 1));
	TableModele me = new TableModele();
	JTable table = new JTable(me);
	JScrollPane jsp = new JScrollPane(table);


 

	JPanel prsc = new JPanel(new GridLayout(1, 1));
	TableModele2 mec = new TableModele2();
	JTable tablec = new JTable(mec);
	JScrollPane jspc = new JScrollPane(tablec);
	JPanel ppp = new JPanel(new GridLayout(1,2));
	public ajouterPresentation() {

		getAllCategories();
		
		//this.setLayout(new GridLayout(1,2));
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		nom.setHorizontalAlignment(JLabel.RIGHT);
		nomC.setHorizontalAlignment(JLabel.RIGHT);
		pp.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 2), "ajouter un Produit"));
	

		
		
		p1.add(nom);
		p1.add(tnom);
		p1.add(prix);
		p1.add(tprix);
		p1.add(quantite);
		p1.add(tquantite);
		p1.add(nomC);
		p1.add(nomCat);
		p1.add(vide);
		prs.add(jsp);
		p1.add(ajouter);
		p1.add(btn1);
		pp.add(p1, BorderLayout.NORTH);

		pp.add(jsp, BorderLayout.CENTER);
		ppp.add(pp);

		
		setVisible(true);

	
		pp.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 2), "ajouter un Produit"));
		pc.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED, 2),
				"ajouter une categorie"));
		
		p2.add(nomC);
		p2.add(tnomC);

		prsc.add(jspc);
		p2.add(ajouterC);
		p2.add(btn2);

		pc.add(p2, BorderLayout.NORTH);
		pc.add(prsc, BorderLayout.CENTER);

		ppp.add(pc);
		btnQ.add(quitter);
		bas.add(btnQ);
		//this.add(btnQ);
		this.add(ppp,BorderLayout.CENTER);
		this.add(btnQ , BorderLayout.SOUTH) ;
		//this.add(bas, BorderLayout.SOUTH);
		this.setSize(1000,800);

		this.setLocationRelativeTo(null);
	
		// this.add(bas);

		// pajoutTous.add(p, BorderLayout.SOUTH);
		// this.add(pajoutC);
		// this.add(pajoutP,BorderLayout.NORTH);
		// prsP.add(jspP);
		// this.add(prsP,BorderLayout.CENTER);
		// basP.add(quitterP);
		// this.add(basP,BorderLayout.SOUTH);
		

		 me.charger(catalogueDao.getAllProduit());
		 
          	 
		ajouter.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {

				String nom = tnom.getText();
				Double prix = Double.parseDouble(tprix.getText());
				Double quantite = Double.parseDouble(tquantite.getText());
				String nomC = (String) nomCat.getSelectedItem();
							
				if (nom.equals("") || prix.equals("") || quantite.equals("")
						|| nomC.equals("")) {
					JOptionPane.showMessageDialog(ajouterPresentation.this, "erreur de saisie");}
				else {
					Produit p = new Produit(nom, prix, quantite, nomC);
					catalogueDao.addProduit(p);
					
					me.charger(catalogueDao.getAllProduit());
				}
			}
		});
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		mec.charger(catalogueDao.getAllCategorie());
		ajouterC.addActionListener(e->{
               if(tnomC.getText().equals(""))
            	   JOptionPane.showMessageDialog(this, " Completer la saisie ");
               else {
            	 
            	 
				String nomC = tnomC.getText();
				
				Categorie c2 = new Categorie(nomC);
				catalogueDao.addCategorie(c2);
				getAllCategories();
				mec.charger(catalogueDao.getAllCategorie()); }
		});
               
      /*         List<String> listeCat  = new ArrayList<>();
					for(String string : CategorieList) {
					if(listeCat.contains(nomC))
						 {
						JOptionPane.showMessageDialog(this, " Categorie deja existante ");
						 }
			
					else
					{
					          String nomC;
	               // nomCat.addItem(nomC);
	                listeCat.add(nomC);
					}}			
		});
					
		
*/
		
btn1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

		tnom.setText("");
		tprix.setText("");
		tquantite.setText("");
				
				
			}
		});
		

btn2.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {

       tnomC.setText("");

		
		
	}
	
});}	

		
	
	private void getAllCategories() {
		
		List<Categorie> categorieList = catalogueDao.getAllCategorie();
		categorieList.forEach(c -> nomCat.addItem(c.getNomC()));

	}
	
	
	public static void main(String[] args) {
		new ajouterPresentation();
	}
		

}