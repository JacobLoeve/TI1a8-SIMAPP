import javax.swing.JFrame;
import javax.swing.JLabel;
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

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StageGUI extends JFrame{
	Agenda agenda;
	ArrayList<String> stageNames = new ArrayList<String>();
	String[] arrayStageNames;
	
	public StageGUI(Agenda agenda){
		this.agenda = agenda;
	}
	
	public void getStageNames() throws FileNotFoundException, ClassNotFoundException, IOException{
		for(int i = 0; i<agenda.getStages().size(); i++){
			stageNames.add(agenda.getStages().get(i).getName());
		}
		arrayStageNames = stageNames.toArray(new String[stageNames.size()]);
	}
	
	
	public void GUI() throws FileNotFoundException, ClassNotFoundException, IOException{
		getStageNames();
		JFrame frame = new JFrame("Podium");
		
		   JLabel stageName = new JLabel("     Naam:");
		   JLabel stageMaximum = new JLabel("     Maximum bezoekers:");
		   JLabel titleAdd = new JLabel("NIEUW PODIUM TOEVOEGEN");
		   JLabel titleDelete = new JLabel("PODIUM VERWIJDEREN");
		   JLabel choose = new JLabel("     te verwijderen podium:");
		   JLabel dummie = new JLabel("");
		   JLabel dummie1 = new JLabel("");
		   JLabel dummie2 = new JLabel("");
		   JLabel dummie3 = new JLabel("");
		   
		   JTextField stage = new JTextField();
		   JTextField viewers = new JTextField();
		   
		   JComboBox stages = new JComboBox(arrayStageNames);
		   
		   JButton btnSave = new JButton("opslaan");
		   JButton btnDelete = new JButton("verwijderen");
		   
		   JPanel add = new JPanel(new GridLayout(6,2));
		   JPanel delete = new JPanel(new GridLayout(3,2));
		   
		   add.add(titleAdd);
		   add.add(dummie);
		   add.add(stageName);
		   add.add(stage);
		   add.add(stageMaximum);
		   add.add(viewers);
		   add.add(dummie1);
		   add.add(btnSave);
		   
		   delete.add(titleDelete);
		   delete.add(dummie2);
		   delete.add(choose);
		   delete.add(stages);
		   delete.add(dummie3);
		   delete.add(btnDelete);
		   
		   frame.add(add, BorderLayout.NORTH);
		   frame.add(delete, BorderLayout.CENTER);
		   
		   btnDelete.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
				  try {
					agenda.removeStage(stages.getSelectedIndex());
				  } catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				  }
			   }
		   });
		   
		   btnSave.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
				   int x = Integer.parseInt(viewers.getText());
				   try {
					   agenda.createStage(stage.getText(), x);
				   	} catch (IOException | ClassNotFoundException e1) {
						e1.printStackTrace();
					} 
				  stage.setText("");
				  viewers.setText("");
				  stages.setSelectedIndex(0);
				  frame.dispose();
			   }
		   });
		   
		    frame.setSize(400,300);
		    frame.setResizable(false);
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
	}

}