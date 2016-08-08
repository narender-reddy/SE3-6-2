package service;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import menu.MenuScreen;
import tasks.AssignEmployees;
import tasks.PDFInvoices;
import tasks.ManageEmployees;
import tasks.ManageClients;
import tasks.ManageProjects;
import tasks.Reports;
import tasks.TimeApprove;

public class HeaderScreen {
	public void getHeaderMenuScreen(final Tool tool){
		if(tool!=null && tool.getUserType()!=null){
			tool.getPanel().removeAll();
			final JLabel label=new JLabel("Welcomei "+tool.getUserType());
			label.setFont(new Font("Courier New", Font.ITALIC, 24));
			label.setForeground(Color.WHITE);
			label.setBounds(150,50,400,25);
			tool.getPanel().add(label);
			
			JButton logout = new JButton("Logout");
			logout.setBackground(Color.GREEN);		
			logout.setFont(new Font("Courier New", Font.PLAIN, 18));
			logout.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					tool.setUserType("");
					tool.setUserName("");
					getLoginScreen(tool.getPanel(),tool);			
				}
			});
			logout.setBounds(450,20,125,25);
			tool.getPanel().add(logout);
			
			if(tool!=null && tool.getUserType()!=null && (tool.getUserType().equalsIgnoreCase("Accountant"))){
				
				final JButton clientButton = new JButton("Client");
				clientButton.setBounds(20, 75, 75, 30);
				clientButton.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 ManageClients.viewClients(tool);			     		
			         }
				});	    
			    tool.getPanel().add(clientButton);
				
			    final JButton projectButton = new JButton("Project");
			    projectButton.setBounds(100, 75, 110, 30);
			    projectButton.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 ManageProjects.viewProjects(tool);
			         }
				});	    
			    tool.getPanel().add(projectButton);
			    
			    final JButton employeeButton = new JButton("Employee");
			    employeeButton.setBounds(215, 75, 100, 30);
			    employeeButton.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    		 ManageEmployees.viewEmployees(tool);
			         }
				});	    
			    tool.getPanel().add(employeeButton);
			    
			    final JButton invoiceButton = new JButton("Invoice");
			    invoiceButton.setBounds(320, 75, 75, 30);
			    invoiceButton.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    		PDFInvoices.viewInvoices(tool);
			         }
				});	    
			    tool.getPanel().add(invoiceButton);
			    
			    final JButton reportButton = new JButton("Report");
			    reportButton.setBounds(400, 75, 100, 30);
			    reportButton.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 Reports.generateReports(tool);			     		
			         }
				});	    
			    tool.getPanel().add(reportButton);
			}else if(tool!=null && tool.getUserType()!=null && (tool.getUserType().equalsIgnoreCase("Project Manager"))){				
				
				JButton forecastButton = new JButton("Project");
				forecastButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ManageProjects.viewProjects(tool);
					}
				});
				forecastButton.setBounds(100,90,100,30);
				tool.getPanel().add(forecastButton);
				
				final JButton projectButton = new JButton("Assign");
			    projectButton.setBounds(205, 90, 100, 30);
			    projectButton.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 AssignEmployees.addAssign(tool);	
			         }
				});	    
			    tool.getPanel().add(projectButton);
			    
			    final JButton timeApproveButton = new JButton("Time-Approve");
			    timeApproveButton.setBounds(310, 90, 125, 30);
			    timeApproveButton.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 TimeApprove.timeApprove(tool);	
			         }
				});	    
			    tool.getPanel().add(timeApproveButton);
				
				final JButton reportButton = new JButton("Report");
			    reportButton.setBounds(440, 90, 115, 30);
			    reportButton.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 Reports.generateReports(tool);
			     		
			         }
				});	    
			    tool.getPanel().add(reportButton);			    
			}else{
				final JLabel label1=new JLabel("Employee Working Hours");
				label1.setFont(new Font("Courier New", Font.ITALIC, 24));
				label1.setForeground(Color.WHITE);
				label1.setBounds(200,100,350,30);
				tool.getPanel().add(label1);
				
				JLabel projectLabel = new JLabel("Select Project");
				projectLabel.setBounds(175, 150, 100, 20);
				projectLabel.setForeground(Color.WHITE);
				tool.getPanel().add(projectLabel);
				
				MaintainDatabase maintainDatabase=new MaintainDatabase();
				String projectLabels[] = new String[0];
				Vector projectdata=maintainDatabase.developerProjectsData(tool.getUserName());
			    if(projectdata!=null  && projectdata.size()!=0){
			    	projectLabels=new String[projectdata.size()];
			    	for(int arg=0;arg<projectdata.size();arg++){
			    		String[] project=(String[])projectdata.get(arg);
			    		projectLabels[arg]=project[0];
			    	}
			    }
			    final JComboBox projectComboBox = new JComboBox(projectLabels);
			    projectComboBox.setMaximumRowCount(4);
			    projectComboBox.setSelectedIndex(0);
			    projectComboBox.setBounds(275, 148, 225, 25);
			    tool.getPanel().add(projectComboBox);
			    
				JLabel dateLabel = new JLabel("Date");
				dateLabel.setBounds(175, 180, 100, 20);
				dateLabel.setForeground(Color.WHITE);
				tool.getPanel().add(dateLabel);
				
				final JTextField date = new JTextField();
				date.setBounds(275, 178, 225, 25);
				tool.getPanel().add(date);
				
				JLabel startLabel = new JLabel("Start Time");
				startLabel.setBounds(175, 210, 100, 20);
				startLabel.setForeground(Color.WHITE);
				tool.getPanel().add(startLabel);
				
				final JTextField starttime= new JTextField();
				starttime.setBounds(275, 208, 225, 25);		
				tool.getPanel().add(starttime);
				
				JLabel endLabel = new JLabel("End Time");
				endLabel.setBounds(175, 240, 100, 20);
				endLabel.setForeground(Color.WHITE);
				tool.getPanel().add(endLabel);
				
				final JTextField endtime= new JTextField();
				endtime.setBounds(275, 238, 225, 25);		
				tool.getPanel().add(endtime);
				
				final JButton loginButton = new JButton("Login");
				loginButton.setBackground(Color.GREEN);		
				loginButton.setFont(new Font("Courier New", Font.PLAIN, 18));
				loginButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				loginButton.setBounds(275, 300, 125, 30);	
				tool.getPanel().add(loginButton);
			}
		}
	}
	
	public void getLoginScreen(final JPanel panel,final Tool tool){
		panel.removeAll();
		
		JLabel userNameLabel = new JLabel("User Name");
		userNameLabel.setBounds(175, 150, 100, 20);
		userNameLabel.setForeground(Color.WHITE);
		panel.add(userNameLabel);
		
		final JTextField textField = new JTextField();
		textField.setBounds(275, 148, 225, 25);
		panel.add(textField);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(175, 210, 100, 20);
		passwordLabel.setForeground(Color.WHITE);
		panel.add(passwordLabel);
		
		final JPasswordField password= new JPasswordField();
		password.setBounds(275, 208, 225, 25);		
		panel.add(password);
		
		final JButton loginButton = new JButton("Login");
		loginButton.setBackground(Color.GREEN);		
		loginButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintainDatabase maintainDatabase=new MaintainDatabase();
				String[] employee=maintainDatabase.checkEmployeeData(textField.getText().trim());
				if(textField.getText()==null || textField.getText().trim().length()==0){
					JOptionPane.showMessageDialog(loginButton, "Please enter user name");
				}else if(password.getText()==null || password.getText().trim().length()==0){
					JOptionPane.showMessageDialog(loginButton, "Please enter password");
				}else if(employee!=null && employee.length==4 && (employee[2].equalsIgnoreCase("Accountant") && password.getText().trim().equalsIgnoreCase("accountant"))){
					tool.setClients(maintainDatabase.clientsData());
					tool.setProjects(maintainDatabase.projectsData());
					tool.setEmployees(maintainDatabase.employeesData());
					tool.setUserType("Accountant");					
					tool.setPanel(panel);
					new MenuScreen().initialize(tool);												
				}else if(employee!=null && employee.length==4 && (employee[2].equalsIgnoreCase("Project Manager") && password.getText().trim().equalsIgnoreCase("manager"))){
					tool.setProjects(maintainDatabase.projectsData());
					tool.setEmployees(maintainDatabase.employeesData());
					tool.setUserType("Project Manager");
					tool.setPanel(panel);
					new MenuScreen().initialize(tool);												
				}else if(employee!=null && employee.length==4 && (employee[2].equalsIgnoreCase("Developer") && password.getText().trim().equalsIgnoreCase("developer"))){
					tool.setUserType("Developer");
					tool.setPanel(panel);
					new MenuScreen().initialize(tool);												
				}else{
					JOptionPane.showMessageDialog(loginButton, "Enter user name and password correct !!!");
				}
			}
		});
		loginButton.setBounds(275, 275, 125, 30);	
		panel.add(loginButton);		
		panel.repaint();
	}
}
