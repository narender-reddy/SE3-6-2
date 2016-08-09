package tasks;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import menu.MenuScreen;
import service.HeaderScreen;
import service.Tool;

public class TimeApprove {
	public static void timeApprove(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Developer Time Approve");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(200,125,400,20);
		tool.getPanel().add(label);
		
		Object rowData[][]= { { "1", "2", "3","4","5","6"},{ "1", "2", "3","4","5","6"} };
		Object columnNames[] = { "Client Name", "Project Name", "Developer Name", "Hours", "Bill Rate", "Amount"};
		if(tool.getInvoices()!=null && tool.getInvoices().size()!=0){
			rowData=new Object[tool.getInvoices().size()][3];
			for(int i=0;i<tool.getInvoices().size();i++){
				String split[]=((String[])tool.getInvoices().get(i));
				if(split!=null && split.length>=3){
					rowData[i]=split;
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
		
		JButton addButton = new JButton("Approve");
		addButton.setBackground(Color.GREEN);		
		addButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		addButton.setBounds(50,400,175,30);
		tool.getPanel().add(addButton);
		tool.getPanel().repaint();
	}
}
