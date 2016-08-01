package tasks;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import au.com.bytecode.opencsv.CSVWriter;
import menu.MenuScreen;
import service.HeaderScreen;
import service.MaintainDatabase;
import service.Tool;

public class ManageProjects {
	public static void addProject(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Add Project");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		JLabel clientLabel = new JLabel("Client");
		clientLabel.setBounds(60, 165, 100, 20);
		clientLabel.setForeground(Color.WHITE);
		tool.getPanel().add(clientLabel);
		
		final JTextField lastNameTextField = new JTextField();
		lastNameTextField.setBounds(145, 163, 125, 25);
		tool.getPanel().add(lastNameTextField);
		
		JLabel numberLabel = new JLabel("Project Number");
		numberLabel.setBounds(60, 200, 100, 20);
		numberLabel.setForeground(Color.WHITE);
		tool.getPanel().add(numberLabel);
		
		final JTextField numberTextField = new JTextField();
		numberTextField.setBounds(145, 198, 125, 25);
		tool.getPanel().add(numberTextField);
		
		JLabel nameLabel = new JLabel("Project Name");
		nameLabel.setBounds(60, 235, 100, 20);
		nameLabel.setForeground(Color.WHITE);
		tool.getPanel().add(nameLabel);
		
		final JTextField nameTextField = new JTextField();
		nameTextField.setBounds(145, 233, 125, 25);
		tool.getPanel().add(nameTextField);
		
		JLabel startDateLabel = new JLabel("Start Date");
		startDateLabel.setBounds(60, 270, 100, 20);
		startDateLabel.setForeground(Color.WHITE);
		tool.getPanel().add(startDateLabel);
		
		final JTextField startDateTextField = new JTextField();
		startDateTextField.setBounds(145, 268, 125, 25);
		tool.getPanel().add(startDateTextField);
		
		JLabel endDateLabel = new JLabel("End Date");
		endDateLabel.setBounds(60, 305, 100, 20);
		endDateLabel.setForeground(Color.WHITE);
		tool.getPanel().add(endDateLabel);
		
		final JTextField endDateTextField = new JTextField();
		endDateTextField.setBounds(145, 303, 125, 25);
		tool.getPanel().add(endDateTextField);
		
		JLabel statusLabel = new JLabel("Status");
		statusLabel.setBounds(295, 165, 100, 20);
		statusLabel.setForeground(Color.WHITE);
		tool.getPanel().add(statusLabel);
		
		final JTextField statusTextField = new JTextField();
		statusTextField.setBounds(400, 163, 125, 25);
		tool.getPanel().add(statusTextField);
		
		JLabel pmLabel = new JLabel("Project Manager");
		pmLabel.setBounds(295, 200, 100, 20);
		pmLabel.setForeground(Color.WHITE);
		tool.getPanel().add(pmLabel);
		
		final JTextField pmTextField = new JTextField();
		pmTextField.setBounds(400, 198, 125, 25);
		tool.getPanel().add(pmTextField);
		
		JLabel ccLabel = new JLabel("Client Contact");
		ccLabel.setBounds(295, 235, 100, 20);
		ccLabel.setForeground(Color.WHITE);
		tool.getPanel().add(ccLabel);
		
		final JTextField ccTextField = new JTextField();
		ccTextField.setBounds(400, 233, 125, 25);
		tool.getPanel().add(ccTextField);
		
		JLabel budgetLabel = new JLabel("Budget");
		budgetLabel.setBounds(295, 270, 100, 20);
		budgetLabel.setForeground(Color.WHITE);
		tool.getPanel().add(budgetLabel);
		
		final JTextField budgetTextField = new JTextField();
		budgetTextField.setBounds(400, 268, 125, 25);
		tool.getPanel().add(budgetTextField);
				
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(85,375,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(200,375,100,30);
		tool.getPanel().add(cancelButton);
		
		
		final JButton addCourse = new JButton("Add Project");
		addCourse.setBackground(Color.GREEN);		
		addCourse.setFont(new Font("Courier New", Font.PLAIN, 18));
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		addCourse.setBounds(325,375,175,30);
		tool.getPanel().add(addCourse);
		
		tool.getPanel().repaint();
	}
	
	public static void editProject(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Update Project");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		JLabel clientLabel = new JLabel("Client");
		clientLabel.setBounds(60, 165, 100, 20);
		clientLabel.setForeground(Color.WHITE);
		tool.getPanel().add(clientLabel);
		
		final JTextField lastNameTextField = new JTextField();
		lastNameTextField.setBounds(145, 163, 125, 25);
		tool.getPanel().add(lastNameTextField);
		
		JLabel numberLabel = new JLabel("Project Number");
		numberLabel.setBounds(60, 200, 100, 20);
		numberLabel.setForeground(Color.WHITE);
		tool.getPanel().add(numberLabel);
		
		final JTextField numberTextField = new JTextField();
		numberTextField.setBounds(145, 198, 125, 25);
		tool.getPanel().add(numberTextField);
		
		JLabel nameLabel = new JLabel("Project Name");
		nameLabel.setBounds(60, 235, 100, 20);
		nameLabel.setForeground(Color.WHITE);
		tool.getPanel().add(nameLabel);
		
		final JTextField nameTextField = new JTextField();
		nameTextField.setBounds(145, 233, 125, 25);
		tool.getPanel().add(nameTextField);
		
		JLabel startDateLabel = new JLabel("Start Date");
		startDateLabel.setBounds(60, 270, 100, 20);
		startDateLabel.setForeground(Color.WHITE);
		tool.getPanel().add(startDateLabel);
		
		final JTextField startDateTextField = new JTextField();
		startDateTextField.setBounds(145, 268, 125, 25);
		tool.getPanel().add(startDateTextField);
		
		JLabel endDateLabel = new JLabel("End Date");
		endDateLabel.setBounds(60, 305, 100, 20);
		endDateLabel.setForeground(Color.WHITE);
		tool.getPanel().add(endDateLabel);
		
		final JTextField endDateTextField = new JTextField();
		endDateTextField.setBounds(145, 303, 125, 25);
		tool.getPanel().add(endDateTextField);
		
		JLabel statusLabel = new JLabel("Status");
		statusLabel.setBounds(295, 165, 100, 20);
		statusLabel.setForeground(Color.WHITE);
		tool.getPanel().add(statusLabel);
		
		final JTextField statusTextField = new JTextField();
		statusTextField.setBounds(400, 163, 125, 25);
		tool.getPanel().add(statusTextField);
		
		JLabel pmLabel = new JLabel("Project Manager");
		pmLabel.setBounds(295, 200, 100, 20);
		pmLabel.setForeground(Color.WHITE);
		tool.getPanel().add(pmLabel);
		
		final JTextField pmTextField = new JTextField();
		pmTextField.setBounds(400, 198, 125, 25);
		tool.getPanel().add(pmTextField);
		
		JLabel ccLabel = new JLabel("Client Contact");
		ccLabel.setBounds(295, 235, 100, 20);
		ccLabel.setForeground(Color.WHITE);
		tool.getPanel().add(ccLabel);
		
		final JTextField ccTextField = new JTextField();
		ccTextField.setBounds(400, 233, 125, 25);
		tool.getPanel().add(ccTextField);
		
		JLabel budgetLabel = new JLabel("Budget");
		budgetLabel.setBounds(295, 270, 100, 20);
		budgetLabel.setForeground(Color.WHITE);
		tool.getPanel().add(budgetLabel);
		
		final JTextField budgetTextField = new JTextField();
		budgetTextField.setBounds(400, 268, 125, 25);
		tool.getPanel().add(budgetTextField);
				
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(85,375,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(200,375,100,30);
		tool.getPanel().add(cancelButton);
		
		
		final JButton addCourse = new JButton("Update Project");
		addCourse.setBackground(Color.GREEN);		
		addCourse.setFont(new Font("Courier New", Font.PLAIN, 18));
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		addCourse.setBounds(315,375,200,30);
		tool.getPanel().add(addCourse);
		
		tool.getPanel().repaint();
	}
	
	public static void viewProjects(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("View Projects");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(175,125,250,20);
		tool.getPanel().add(label);
		
		Object rowData[][]= { { "1", "2", "3", "4","5", "6", "7", "8","9"},{ "1", "2", "3", "4","5", "6", "7", "8","9"} };
		Object columnNames[] = { "Client", "Project Number", "Project Name", "State Date", "End Date", "Status", "Project Manager","Client Contact","Budget"};
		if(tool.getProjects()!=null && tool.getProjects().size()!=0){
			rowData=new Object[tool.getProjects().size()][9];
			for(int i=0;i<tool.getProjects().size();i++){
				String split[]=((String[])tool.getProjects().get(i));
				if(split!=null && split.length>=9){
					rowData[i]=split;
				}
			}
		}
		final JTable ProjectTable = new JTable(rowData, columnNames);
		ProjectTable.setRowSelectionAllowed(true);
	    ListSelectionModel cellSelectionModel = ProjectTable.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
	    	public void valueChanged(ListSelectionEvent e) {
	    		if(ProjectTable.getSelectedRow() > -1){
		        	tool.setSelectedTableRowValue(ProjectTable.getSelectedRow());		        	
		        }
	    	}
	    });
		JScrollPane scroll = new JScrollPane(ProjectTable);
		scroll.setBounds(50, 150, 450, 225);
		tool.getPanel().add(scroll);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(150,450,80,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(250,450,100,30);
		tool.getPanel().add(cancelButton);		
		
		JButton addButton = new JButton("Add Project");
		addButton.setBackground(Color.GREEN);		
		addButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProject(tool);
			}
		});
		addButton.setBounds(50,400,170,30);
		tool.getPanel().add(addButton);		
		
		final JButton updateButton = new JButton("Edit Project");
		updateButton.setBackground(Color.GREEN);		
		updateButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if(tool.getSelectedTableRowValue()!=-1){
//					try{
//						editProject(tool);	
//					}catch(Exception ex){
//						ex.printStackTrace();
//					}
//				}else{
//					JOptionPane.showMessageDialog(updateButton, "Please you should select one row only");
//				}
			}
		});
		updateButton.setBounds(225,400,170,30);
		tool.getPanel().add(updateButton);
		
		final JButton deleteButton = new JButton("InActive");
		deleteButton.setBackground(Color.GREEN);		
		deleteButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if(tool.getSelectedTableRowValue()!=-1){
//					try{
//						Vector faculties=tool.getProjects();
//						tool.setProjects(faculties);
//						tool.setSelectedTableRowValue(-1);
//						ManageProjects.viewProject(tool);
//					}catch(Exception ex){
//						ex.printStackTrace();
//					}
//				}else{
//					JOptionPane.showMessageDialog(deleteButton, "Please you should select one row only");
//				}		
			}
		});
		deleteButton.setBounds(400,400,125,30);
		tool.getPanel().add(deleteButton);
		
		tool.getPanel().repaint();
	}
}
