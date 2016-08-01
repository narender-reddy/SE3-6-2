package tasks;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
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

import menu.MenuScreen;
import service.HeaderScreen;
import service.MaintainDatabase;
import service.Tool;
import au.com.bytecode.opencsv.CSVWriter;

public class ManageClients {
	public static void addClient(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Add Client");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		JLabel numberLabel = new JLabel("Number");
		numberLabel.setBounds(60, 165, 100, 20);
		numberLabel.setForeground(Color.WHITE);
		tool.getPanel().add(numberLabel);
		
		final JTextField numberTextField = new JTextField();
		numberTextField.setBounds(145, 163, 125, 25);
		tool.getPanel().add(numberTextField);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(60, 200, 100, 20);
		nameLabel.setForeground(Color.WHITE);
		tool.getPanel().add(nameLabel);
		
		final JTextField nameTextField = new JTextField();
		nameTextField.setBounds(145, 198, 125, 25);
		tool.getPanel().add(nameTextField);
		
		JLabel addressLine1Label = new JLabel("Address Line1");
		addressLine1Label.setBounds(60, 235, 100, 20);
		addressLine1Label.setForeground(Color.WHITE);
		tool.getPanel().add(addressLine1Label);
		
		final JTextField addressLine1TextField = new JTextField();
		addressLine1TextField.setBounds(145, 233, 125, 25);
		tool.getPanel().add(addressLine1TextField);
		
		JLabel addressLine2Label = new JLabel("Address Line2");
		addressLine2Label.setBounds(60, 270, 100, 20);
		addressLine2Label.setForeground(Color.WHITE);
		tool.getPanel().add(addressLine2Label);
		
		final JTextField addressLine2TextField = new JTextField();
		addressLine2TextField.setBounds(145, 268, 125, 25);
		tool.getPanel().add(addressLine2TextField);
		
		JLabel cityLabel = new JLabel("City");
		cityLabel.setBounds(60, 305, 100, 20);
		cityLabel.setForeground(Color.WHITE);
		tool.getPanel().add(cityLabel);
		
		final JTextField cityTextField = new JTextField();
		cityTextField.setBounds(145, 303, 125, 25);
		tool.getPanel().add(cityTextField);
		
		JLabel stateLabel = new JLabel("State");
		stateLabel.setBounds(300, 165, 100, 20);
		stateLabel.setForeground(Color.WHITE);
		tool.getPanel().add(stateLabel);
		
		final JTextField stateTextField = new JTextField();
		stateTextField.setBounds(400, 163, 125, 25);
		tool.getPanel().add(stateTextField);
		
		JLabel zipLabel = new JLabel("Zip");
		zipLabel.setBounds(300, 200, 100, 20);
		zipLabel.setForeground(Color.WHITE);
		tool.getPanel().add(zipLabel);
		
		final JTextField zipTextField = new JTextField();
		zipTextField.setBounds(400, 198, 125, 25);
		tool.getPanel().add(zipTextField);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(300, 235, 100, 20);
		emailLabel.setForeground(Color.WHITE);
		tool.getPanel().add(emailLabel);
		
		final JTextField emailTextField = new JTextField();
		emailTextField.setBounds(400, 233, 125, 25);
		tool.getPanel().add(emailTextField);
		
		JLabel contactLabel = new JLabel("Contact");
		contactLabel.setBounds(300, 270, 100, 20);
		contactLabel.setForeground(Color.WHITE);
		tool.getPanel().add(contactLabel);
		
		final JTextField contactTextField = new JTextField();
		contactTextField.setBounds(400, 268, 125, 25);
		tool.getPanel().add(contactTextField);
		
		JLabel invoiceFreqLabel = new JLabel("Invoice Freq");
		invoiceFreqLabel.setBounds(300, 305, 100, 20);
		invoiceFreqLabel.setForeground(Color.WHITE);
		tool.getPanel().add(invoiceFreqLabel);
		
//		final JTextField invoiceFreqTextField = new JTextField();
//		invoiceFreqTextField.setBounds(400, 303, 125, 25);
//		tool.getPanel().add(invoiceFreqTextField);
		
		String invoiceFreqLabels[] = {"Weekly", "BiWeekly"};
	    final JComboBox invoiceFreqComboBox = new JComboBox(invoiceFreqLabels);
	    invoiceFreqComboBox.setMaximumRowCount(4);
	    invoiceFreqComboBox.setSelectedIndex(0);
	    invoiceFreqComboBox.setBounds(400, 303, 125, 25);
	    tool.getPanel().add(invoiceFreqComboBox);
		
		JLabel billingtermsLabel = new JLabel("Billing Terms");
		billingtermsLabel.setBounds(60, 335, 100, 20);
		billingtermsLabel.setForeground(Color.WHITE);
		tool.getPanel().add(billingtermsLabel);
		
//		final JTextField billingtermsTextField = new JTextField();
//		billingtermsTextField.setBounds(145, 333, 125, 25);
//		tool.getPanel().add(billingtermsTextField);
		
		String billingtermsLabels[] = {"Net 10", "Net 20", "Net 30", "Net 60"};
	    final JComboBox billingtermsComboBox = new JComboBox(billingtermsLabels);
	    billingtermsComboBox.setMaximumRowCount(4);
	    billingtermsComboBox.setSelectedIndex(0);
	    billingtermsComboBox.setBounds(145, 333, 125, 25);
	    tool.getPanel().add(billingtermsComboBox);
		
		JLabel invoiceGroupingLabel = new JLabel("Invoice Grouping");
		invoiceGroupingLabel.setBounds(300, 335, 100, 20);
		invoiceGroupingLabel.setForeground(Color.WHITE);
		tool.getPanel().add(invoiceGroupingLabel);
		
//		final JTextField invoiceGroupingTextField = new JTextField();
//		invoiceGroupingTextField.setBounds(400, 333, 125, 25);
//		tool.getPanel().add(invoiceGroupingTextField);
		
		String invoiceGroupingLabels[] = {"Project", "Invoice"};
	    final JComboBox invoiceGroupingComboBox = new JComboBox(invoiceGroupingLabels);
	    invoiceGroupingComboBox.setMaximumRowCount(4);
	    invoiceGroupingComboBox.setSelectedIndex(0);
	    invoiceGroupingComboBox.setBounds(400, 333, 125, 25);
	    tool.getPanel().add(invoiceGroupingComboBox);
		
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
		
		
		final JButton addClient = new JButton("Add Client");
		addClient.setBackground(Color.GREEN);		
		addClient.setFont(new Font("Courier New", Font.PLAIN, 18));
		addClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numberTextField!=null && numberTextField.getText().trim().length()!=0 && nameTextField!=null && nameTextField.getText().trim().length()!=0){
					try{
						
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(addClient, "Please enter Client details");
				}
			}
		});
		addClient.setBounds(325,375,150,30);
		tool.getPanel().add(addClient);
		
		tool.getPanel().repaint();
	}
	
	public static void editClient(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Edit Client");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		JLabel numberLabel = new JLabel("Number");
		numberLabel.setBounds(60, 165, 100, 20);
		numberLabel.setForeground(Color.WHITE);
		tool.getPanel().add(numberLabel);
		
		final JTextField numberTextField = new JTextField();
		numberTextField.setBounds(145, 163, 125, 25);
		tool.getPanel().add(numberTextField);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(60, 200, 100, 20);
		nameLabel.setForeground(Color.WHITE);
		tool.getPanel().add(nameLabel);
		
		final JTextField nameTextField = new JTextField();
		nameTextField.setBounds(145, 198, 125, 25);
		tool.getPanel().add(nameTextField);
		
		JLabel addressLine1Label = new JLabel("Address Line1");
		addressLine1Label.setBounds(60, 235, 100, 20);
		addressLine1Label.setForeground(Color.WHITE);
		tool.getPanel().add(addressLine1Label);
		
		final JTextField addressLine1TextField = new JTextField();
		addressLine1TextField.setBounds(145, 233, 125, 25);
		tool.getPanel().add(addressLine1TextField);
		
		JLabel addressLine2Label = new JLabel("Address Line2");
		addressLine2Label.setBounds(60, 270, 100, 20);
		addressLine2Label.setForeground(Color.WHITE);
		tool.getPanel().add(addressLine2Label);
		
		final JTextField addressLine2TextField = new JTextField();
		addressLine2TextField.setBounds(145, 268, 125, 25);
		tool.getPanel().add(addressLine2TextField);
		
		JLabel cityLabel = new JLabel("City");
		cityLabel.setBounds(60, 305, 100, 20);
		cityLabel.setForeground(Color.WHITE);
		tool.getPanel().add(cityLabel);
		
		final JTextField cityTextField = new JTextField();
		cityTextField.setBounds(145, 303, 125, 25);
		tool.getPanel().add(cityTextField);
		
		JLabel stateLabel = new JLabel("State");
		stateLabel.setBounds(300, 165, 100, 20);
		stateLabel.setForeground(Color.WHITE);
		tool.getPanel().add(stateLabel);
		
		final JTextField stateTextField = new JTextField();
		stateTextField.setBounds(400, 163, 125, 25);
		tool.getPanel().add(stateTextField);
		
		JLabel zipLabel = new JLabel("Zip");
		zipLabel.setBounds(300, 200, 100, 20);
		zipLabel.setForeground(Color.WHITE);
		tool.getPanel().add(zipLabel);
		
		final JTextField zipTextField = new JTextField();
		zipTextField.setBounds(400, 198, 125, 25);
		tool.getPanel().add(zipTextField);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(300, 235, 100, 20);
		emailLabel.setForeground(Color.WHITE);
		tool.getPanel().add(emailLabel);
		
		final JTextField emailTextField = new JTextField();
		emailTextField.setBounds(400, 233, 125, 25);
		tool.getPanel().add(emailTextField);
		
		JLabel contactLabel = new JLabel("Contact");
		contactLabel.setBounds(300, 270, 100, 20);
		contactLabel.setForeground(Color.WHITE);
		tool.getPanel().add(contactLabel);
		
		final JTextField contactTextField = new JTextField();
		contactTextField.setBounds(400, 268, 125, 25);
		tool.getPanel().add(contactTextField);
		
		JLabel invoiceFreqLabel = new JLabel("Invoice Freq");
		invoiceFreqLabel.setBounds(300, 305, 100, 20);
		invoiceFreqLabel.setForeground(Color.WHITE);
		tool.getPanel().add(invoiceFreqLabel);
		
//		final JTextField invoiceFreqTextField = new JTextField();
//		invoiceFreqTextField.setBounds(400, 303, 125, 25);
//		tool.getPanel().add(invoiceFreqTextField);
		
		String invoiceFreqLabels[] = {"Weekly", "BiWeekly"};
	    final JComboBox invoiceFreqComboBox = new JComboBox(invoiceFreqLabels);
	    invoiceFreqComboBox.setMaximumRowCount(4);
	    invoiceFreqComboBox.setSelectedIndex(0);
	    invoiceFreqComboBox.setBounds(400, 303, 125, 25);
	    tool.getPanel().add(invoiceFreqComboBox);
		
		JLabel billingtermsLabel = new JLabel("Billing Terms");
		billingtermsLabel.setBounds(60, 335, 100, 20);
		billingtermsLabel.setForeground(Color.WHITE);
		tool.getPanel().add(billingtermsLabel);
		
//		final JTextField billingtermsTextField = new JTextField();
//		billingtermsTextField.setBounds(145, 333, 125, 25);
//		tool.getPanel().add(billingtermsTextField);
		
		String billingtermsLabels[] = {"Net 10", "Net 20", "Net 30", "Net 60"};
	    final JComboBox billingtermsComboBox = new JComboBox(billingtermsLabels);
	    billingtermsComboBox.setMaximumRowCount(4);
	    billingtermsComboBox.setSelectedIndex(0);
	    billingtermsComboBox.setBounds(145, 333, 125, 25);
	    tool.getPanel().add(billingtermsComboBox);
		
		JLabel invoiceGroupingLabel = new JLabel("Invoice Grouping");
		invoiceGroupingLabel.setBounds(300, 335, 100, 20);
		invoiceGroupingLabel.setForeground(Color.WHITE);
		tool.getPanel().add(invoiceGroupingLabel);
		
//		final JTextField invoiceGroupingTextField = new JTextField();
//		invoiceGroupingTextField.setBounds(400, 333, 125, 25);
//		tool.getPanel().add(invoiceGroupingTextField);
		
		String invoiceGroupingLabels[] = {"Project", "Invoice"};
	    final JComboBox invoiceGroupingComboBox = new JComboBox(invoiceGroupingLabels);
	    invoiceGroupingComboBox.setMaximumRowCount(4);
	    invoiceGroupingComboBox.setSelectedIndex(0);
	    invoiceGroupingComboBox.setBounds(400, 333, 125, 25);
	    tool.getPanel().add(invoiceGroupingComboBox);
		
		
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
		
		
		final JButton addClient = new JButton("Update Client");
		addClient.setBackground(Color.GREEN);		
		addClient.setFont(new Font("Courier New", Font.PLAIN, 18));
		addClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numberTextField!=null && numberTextField.getText().trim().length()!=0 && nameTextField!=null && nameTextField.getText().trim().length()!=0){
					try{
						
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(addClient, "Please enter Client details");
				}
			}
		});
		addClient.setBounds(325,375,200,30);
		tool.getPanel().add(addClient);
		
		tool.getPanel().repaint();
	}
	
	public static void viewClients(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("View Clients");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(200,125,250,20);
		tool.getPanel().add(label);
		
		Object rowData[][]= { { "1", "2", "3", "4","5", "6", "7", "8","9", "10","11","12"},{ "1", "2", "3", "4","5", "6", "7", "8","9", "10","11","12"} };
		Object columnNames[] = { "Number", "Name", "Address Line 1", "Address Line 2","City", "State", "Zip", "Email", "Contact","Invoice Freq","Billing Terms","Invoice Grouping"};
		
		if(tool.getClients()!=null && tool.getClients().size()!=0){
			rowData=new Object[tool.getClients().size()][12];
			for(int i=0;i<tool.getClients().size();i++){
				String split[]=((String[])tool.getClients().get(i));
				if(split!=null && split.length>=12){
					rowData[i]=split;
				}
			}
		}
		final JTable ClientTable = new JTable(rowData, columnNames);
		ClientTable.setRowSelectionAllowed(true);
	    ListSelectionModel cellSelectionModel = ClientTable.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
	    	public void valueChanged(ListSelectionEvent e) {
	    		if(ClientTable.getSelectedRow() > -1){
		        	tool.setSelectedTableRowValue(ClientTable.getSelectedRow());		        	
		        }
	    	}
	    });
		JScrollPane scroll = new JScrollPane(ClientTable);
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
		
		JButton addButton = new JButton("Add Client");
		addButton.setBackground(Color.GREEN);		
		addButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addClient(tool);
			}
		});
		addButton.setBounds(50,400,150,30);
		tool.getPanel().add(addButton);		
		
		final JButton updateButton = new JButton("Edit Client");
		updateButton.setBackground(Color.GREEN);		
		updateButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if(tool.getSelectedTableRowValue()!=-1){
//					try{
//						//editClient(tool);
//					}catch(Exception ex){
//						ex.printStackTrace();
//					}
//				}else{
//					JOptionPane.showMessageDialog(updateButton, "Please you should select one row only");
//				}						
			}
		});
		updateButton.setBounds(205,400,170,30);
		tool.getPanel().add(updateButton);
		
		final JButton deleteButton = new JButton("InActive");
		deleteButton.setBackground(Color.GREEN);		
		deleteButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		deleteButton.setBounds(380,400,125,30);
		tool.getPanel().add(deleteButton);
		
		tool.getPanel().repaint();
	}
}
