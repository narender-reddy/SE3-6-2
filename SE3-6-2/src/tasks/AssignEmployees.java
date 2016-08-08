package tasks;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import menu.MenuScreen;
import service.HeaderScreen;
import service.MaintainDatabase;
import service.Tool;

public class AssignEmployees {
	public static void addAssign(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Assign Developer");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		JLabel numberLabel = new JLabel("Select Project");
		numberLabel.setBounds(175, 165, 100, 20);
		numberLabel.setForeground(Color.WHITE);
		tool.getPanel().add(numberLabel);
		
	    String projectLabels[] = new String[0];
	    Vector projectdata=tool.getProjects();
	    if(projectdata!=null  && projectdata.size()!=0){
	    	projectLabels=new String[projectdata.size()];
	    	for(int arg=0;arg<projectdata.size();arg++){
	    		String[] project=(String[])projectdata.get(arg);
	    		projectLabels[arg]=project[2];
	    	}
	    }
	    final JComboBox projectComboBox = new JComboBox(projectLabels);
	    projectComboBox.setMaximumRowCount(4);
	    projectComboBox.setSelectedIndex(0);
	    projectComboBox.setBounds(275, 163, 75, 30);
	    tool.getPanel().add(projectComboBox);
		
		JLabel nameLabel = new JLabel("Select Developer");
		nameLabel.setBounds(175, 200, 115, 20);
		nameLabel.setForeground(Color.WHITE);
		tool.getPanel().add(nameLabel);
		MaintainDatabase maintainDatabase=new MaintainDatabase();
		Vector developers=maintainDatabase.employeesDeveloperData();
		String developerLabels[] = new String[0];
		if(developers!=null  && developers.size()!=0){
			developerLabels=new String[developers.size()];
	    	for(int arg=0;arg<developers.size();arg++){
	    		String[] developer=(String[])developers.get(arg);
	    		projectLabels[arg]=developer[0];
	    	}
	    }
	    final JComboBox developerComboBox = new JComboBox(developerLabels);
	    developerComboBox.setMaximumRowCount(4);
	    developerComboBox.setSelectedIndex(0);
	    developerComboBox.setBounds(275, 198, 150, 25);
	    tool.getPanel().add(developerComboBox);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(85,300,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(200,300,100,30);
		tool.getPanel().add(cancelButton);
		
		
		final JButton assignbutton = new JButton("Assign");
		assignbutton.setBackground(Color.GREEN);		
		assignbutton.setFont(new Font("Courier New", Font.PLAIN, 18));
		assignbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String projectnumber=((projectComboBox.getItemAt(projectComboBox.getSelectedIndex()))).toString();
				String developername=((developerComboBox.getItemAt(developerComboBox.getSelectedIndex()))).toString();
				try{
					MaintainDatabase maintainDatabase=new MaintainDatabase();
					maintainDatabase.assignDeveloperData(projectnumber, developername);
					JOptionPane.showMessageDialog(assignbutton, "Developer assigned successfully to selected project");
					addAssign(tool);
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		assignbutton.setBounds(305,300,200,30);
		tool.getPanel().add(assignbutton);
		
		tool.getPanel().repaint();
	}
}
