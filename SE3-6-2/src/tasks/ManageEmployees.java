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
		
		String roleLabels[] = {"Developer", "Project Manager", "Accountant"};
	    final JComboBox employeerolesComboBox = new JComboBox(roleLabels);
	    employeerolesComboBox.setMaximumRowCount(4);
	    employeerolesComboBox.setSelectedIndex(0);
	    employeerolesComboBox.setBounds(415, 163, 100, 25);
	    tool.getPanel().add(employeerolesComboBox);
		
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
		
		
		final  JButton addEmployee = new JButton("Add Employee");
		addEmployee.setBackground(Color.GREEN);		
		addEmployee.setFont(new Font("Courier New", Font.PLAIN, 18));
		addEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nameTextField!=null && nameTextField.getText().trim().length()!=0 && titleTextField!=null && titleTextField.getText().trim().length()!=0 
				&& billRateName!=null && billRateName.getText().trim().length()!=0){
					try{
						MaintainDatabase maintainDatabase=new MaintainDatabase();
						maintainDatabase.saveEmployeeData(nameTextField.getText(), titleTextField.getText(), billRateName.getText(), ((employeerolesComboBox.getItemAt(employeerolesComboBox.getSelectedIndex()))).toString());
						tool.setEmployees(maintainDatabase.employeesData());
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(addEmployee, "Please enter Client details");
				}
			}
		});
		addEmployee.setBounds(325,300,175,30);
		tool.getPanel().add(addEmployee);		
		tool.getPanel().repaint();
	}
	
	public static void editEmployee(final Tool tool,final String[] split){
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
		nameTextField.setText(split[0]);
		nameTextField.setBounds(155, 163, 125, 25);
		tool.getPanel().add(nameTextField);
		
		JLabel titleLabel = new JLabel("Title");
		titleLabel.setBounds(75, 200, 100, 20);
		titleLabel.setForeground(Color.WHITE);
		tool.getPanel().add(titleLabel);
		
		final JTextField titleTextField = new JTextField();
		titleTextField.setText(split[1]);
		titleTextField.setBounds(155, 198, 125, 25);
		tool.getPanel().add(titleTextField);
		
		JLabel billRateLabel = new JLabel("Bill Rate");
		billRateLabel.setBounds(75, 235, 100, 20);
		billRateLabel.setForeground(Color.WHITE);
		tool.getPanel().add(billRateLabel);
		
		final JTextField billRateName = new JTextField();
		billRateName.setText(split[3]);
		billRateName.setBounds(155, 233, 125, 25);
		tool.getPanel().add(billRateName);
		
		JLabel roleLabel = new JLabel("Role");
		roleLabel.setBounds(295, 165, 100, 20);
		roleLabel.setForeground(Color.WHITE);
		tool.getPanel().add(roleLabel);
		
		String roleLabels[] = {"Developer", "Project Manager", "Accountant"};
	    final JComboBox employeerolesComboBox = new JComboBox(roleLabels);
	    employeerolesComboBox.setMaximumRowCount(4);
	    employeerolesComboBox.setSelectedItem(split[2]);
	    employeerolesComboBox.setBounds(415, 163, 100, 25);
	    tool.getPanel().add(employeerolesComboBox);
		
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
		
		
		final JButton updateEmployee = new JButton("Update Employee");
		updateEmployee.setBackground(Color.GREEN);		
		updateEmployee.setFont(new Font("Courier New", Font.PLAIN, 18));
		updateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nameTextField!=null && nameTextField.getText().trim().length()!=0 && titleTextField!=null && titleTextField.getText().trim().length()!=0 
						&& billRateName!=null && billRateName.getText().trim().length()!=0){
							try{
								MaintainDatabase maintainDatabase=new MaintainDatabase();
								maintainDatabase.updateEmployeeData(nameTextField.getText(), titleTextField.getText(), billRateName.getText(), ((employeerolesComboBox.getItemAt(employeerolesComboBox.getSelectedIndex()))).toString());
								tool.setEmployees(maintainDatabase.employeesData());
							}catch(Exception ex){
								ex.printStackTrace();
							}
						}else{
							JOptionPane.showMessageDialog(updateEmployee, "Please enter Client details");
						}
			}
		});
		updateEmployee.setBounds(325,300,200,30);
		tool.getPanel().add(updateEmployee);
		
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
		
		JButton addemployeeButton = new JButton("Add Employee");
		addemployeeButton.setBackground(Color.GREEN);		
		addemployeeButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		addemployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addEmployee(tool);
			}
		});
		addemployeeButton.setBounds(50,400,200,30);
		tool.getPanel().add(addemployeeButton);		
		
		final JButton updateemployeeButton = new JButton("Edit Employee");
		updateemployeeButton.setBackground(Color.GREEN);		
		updateemployeeButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		updateemployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tool.getSelectedTableRowValue()!=-1){
					try{
						String split[]=((String[])tool.getEmployees().get(tool.getSelectedTableRowValue()));
						editEmployee(tool,split);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(updateemployeeButton, "Please you should select one row only");
				}	
			}
		});
		updateemployeeButton.setBounds(265,400,200,30);
		tool.getPanel().add(updateemployeeButton);
		
		final JButton deleteemployeeButton = new JButton("InActive");
		deleteemployeeButton.setBackground(Color.GREEN);		
		deleteemployeeButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		deleteemployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					MaintainDatabase maintainDatabase=new MaintainDatabase();
					String split[]=((String[])tool.getEmployees().get(tool.getSelectedTableRowValue()));
					maintainDatabase.inactiveemployee(split[0]);						
					tool.setEmployees(maintainDatabase.employeesData());
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		deleteemployeeButton.setBounds(480,400,125,30);
		tool.getPanel().add(deleteemployeeButton);
		
		tool.getPanel().repaint();
	}
}
