package tasks;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import menu.MenuScreen;
import service.HeaderScreen;
import service.MaintainDatabase;
import service.Tool;

public class InvoiceHelp {
	public static void helpButton(final JPanel panel,final Tool tool){
		panel.removeAll();
		
		//HeaderScreen headerScreen=new HeaderScreen();
		//headerScreen.getHeaderMenuScreen(tool);
		tool.setPanel(panel);
		JButton accountantButton = new JButton("ACCOUNTANT");
		accountantButton.setBackground(Color.GREEN);		
		accountantButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		accountantButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tool.setHelpType("ACCOUNTANT");
				instructions(tool);
			}
		});
		accountantButton.setBounds(250,150,200,35);
		tool.getPanel().add(accountantButton);
		
		JButton projectmanagerButton = new JButton("PROJECT MANAGER");
		projectmanagerButton.setBackground(Color.GREEN);		
		projectmanagerButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		projectmanagerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tool.setHelpType("PROJECT MANAGER");
				instructions(tool);	
			}
		});
		projectmanagerButton.setBounds(250,200,200,35);
		tool.getPanel().add(projectmanagerButton);		
		
		JButton developerButton = new JButton("DEVELOPER");
		developerButton.setBackground(Color.GREEN);		
		developerButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		developerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tool.setHelpType("DEVELOPER");
				instructions(tool);
			}
		});
		developerButton.setBounds(250,250,200,35);
		tool.getPanel().add(developerButton);
		
		JButton clientButton = new JButton("CLIENT");
		clientButton.setBackground(Color.GREEN);		
		clientButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		clientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tool.setHelpType("CLIENT");
				instructions(tool);
			}
		});
		clientButton.setBounds(250,300,200,35);
		tool.getPanel().add(clientButton);
		
		tool.getPanel().repaint();
	}
	
	public static void helpButton(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
				
		JButton accountantButton = new JButton("ACCOUNTANT");
		accountantButton.setBackground(Color.GREEN);		
		accountantButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		accountantButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tool.setHelpType("ACCOUNTANT");
				instructions(tool);
			}
		});
		accountantButton.setBounds(250,150,200,35);
		tool.getPanel().add(accountantButton);
		
		JButton projectmanagerButton = new JButton("PROJECT MANAGER");
		projectmanagerButton.setBackground(Color.GREEN);		
		projectmanagerButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		projectmanagerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tool.setHelpType("PROJECT MANAGER");
				instructions(tool);	
			}
		});
		projectmanagerButton.setBounds(250,200,200,35);
		tool.getPanel().add(projectmanagerButton);		
		
		JButton developerButton = new JButton("DEVELOPER");
		developerButton.setBackground(Color.GREEN);		
		developerButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		developerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tool.setHelpType("DEVELOPER");
				instructions(tool);
			}
		});
		developerButton.setBounds(250,250,200,35);
		tool.getPanel().add(developerButton);
		
		JButton clientButton = new JButton("CLIENT");
		clientButton.setBackground(Color.GREEN);		
		clientButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		clientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tool.setHelpType("CLIENT");
				instructions(tool);
			}
		});
		clientButton.setBounds(250,300,200,35);
		tool.getPanel().add(clientButton);
		
		tool.getPanel().repaint();
	}
	
	public static void instructions(final Tool tool){
//		HeaderScreen headerScreen=new HeaderScreen();
//		headerScreen.getHeaderMenuScreen(tool);
		tool.getPanel().removeAll();
		ImageIcon image = null;
		if(tool.getHelpType()!=null && tool.getHelpType().equalsIgnoreCase("ACCOUNTANT")){
			new ImageIcon(System.getProperty("user.dir")+"/src/eagles_logo.jpg");
		}
		if(tool.getHelpType()!=null && tool.getHelpType().equalsIgnoreCase("PROJECT MANAGER")){
			new ImageIcon(System.getProperty("user.dir")+"/src/eagles_logo.jpg");
		}
		if(tool.getHelpType()!=null && tool.getHelpType().equalsIgnoreCase("DEVELOPER")){
			new ImageIcon(System.getProperty("user.dir")+"/src/eagles_logo.jpg");
		}
		if(tool.getHelpType()!=null && tool.getHelpType().equalsIgnoreCase("CLIENT")){
			new ImageIcon(System.getProperty("user.dir")+"/src/eagles_logo.jpg");
		}
		
		System.out.println(tool.getHelpType());
		
		JLabel labelimage = new JLabel("", image, JLabel.CENTER);
		labelimage.setBounds(150, 150, 350, 400);
		tool.getPanel().add(labelimage);
		
		tool.getPanel().repaint();
	}
}
