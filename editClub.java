import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.event.*;

public class editClub{
	private JTextField inputField;
	private JList list;
	private ArrayList<Club> clubs;
	private JButton addButton;
	private JButton removeButton;
	private JLabel console;

	public editClub(){
		clubs = new ArrayList<Club>();
		JFrame frame = new JFrame("Add and Drop Example");
		frame.setSize(650, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.add(new JLabel("Input Data: "));
		inputField = new JTextField(12);
		AddListener addListener = new AddListener();
		inputField.addActionListener(addListener);
		panel.add(inputField);

		addButton = new JButton("Add Record");
		addButton.addActionListener(addListener);
		panel.add(addButton);
		removeButton = new JButton("Remove Record");
		removeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				int removeId = Integer.parseInt(inputField.getText().trim());
				int index = getIndex(removeId);
				if(index != -1){
					Club removed = clubs.remove(index);
					console.setText("Removed: " + removed);
				}else{
					console.setText("ID " + removeId + " not found");
				}
				list.setListData(clubs.toArray());
			}
	});
	panel.add(removeButton);
	frame.add(BorderLayout.NORTH, panel);

	list = new JList();
	frame.add(list);

	console = new JLabel();
	frame.add(BorderLayout.SOUTH, console);

	frame.setVisible(true);
   }

   public int getIndex(int id){
   	for(int i=0; i<clubs.size(); i++){
   		Club cb = clubs.get(i);
   		if (cb.getclubId() == id){
   			return i;
   		}
   	}
   	return -1;
} 	

class AddListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
		String[] items = inputField.getText().split(",");
		Club club = new Club(items[0].trim(), items[1].trim(), items[2].trim());
		clubs.add(club);
		console.setText("Added: " + club);
		list.setListData(clubs.toArray());
	}
}

public static void main(String[] args){
	new editClub();
}	
}
