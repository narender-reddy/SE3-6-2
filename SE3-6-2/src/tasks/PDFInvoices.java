package tasks;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import menu.MenuScreen;
import service.HeaderScreen;
import service.MaintainDatabase;
import service.Tool;

public class PDFInvoices {	
	public static void viewInvoices(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("View Invoices");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(200,125,250,20);
		tool.getPanel().add(label);
		
		Object rowData[][]= { { "1", "2", "3","4"},{ "1", "2", "3","4"} };
		Object columnNames[] = { "Client Name", "Project Name", "Invoice Date","Total Amount"};
		MaintainDatabase maintainDatabase=new MaintainDatabase();
		Vector project=maintainDatabase.totalInvoiceApprovedHours();
		if(project!=null && project.size()!=0){
			rowData=new Object[project.size()][5];
			for(int i=0;i<project.size();i++){
				String split[]=((String[])project.get(i));
				if(split!=null){
					rowData[i][0]=split[0];
					rowData[i][1]=split[1];
					rowData[i][2]=""+new SimpleDateFormat("MM-dd-yyyy").format(new Date());
					rowData[i][3]=split[2];
					try{
						maintainDatabase.saveinvoices(split[0], split[1], split[2]);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}
		}
		final JTable semesterTable = new JTable(rowData, columnNames);
		semesterTable.setRowSelectionAllowed(true);
	    ListSelectionModel cellSelectionModel = semesterTable.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
	    	public void valueChanged(ListSelectionEvent e) {
	    		if(semesterTable.getSelectedRow() > -1){
		        	tool.setSelectedTableRowValue(semesterTable.getSelectedRow());		        	
		        }
	    	}
	    });
		JScrollPane scroll = new JScrollPane(semesterTable);
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
		
		final JButton addButton = new JButton("Save PDF");
		addButton.setBackground(Color.GREEN);		
		addButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintainDatabase maintainDatabase=new MaintainDatabase();
				Vector project=maintainDatabase.invoiceReportData();
				if(project!=null && project.size()!=0){
					for(int i=0;i<project.size();i++){
						String invoicesplit[]=((String[])project.get(i));
						String[] clientinformation=maintainDatabase.clientinformation(invoicesplit[5]);
						String[] projectinformation=maintainDatabase.projectinformation(invoicesplit[5], invoicesplit[6]);
						Vector empTimeApproved=maintainDatabase.employeeTimeAprovedInformationList(invoicesplit[5], invoicesplit[6]);
						maintainDatabase.saveInvoicePdf(clientinformation,projectinformation,empTimeApproved,invoicesplit);						
					}
					JOptionPane.showMessageDialog(addButton, "Consultency successfully sent invoices to clients");
				}
			}
		});
		addButton.setBounds(50,400,175,30);
		tool.getPanel().add(addButton);
		tool.getPanel().repaint();
	}
}
