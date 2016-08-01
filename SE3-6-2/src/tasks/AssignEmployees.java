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
		
//		final JTextField semesterName = new JTextField();
//		semesterName.setBounds(275, 163, 75, 30);
//	    tool.getPanel().add(semesterName);
	    String projectLabels[] = {"Project1", "Project2", "Project3", "Project4", "Project5"};
	    final JComboBox projectComboBox = new JComboBox(projectLabels);
	    projectComboBox.setMaximumRowCount(4);
	    projectComboBox.setSelectedIndex(0);
	    projectComboBox.setBounds(275, 163, 75, 30);
	    tool.getPanel().add(projectComboBox);
		
		JLabel nameLabel = new JLabel("Select Developer");
		nameLabel.setBounds(175, 200, 115, 20);
		nameLabel.setForeground(Color.WHITE);
		tool.getPanel().add(nameLabel);
		
//		final JTextField numTextField = new JTextField();
//		numTextField.setBounds(205, 198, 150, 25);
//		tool.getPanel().add(numTextField);
		
		String developerLabels[] = {"Developer1", "Developer2", "Developer3", "Developer4", "Developer5"};
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
		
		
		final JButton addCourse = new JButton("Assign");
		addCourse.setBackground(Color.GREEN);		
		addCourse.setFont(new Font("Courier New", Font.PLAIN, 18));		
		addCourse.setBounds(305,300,200,30);
		tool.getPanel().add(addCourse);
		
		tool.getPanel().repaint();
	}
}
