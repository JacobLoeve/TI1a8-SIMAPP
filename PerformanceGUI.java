mimport javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class PerformanceGUI extends JFrame{
	Agenda agenda;

	public PerformanceGUI(Agenda agenda){
		this.agenda = agenda;
	}
	
	public void GUI() throws FileNotFoundException, IOException, ClassNotFoundException{
		
		 ObjectInputStream ois = new ObjectInputStream(new FileInputStream("agenda.txt"));
		 @SuppressWarnings("unchecked")
		 ArrayList<Artist> inputArtist = (ArrayList<Artist>) ois.readObject();
		 ArrayList<Stage> inputStage = (ArrayList<Stage>) ois.readObject();
		 
		 ArrayList<String> artistNames = new ArrayList<String>();
		 for(int i = 0; i<inputArtist.size(); i++){
			 artistNames.add(inputArtist.get(i).getName());
		 }
		 String[] arrayArtistNames = artistNames.toArray(new String[artistNames.size()]);
		
		 ArrayList<String> stageNames = new ArrayList<String>();
		 for(int i = 0; i<inputStage.size(); i++){
			 stageNames.add(inputStage.get(i).getName());
		 }
		 String[] arrayStageNames = stageNames.toArray(new String[stageNames.size()]);
		
		 JFrame frame = new JFrame("Nieuw optreden toevoegen");
		
		   JLabel artistName = new JLabel("Artiest:");
		   JLabel startTime = new JLabel("Start tijd:");
		   JLabel endTime = new JLabel("Eind tijd:");
		   JLabel stageName = new JLabel("podium:");
		   JLabel titleAdd = new JLabel("NIEUW OPTREDEN TOEVOEGEN");
		   JLabel titleDelete = new JLabel("OPTREDEN VERWIJDEREN");
		   JLabel dummie = new JLabel("");
		   JLabel dummie1 = new JLabel("");
		   JLabel dummie2 = new JLabel("");
		   JLabel dummie3 = new JLabel("");
		   JLabel dummie4 = new JLabel("");
		   JLabel dummie5 = new JLabel("");
		   JLabel dummie6 = new JLabel("");
		   JLabel dummie7 = new JLabel("");
		   JLabel dummie8 = new JLabel("");
		   
		   
		   JComboBox artist = new JComboBox(arrayArtistNames);
		   JComboBox stage = new JComboBox(arrayStageNames);
		   JComboBox sH = new JComboBox();
		   JComboBox sM = new JComboBox();
		   JComboBox eH = new JComboBox();
		   JComboBox eM = new JComboBox();
		   
		   for(int i=0;i<=23;i++) {
			   sH.addItem(new Integer(i));
			   eH.addItem(new Integer(i));
		   }
		   for(int i=0;i<=59;i++){
			   sM.addItem(new Integer(i));
			   eM.addItem(new Integer(i));
		   }
		   
		   JButton btnSave = new JButton("opslaan");
		   JButton btnDelete = new JButton("verwijderen");
		   
		   JPanel add = new JPanel(new GridLayout(8,3));
		   JPanel delete = new JPanel(new GridLayout(3,2));
		   

		   add.add(titleAdd);
		   add.add(dummie);
		   add.add(artistName);
		   add.add(artist);
		   add.add(stageName);
		   add.add(stage);
		   add.add(startTime);
		   add.add(dummie1);
		   add.add(sH);
		   add.add(sM);
		   add.add(endTime);
		   add.add(dummie2);
		   add.add(eH);
		   add.add(eM);
		   add.add(dummie3);
		   add.add(btnSave);
		   
		   frame.add(add, BorderLayout.NORTH);
		   frame.add(delete, BorderLayout.SOUTH);
		   
		btnSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					agenda.createPerformance(inputArtist.get(artist.getSelectedIndex()), 
							inputStage.get(stage.getSelectedIndex()), 
							(int)sH.getSelectedItem(), (int)sM.getSelectedItem(), 
							(int)eH.getSelectedItem(), (int)eM.getSelectedItem());
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
				artist.setSelectedIndex(0);
				stage.setSelectedIndex(0);
				sH.setSelectedIndex(0);
				sM.setSelectedIndex(0);
				eH.setSelectedIndex(0);
				eM.setSelectedIndex(0);
				frame.dispose();
			}
		});
		   
		    frame.setSize(500,500);
		    frame.setResizable(false);
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
	}

}