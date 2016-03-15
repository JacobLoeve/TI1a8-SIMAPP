import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ArtistGUI extends JFrame{
	Agenda agenda;
	ArrayList<String> artistNames = new ArrayList<String>();
	String[] arrayArtistNames;
	
	public ArtistGUI(Agenda agenda){
		this.agenda = agenda;
	}
	
	public void getArtistNames() throws FileNotFoundException, ClassNotFoundException, IOException{
		for(int i = 0; i<agenda.getArtists().size(); i++){
			artistNames.add(agenda.getArtists().get(i).getName());
		}
		arrayArtistNames = artistNames.toArray(new String[artistNames.size()]);
	}
	
	public void GUI() throws FileNotFoundException, ClassNotFoundException, IOException{
		getArtistNames();
		JFrame frame = new JFrame("Artiest");
		
		   JLabel artistName = new JLabel("     Naam:");
		   JLabel artistGenre = new JLabel("     Genre:");
		   JLabel artistPopularity = new JLabel("     populariteit:");
		   JLabel titleAdd = new JLabel("NIEUWE ARTIEST TOEVOEGEN");
		   JLabel titleDelete = new JLabel("ARTIEST VERWIJDEREN");
		   JLabel choose = new JLabel("     te verwijderen artiest:");
		   JLabel dummie = new JLabel("");
		   JLabel dummie1 = new JLabel("");
		   JLabel dummie2 = new JLabel("");
		   JLabel dummie3 = new JLabel("");

		   JTextField name = new JTextField();
		   JTextField genre = new JTextField();
		   JTextField popularity = new JTextField();

		   JComboBox artist = new JComboBox(arrayArtistNames);
		   
		   JButton btnSave = new JButton("Opslaan");
		   JButton btnDelete = new JButton("Verwijderen");
		   
		   JPanel add = new JPanel(new GridLayout(5,2));
		   JPanel delete = new JPanel(new GridLayout(3,2));
		   
		   add.add(titleAdd);
		   add.add(dummie1);
		   add.add(artistName);
		   add.add(name);
		   add.add(artistGenre);
		   add.add(genre);
		   add.add(artistPopularity);
		   add.add(popularity);
		   add.add(dummie);
		   add.add(btnSave);
		   
		   delete.add(titleDelete);
		   delete.add(dummie2);
		   delete.add(choose);
		   delete.add(artist);
		   delete.add(dummie3);
		   delete.add(btnDelete);
		   
		   frame.add(add, BorderLayout.NORTH);
		   frame.add(delete, BorderLayout.CENTER);
		   
		   btnDelete.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
				  try {
					agenda.removeArtist(artist.getSelectedIndex());
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			   }
		   });
		   
		   btnSave.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
			   int x = Integer.parseInt(popularity.getText());
			   try {
				   agenda.createArtist(name.getText(), genre.getText(),x);
			   	} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
			   	} 
			   name.setText("");
			   genre.setText("");
			   popularity.setText("");
			   artist.setSelectedIndex(0);
			   frame.dispose();
			   }
		   });
		   
		    frame.setSize(400,250);
		    frame.setResizable(false);
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
	}

}
