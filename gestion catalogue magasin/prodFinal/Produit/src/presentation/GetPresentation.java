
	package presentation;

	import java.awt.Color;
import java.awt.GridLayout;




	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;

	public class GetPresentation extends JFrame{
		JButton ajouter = new JButton(new ImageIcon("C:/images/add2.png"));
		JButton rechercher = new JButton(new ImageIcon("C:/images/rech4.png"));
		JButton quitter = new JButton(new ImageIcon("c:/images/quitt5.png"));
		
		 public GetPresentation() {
			 this.setVisible(true);
			 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			 this.setTitle("Gestion Catalogue");
			 this.setLayout(new GridLayout(1,3,10,10)); 
			
			 
			 this.add(ajouter);
			 this.add(rechercher);
			 this.add(quitter);
			
			 this.setSize(950,550);
			 this.setLocationRelativeTo(null);
			
			 ajouter.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
					 new ajouterPresentation();
				 }
			 });
			 rechercher.addActionListener(new ActionListener(){          
				 public void actionPerformed(ActionEvent e) {
					 new FindPresentation();
				 }
			 });
			 quitter.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
					System.exit(0);
				 }
			 });
			 }
		public static void main(String[]args) {
			new  GetPresentation();
		}
	}

	

