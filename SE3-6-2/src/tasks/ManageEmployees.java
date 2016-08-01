package tasks;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class ManageEmployees {
	public static void addEmployee(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Add Employee");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(75, 165, 100, 20);
		nameLabel.setForeground(Color.WHITE);
		tool.getPanel().add(nameLabel);
		
		final JTextField nameTextField = new JTextField();
		nameTextField.setBounds(155, 163, 125, 25);
		tool.getPanel().add(nameTextField);
		
		JLabel titleLabel = new JLabel("Title");
		titleLabel.setBounds(75, 200, 100, 20);
		titleLabel.setForeground(Color.WHITE);
		tool.getPanel().add(titleLabel);
		
		final JTextField titleTextField = new JTextField();
		titleTextField.setBounds(155, 198, 125, 25);
		tool.getPanel().add(titleTextField);
		
		JLabel billRateLabel = new JLabel("Bill Rate");
		billRateLabel.setBounds(75, 235, 100, 20);
		billRateLabel.setForeground(Color.WHITE);
		tool.getPanel().add(billRateLabel);
		
		final JTextField billRateName = new JTextField();
		billRateName.setBounds(155, 233, 125, 25);
		tool.getPanel().add(billRateName);
		
		JLabel roleLabel = new JLabel("Role");
		roleLabel.setBounds(295, 165, 100, 20);
		roleLabel.setForeground(Color.WHITE);
		tool.getPanel().add(roleLabel);
		
//		final JTextField roleTextField = new JTextField();
//		roleTextField.setBounds(415, 163, 100, 25);
//		tool.getPanel().add(roleTextField);
		
		String roleLabels[] = {"Developer", "Project Manager", "Accountant"};
	    final JComboBox roleComboBox = new JComboBox(roleLabels);
	    roleComboBox.setMaximumRowCount(4);
	    roleComboBox.setSelectedIndex(0);
	    roleComboBox.setBounds(415, 163, 100, 25);
	    tool.getPanel().add(roleComboBox);
		
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
		
		
		final  JButton addCourse = new JButton("Add Employee");
		addCourse.setBackground(Color.GREEN);		
		addCourse.setFont(new Font("Courier New", Font.PLAIN, 18));
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		addCourse.setBounds(325,300,175,30);
		tool.getPanel().add(addCourse);
		
		tool.getPanel().repaint();
	}
	
	public static void editEmployee(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Update Employee");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(75, 165, 100, 20);
		nameLabel.setForeground(Color.WHITE);
		tool.getPanel().add(nameLabel);
		
		final JTextField nameTextField = new JTextField();
		nameTextField.setBounds(155, 163, 125, 25);
		tool.getPanel().add(nameTextField);
		
		JLabel titleLabel = new JLabel("Title");
		titleLabel.setBounds(75, 200, 100, 20);
		titleLabel.setForeground(Color.WHITE);
		tool.getPanel().add(titleLabel);
		
		final JTextField titleTextField = new JTextField();
		titleTextField.setBounds(155, 198, 125, 25);
		tool.getPanel().add(titleTextField);
		
		JLabel billRateLabel = new JLabel("Bill Rate");
		billRateLabel.setBounds(75, 235, 100, 20);
		billRateLabel.setForeground(Color.WHITE);
		tool.getPanel().add(billRateLabel);
		
		final JTextField billRateName = new JTextField();
		billRateName.setBounds(155, 233, 125, 25);
		tool.getPanel().add(billRateName);
		
		JLabel roleLabel = new JLabel("Role");
		roleLabel.setBounds(295, 165, 100, 20);
		roleLabel.setForeground(Color.WHITE);
		tool.getPanel().add(roleLabel);
		
		final JTextField roleTextField = new JTextField();
		roleTextField.setBounds(415, 163, 100, 25);
		tool.getPanel().add(roleTextField);
		
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
		
		
		final JButton addCourse = new JButton("Update Employee");
		addCourse.setBackground(Color.GREEN);		
		addCourse.setFont(new Font("Courier New", Font.PLAIN, 18));
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		addCourse.setBounds(325,300,200,30);
		tool.getPanel().add(addCourse);
		
		tool.getPanel().repaint();
	}
	
	public static void viewEmployees(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("View Employees");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		Object rowData[][]= { { "1", "2", "3", "4"},{ "1", "2", "3", "4"} };
		Object columnNames[] = { "Name", "Title", "Bill Rate", "Role"};
		if(tool.getEmployees()!=null && tool.getEmployees().size()!=0){
			rowData=new Object[tool.getEmployees().size()][4];
			if(tool.getEmployees()!=null && tool.getEmployees().size()!=0){
				rowData=new Object[tool.getEmployees().size()][4];
				for(int i=0;i<tool.getEmployees().size();i++){
					String split[]=((String[])tool.getEmployees().get(i));
					if(split!=null && split.length>=4){
						rowData[i]=split;
					}
				}
			}
		}
		final JTable EmployeeTable = new JTable(rowData, columnNames);
		EmployeeTable.setRowSelectionAllowed(true);
	    ListSelectionModel cellSelectionModel = EmployeeTable.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
	    	public void valueChanged(ListSelectionEvent e) {
	    		if(EmployeeTable.getSelectedRow() > -1){
		        	tool.setSelectedTableRowValue(EmployeeTable.getSelectedRow());		        	
		        }
	    	}
	    });
		JScrollPane scroll = new JScrollPane(EmployeeTable);
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
		
		JButton addButton = new JButton("Add Employee");
		addButton.setBackground(Color.GREEN);		
		addButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addEmployee(tool);
			}
		});
		addButton.setBounds(50,400,200,30);
		tool.getPanel().add(addButton);		
		
		final JButton updateButton = new JButton("Edit Employee");
		updateButton.setBackground(Color.GREEN);		
		updateButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tool.getSelectedTableRowValue()!=-1){
					try{
						editEmployee(tool);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(updateButton, "Please you should select one row only");
				}	
			}
		});
		updateButton.setBounds(265,400,200,30);
		tool.getPanel().add(updateButton);
		
		final JButton deleteButton = new JButton("InActive");
		deleteButton.setBackground(Color.GREEN);		
		deleteButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		deleteButton.setBounds(480,400,125,30);
		tool.getPanel().add(deleteButton);
		
		tool.getPanel().repaint();
	}
}
