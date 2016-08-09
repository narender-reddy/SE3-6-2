package tasks;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import menu.MenuScreen;
import service.HeaderScreen;
import service.MaintainDatabase;
import service.Tool;

public class Reports {
	static MaintainDatabase readWriteCSVFile=new MaintainDatabase();
	public static void generateReports(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Reports");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		final JButton invoiceReportButton = new JButton("Invoice Report");
		invoiceReportButton.setBackground(Color.GREEN);		
		invoiceReportButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		invoiceReportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoiceReports(tool);
			}
		});
		if(tool!=null && tool.getUserType()!=null && (tool.getUserType().equalsIgnoreCase("Accountant"))){
			invoiceReportButton.setBounds(135,200,300,30);
			tool.getPanel().add(invoiceReportButton);
		}
		
		final JButton projectReporttButton = new JButton("Project Report");
		projectReporttButton.setBackground(Color.GREEN);		
		projectReporttButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		projectReporttButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				projectReports(tool);
			}
		});
		projectReporttButton.setBounds(135,250,300,30);
		tool.getPanel().add(projectReporttButton);
		
		final JButton employeeReportButton = new JButton("Employee Report");
		employeeReportButton.setBackground(Color.GREEN);		
		employeeReportButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		employeeReportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeeReports(tool);
			}
		});
		employeeReportButton.setBounds(135,300,300,30);
		tool.getPanel().add(employeeReportButton);
		
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(125,400,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(325,400,100,30);
		tool.getPanel().add(cancelButton);
		
		tool.getPanel().repaint();
	}
	
	public static void projectReports(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Project Reports");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(175,125,350,20);
		tool.getPanel().add(label);
		
		Object rowData[][]= { { "Data", "Data", "Data"},
                			{ "Data", "Data", "Data"} };
		Object columnNames[] = { "Client Name", "Project Name", "Budget"};
		
		final JTable courseTable = new JTable(rowData, columnNames);
		courseTable.setRowSelectionAllowed(true);
		JScrollPane scroll = new JScrollPane(courseTable);
		scroll.setBounds(50, 150, 450, 150);
		tool.getPanel().add(scroll);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(125,460,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(325,460,100,30);
		tool.getPanel().add(cancelButton);
		
		tool.getPanel().repaint();
	}
	
	public static void employeeReports(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Employee Reports");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		Object rowData[][]= { { "Data", "Data", "Data", "Data", "Data", "Data", "Data"},
                			{ "Data", "Data", "Data", "Data", "Data", "Data", "Data"} };
		Object columnNames[] = { "Name", "Title", "Role", "Bill Rate", "Date", "Worked Hours", "Total Pay Amount"};
		
		final JTable courseTable = new JTable(rowData, columnNames);
		courseTable.setRowSelectionAllowed(true);
		JScrollPane scroll = new JScrollPane(courseTable);
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
		exitButton.setBounds(125,400,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(325,400,100,30);
		tool.getPanel().add(cancelButton);
		
		tool.getPanel().repaint();
	}	
	
	public static void invoiceReports(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Invoice Reports");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		Object rowData[][]= { { "Data", "Data", "Data", "Data"},
                { "Data", "Data", "Data", "Data"} };
		
		Object columnNames[] = { "Client Name", "Project Name", "Invoice Date", "Total Amount"};
		
		JTable table = new JTable(rowData, columnNames);
		JScrollPane scroll = new JScrollPane(table);
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
		exitButton.setBounds(125,400,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(325,400,100,30);
		tool.getPanel().add(cancelButton);
		
		tool.getPanel().repaint();
	}
}
