package service;

import java.util.HashMap;
import java.util.Vector;

import javax.swing.JPanel;

public class Tool {
	private String userType;
	private String userName;
	private JPanel panel;
	private Vector employees;
	private JPanel subPanel;
	private JPanel subPanel1;
	private Vector clients;
	private Vector projects;
	private int selectedTableRowValue;
	private Vector invoices;
	private MaintainDatabase maintainDatabase;
	
	public MaintainDatabase getMaintainDatabase() {
		return maintainDatabase;
	}
	public void setMaintainDatabase(MaintainDatabase maintainDatabase) {
		this.maintainDatabase = maintainDatabase;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Vector getInvoices() {
		return invoices;
	}
	public void setInvoices(Vector invoices) {
		this.invoices = invoices;
	}
	public int getSelectedTableRowValue() {
		return selectedTableRowValue;
	}
	public void setSelectedTableRowValue(int selectedTableRowValue) {
		this.selectedTableRowValue = selectedTableRowValue;
	}
	public Vector getEmployees() {
		return employees;
	}
	public void setEmployees(Vector employees) {
		this.employees = employees;
	}
	public Vector getProjects() {
		return projects;
	}
	public void setProjects(Vector projects) {
		this.projects = projects;
	}
	public Vector getClients() {
		return clients;
	}
	public void setClients(Vector clients) {
		this.clients = clients;
	}
	public JPanel getSubPanel1() {
		return subPanel1;
	}
	public void setSubPanel1(JPanel subPanel1) {
		this.subPanel1 = subPanel1;
	}
	public JPanel getSubPanel() {
		return subPanel;
	}
	public void setSubPanel(JPanel subPanel) {
		this.subPanel = subPanel;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}	
}
