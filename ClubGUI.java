import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.event.*;

public class ClubGUI{
	private JTextField fileField;
	private JButton nameButton;
	private JButton countryButton; 
	private JButton quitButton;
	private JLabel photo;

	private JTextArea contents;
	private JLabel console;
	private ArrayList<Club> clubs;
	private String[][] tableData;
	private JTable table;



	public ClubGUI(){
		JFrame frame = new JFrame();
		frame.setSize(750, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//top panel
		JPanel panel = new JPanel();
		panel.add(new JLabel("Enter file name"));
		fileField = new JTextField("clubs.csv");
		fileField.addActionListener(new FileListener());
		panel.add(fileField);

		nameButton = new FancyButton("Sort By Name");
		nameButton.addActionListener(new NameListener());
		panel.add(nameButton);

		countryButton = new FancyButton("Sort by country");
		countryButton.addActionListener(new CountryListener());
		panel.add(countryButton);

		quitButton = new WarningButton("Quit");
		quitButton.addActionListener(new QuitListener());
		panel.add(quitButton);

		frame.add(BorderLayout.NORTH, panel);

		//FOR TABLE

		String[] columns = {"ID", "Name", "Country", "Wins", "FirstWin Year"};
		table = new JTable(tableData, columns);
		tableData = new String[4][5]; //Since file has a length of 4
		setTableData(); 

		ListSelectionModel select= table.getSelectionModel();
		select.addListSelectionListener(new TableListener()); 
		photo = new JLabel();
		showPhoto();
		JSplitPane pane = new JSplitPane(SwingConstants.VERTICAL, table, photo);
		pane.setDividerLocation(8);

		frame.add(pane);
		frame.setVisible(true);


		contents =new JTextArea(5, 40);
		frame.add(contents);

		console = new JLabel();
		console.setForeground(Color.white);
		console.setBackground(Color.black);
		frame.setVisible(true);

	}

	private void setTableData(){
		for(int i=0; i<4; i++){
			tableData[i][0] = clubs.get(i).getclubId() + "";
			tableData[i][1] = clubs.get(i).getname();
			tableData[i][2] = clubs.get(i).getcountry();
			tableData[i][3] = clubs.get(i).getClubWins();
			tableData[i][4] = clubs.get(i).getFirstWin();
			tableData[i][5] = clubs.get(i).getTotalBudget();

		}
	}


	class QuitListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.out.println("----End-------");
			System.exit(0);
		}
	}


	class FileListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			String fileName = fileField.getText().trim();
			try{
				FileReader fr = new FileReader(fileName);
				BufferedReader file = new BufferedReader(fr);
				int size = Integer.parseInt(file.readLine().trim());
				clubs = new Club[size];

				for (int i=0; i<4; i++){
					String line = file.readLine();
					String[] items = line.split(",");
					clubs = new ArrayList<Club>(items[0].trim(), items[1].trim(), items[2].trim(), items[3].trim());

				}
			StringBuilder builder = new StringBuilder();
			for(Club c: clubs){
				builder.append(c.toString() + "\n");

			}

			contents.setText(builder.toString());



			}catch(IOException e){
				System.out.println(e);
			}
		}

	}

	public String clubString(){
		StringBuilder builder = new StringBuilder();
			for(Club c: clubs){
				builder.append(c.toString() + "\n");

			}

			return builder.toString();

	}

	private void showPhoto(){
		int selectedIndex = (int)(Math.random() * 4);
		photo.setIcon(new ImageIcon(clubs.get(selectedIndex).getPhoto()));
	}





	class NameListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Collections.sort(clubs, Club.NAME);
			int selectedIndex = table.getSelectedRow();
			photo.setIcon(new ImageIcon(clubs.get(selectedIndex).getPhoto()));
			setTableData();
		}
	}

	class CountryListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
		   Collections.sort(clubs, Club.COUNTRY);
			int selectedIndex = table.getSelectedRow();
			setTableData();
		}	
	}

	class TableListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent event){
			int selectedIndex = table.getSelectedRow();
			photo.setIcon(new ImageIcon(clubs.get(selectedIndex).getPhoto()));

		}
	}


	public static void main(String[] args){
		ClubGUI gui = new ClubGUI();
	}
	



	class FancyButton extends JButton{
		public FancyButton(String str){
			super(str);
			setBackground(Color.blue);
			setForeground(Color.yellow);
		}
	}

	class WarningButton extends JButton{
		public WarningButton(String str){
			super(str);
			setBackground(Color.red);
			setBackground(Color.red);
		}
	}	

}	