package service;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import au.com.bytecode.opencsv.CSVReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class MaintainDatabase{

	public void importClientData(){
		try{
			CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir")+"\\src\\client_data.csv"));
			List<String[]> totalClientList=reader.readAll();
			int pointer=0;
			for(String[] client : totalClientList){
				if(pointer!=0){
					saveClientData(client[0],client[1],client[2],client[3],client[4],client[5],client[6],client[7],client[8],client[9],client[10],client[11]);
				}
				pointer++;
			}								
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void importProjectData(){
		try{
			CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir")+"\\src\\project_data.csv"));
			List<String[]> totalProjectList=reader.readAll();
			int pointer=0;
			for(String[] project : totalProjectList){
				if(pointer!=0){
					saveProjectData(project[1],project[0],project[2],project[3],project[4],project[5],project[6],project[7],project[8]);
				}
				pointer++;
			}								
		}catch(Exception ex){
			ex.printStackTrace();
		}	
	}
	
	public void importEmployeeData(){
		try{
			CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir")+"\\src\\people_data.csv"));
			List<String[]> totalEmployeeList=reader.readAll();
			int pointer=0;
			for(String[] employee : totalEmployeeList){
				if(pointer!=0){
					saveEmployeeData(employee[0], employee[1], employee[2], employee[3]);
				}
				pointer++;
			}								
		}catch(Exception ex){
			ex.printStackTrace();
		}	
	}
	
	public Connection dbconnection(){
		Connection connection=null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection =DriverManager.getConnection("jdbc:mysql://localhost/vamshi","root","vamshi");  
		}catch (Exception e){
			e.printStackTrace();
		}
		return connection;
	}	
	
	public void saveClientData(String clientnumber, String clientname, String addressline1, String addressline2, String city, String state, String zip, String email, String contactperson, String invoicefrequency, String billingterms, String invoicegrouping) throws SQLException {
		Connection connection=null;
		PreparedStatement statement=null;
		try{
			connection=dbconnection();
			if(connection!=null){
	    		statement=connection.prepareStatement("insert into client (clientnumber,clientname,addressline1,addressline2,city,state,zip,email,contactperson,invoicefrequency,billingterms,invoicegrouping,inactiveflag) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
	    		statement.setInt(1,Integer.parseInt(clientnumber));
	    		statement.setString(2,clientname);
	    		statement.setString(3,addressline1);
	    		statement.setString(4,addressline2);
	    		statement.setString(5,city);
	    		statement.setString(6,state);
	    		statement.setString(7,zip);
	    		statement.setString(8,email);
	    		statement.setString(9,contactperson);
	    		statement.setString(10,invoicefrequency);
	    		statement.setString(11,billingterms);
	    		statement.setString(12,invoicegrouping);
	    		statement.setString(13,"N");    		
	    		statement.addBatch();
	    		int[] rows=statement.executeBatch();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateClientData(String clientnumber, String clientname, String addressline1, String addressline2, String city, String state, String zip, String email, String contactperson, String invoicefrequency, String billingterms, String invoicegrouping) throws SQLException {
		Connection connection=null;
		PreparedStatement statement=null;
		try{
			connection=dbconnection();
			if(connection!=null){
	    		statement=connection.prepareStatement("update client set clientnumber=?,clientname=?,addressline1=?,addressline2=?,city=?,state=?,zip=?,email=?,contactperson=?,invoicefrequency=?,billingterms=?,invoicegrouping=? where clientnumber=?");
	    		statement.setInt(1,Integer.parseInt(clientnumber));
	    		statement.setString(2,clientname);
	    		statement.setString(3,addressline1);
	    		statement.setString(4,addressline2);
	    		statement.setString(5,city);
	    		statement.setString(6,state);
	    		statement.setString(7,zip);
	    		statement.setString(8,email);
	    		statement.setString(9,contactperson);
	    		statement.setString(10,invoicefrequency);
	    		statement.setString(11,billingterms);
	    		statement.setString(12,invoicegrouping);
	    		statement.setInt(13,Integer.parseInt(clientnumber));
	    		statement.executeUpdate();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void saveProjectData(String projectnumber, String clientnumber, String projectname, String startdate, String enddate, String status, String projectmanagername, String clientcontactname, String projectbudget) throws SQLException {
		Connection connection=null;
		PreparedStatement statement=null;
		try{
			connection=dbconnection();
			if(connection!=null){
	    		statement=connection.prepareStatement("insert into project (projectnumber,clientnumber,projectname,startdate,enddate,status,projectmanagername,clientcontactname,projectbudget,inactiveflag) values (?,?,?,?,?,?,?,?,?,?)");
	    		statement.setInt(1,Integer.parseInt(projectnumber));
	    		statement.setInt(2,Integer.parseInt(clientnumber));
	    		statement.setString(3,projectname);
	    		statement.setString(4,startdate);
	    		statement.setString(5,enddate);
	    		statement.setString(6,status);
	    		statement.setString(7,projectmanagername);
	    		statement.setString(8,clientcontactname);
	    		statement.setDouble(9,Double.parseDouble(projectbudget));
	    		statement.setString(10,"N");    		
	    		statement.addBatch();
	    		int[] rows=statement.executeBatch();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateProjectData(String projectnumber, String clientnumber, String projectname, String startdate, String enddate, String status, String projectmanagername, String clientcontactname, String projectbudget) throws SQLException {
		Connection connection=null;
		PreparedStatement statement=null;
		try{
			connection=dbconnection();
			if(connection!=null){
	    		statement=connection.prepareStatement("update project set projectnumber=?,clientnumber=?,projectname=?,startdate=?,enddate=?,status=?,projectmanagername=?,clientcontactname=?,projectbudget=? where projectnumber=?");
	    		statement.setInt(1,Integer.parseInt(projectnumber));
	    		statement.setInt(2,Integer.parseInt(clientnumber));
	    		statement.setString(3,projectname);
	    		statement.setString(4,startdate);
	    		statement.setString(5,enddate);
	    		statement.setString(6,status);
	    		statement.setString(7,projectmanagername);
	    		statement.setString(8,clientcontactname);
	    		statement.setDouble(9,Double.parseDouble(projectbudget));
	    		statement.setInt(10,Integer.parseInt(projectnumber));    		
	    		statement.executeUpdate();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void saveEmployeeData(String employeename, String employeetitle, String employeebillrate, String employeerole) throws SQLException{
		Connection connection=null;
		PreparedStatement statement=null;
		try{
			connection=dbconnection();
			if(connection!=null){
	    		statement=connection.prepareStatement("insert into employee (employeename,employeetitle,employeebillrate,employeerole,inactiveflag) values (?,?,?,?,?)");
	    		statement.setString(1,employeename);
	    		statement.setString(2,employeetitle);
	    		statement.setString(4,employeerole);
	    		statement.setInt(3,Integer.parseInt(employeebillrate));
	    		statement.setString(5,"N");    		
	    		statement.addBatch();
	    		int[] rows=statement.executeBatch();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateEmployeeData(String employeename, String employeetitle, String employeebillrate, String employeerole) throws SQLException{
		Connection connection=null;
		PreparedStatement statement=null;
		try{
			connection=dbconnection();
			if(connection!=null){
	    		statement=connection.prepareStatement("update employee set employeename=?,employeetitle=?,employeebillrate=?,employeerole=? where employeename=?");
	    		statement.setString(1,employeename);
	    		statement.setString(2,employeetitle);
	    		statement.setString(4,employeerole);
	    		statement.setInt(3,Integer.parseInt(employeebillrate));
	    		statement.setString(5,employeename);    		
	    		statement.executeUpdate();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateWorkApproveData(String workid) throws SQLException{
		Connection connection=null;
		PreparedStatement statement=null;
		try{
			connection=dbconnection();
			if(connection!=null){
	    		statement=connection.prepareStatement("update developerworkhours set pmapprovestatus=? where workid=?");
	    		statement.setString(1,"Y");
	    		statement.setString(2,workid);
	    		statement.executeUpdate();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void inactiveclient(String number) throws SQLException{
		Connection connection=null;
		PreparedStatement statement=null;
		try{
			connection=dbconnection();
			if(connection!=null){
	    		statement=connection.prepareStatement("UPDATE client SET inactiveflag = ? WHERE clientnumber = ?");
	    		statement.setString(1,"N");
	    		statement.setInt(2,Integer.parseInt(number));	    		    		
	    		statement.executeUpdate();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void inactiveproject(String number) throws SQLException{
		Connection connection=null;
		PreparedStatement statement=null;
		try{
			connection=dbconnection();
			if(connection!=null){
	    		statement=connection.prepareStatement("UPDATE project SET inactiveflag = ? WHERE projectnumber = ?");
	    		statement.setString(1,"N");
	    		statement.setInt(2,Integer.parseInt(number));	    		    		
	    		statement.executeUpdate();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void inactiveemployee(String name) throws SQLException{
		Connection connection=null;
		PreparedStatement statement=null;
		try{
			connection=dbconnection();
			if(connection!=null){
	    		statement=connection.prepareStatement("UPDATE employee SET inactiveflag = ? WHERE employeename = ?");
	    		statement.setString(1,"N");
	    		statement.setString(2,name);	    		    		
	    		statement.executeUpdate();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void assignDeveloperData(String projectnumber, String clientnumber, String developername) throws SQLException{
		Connection connection=null;
		PreparedStatement statement=null;
		try{
			connection=dbconnection();
			if(connection!=null){
	    		statement=connection.prepareStatement("insert into assigndeveloper (projectnumber,clientnumber,developername,inactiveflag) values (?,?,?,?)");
	    		statement.setString(1,projectnumber);
	    		statement.setString(2,clientnumber);
	    		statement.setString(3,developername);
	    		statement.setString(4,"N");    		
	    		statement.addBatch();
	    		int[] rows=statement.executeBatch();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void developerworkhours(String projectnumber, String clientnumber, String developername, String date, String numofhours, String billrate) throws SQLException{
		Connection connection=null;
		PreparedStatement statement=null;
		try{
			connection=dbconnection();
			if(connection!=null){
	    		statement=connection.prepareStatement("insert into developerworkhours (projectnumber,clientnumber,developername,date,numofhours,billrate,pmapprovestatus) values (?,?,?,?,?,?,?)");
	    		statement.setInt(1,new Integer(projectnumber).intValue());
	    		statement.setInt(2,new Integer(clientnumber).intValue());
	    		statement.setString(3,developername);
	    		statement.setString(4,date);
	    		statement.setInt(5,new Integer(numofhours).intValue());
	    		statement.setInt(6,new Integer(billrate).intValue());
	    		statement.setString(7,"N");    		
	    		statement.addBatch();
	    		int[] rows=statement.executeBatch();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void saveinvoices(String clientno, String projectno, String amount) throws SQLException{
		Connection connection=null;
		PreparedStatement statement=null;
		try{
			connection=dbconnection();
			if(connection!=null){
	    		statement=connection.prepareStatement("insert into companyinvoices (invoicetranscationnumber,projectnumber,clientnumber,date,totalmoney) values (?,?,?,?,?)");
	    		statement.setInt(1,(100000+new Random().nextInt(8)+50000));
	    		statement.setInt(2,new Integer(projectno).intValue());
	    		statement.setInt(3,new Integer(clientno).intValue());
	    		statement.setString(4,""+new SimpleDateFormat("MM-dd-yyyy").format(new Date()));
	    		statement.setDouble(5,new Double(amount).doubleValue());
	    		statement.addBatch();
	    		int[] rows=statement.executeBatch();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public Vector employeesData(){
		Connection connection=null;
		Statement statement=null;
		Vector employees=null;
		try{
			connection=dbconnection();
			if(connection!=null){
				statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from employee where inactiveflag='N'");
	    		if(rs!=null){
	    			employees=new Vector();
	    			while(rs.next()){
	    				String[] employeeInformation=new String[4];
	    				employeeInformation[0]=rs.getString("employeename");
	    				employeeInformation[1]=rs.getString("employeetitle");
	    				employeeInformation[2]=rs.getString("employeerole");
	    				employeeInformation[3]=""+rs.getInt("employeebillrate");
	    				employees.add(employeeInformation);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }
        return employees;
    }
	
	public Vector employeesDeveloperData(){
		Connection connection=null;
		Statement statement=null;
		Vector employees=null;
		try{
			connection=dbconnection();
			if(connection!=null){
				statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from employee where employeerole='developer' and inactiveflag='N'");
	    		if(rs!=null){
	    			employees=new Vector();
	    			while(rs.next()){
	    				String[] employeeInformation=new String[4];
	    				employeeInformation[0]=rs.getString("employeename");
	    				employeeInformation[1]=rs.getString("employeetitle");
	    				employeeInformation[2]=rs.getString("employeerole");
	    				employeeInformation[3]=""+rs.getInt("employeebillrate");
	    				employees.add(employeeInformation);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }
        return employees;
    }
	
	public Vector projectsData(){
		Connection connection=null;
		Statement statement=null;
		Vector employees=null;
		try{
			connection=dbconnection();
			if(connection!=null){
				statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from project where inactiveflag='N'");
	    		if(rs!=null){
	    			employees=new Vector();
	    			while(rs.next()){
	    				String[] employeeInformation=new String[9];
	    				employeeInformation[0]=""+rs.getInt("projectnumber");
	    				employeeInformation[1]=""+rs.getInt("clientnumber");
	    				employeeInformation[2]=rs.getString("projectname");
	    				employeeInformation[3]=rs.getString("startdate");
	    				employeeInformation[4]=rs.getString("enddate");
	    				employeeInformation[5]=rs.getString("status");
	    				employeeInformation[6]=rs.getString("projectmanagername");
	    				employeeInformation[7]=rs.getString("clientcontactname");
	    				employeeInformation[8]=""+rs.getDouble("projectbudget");
	    				employees.add(employeeInformation);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }
        return employees;
    }
	
	public Vector projectsReportData(){
		Connection connection=null;
		Statement statement=null;
		Vector project=null;
		try{
			connection=dbconnection();
			if(connection!=null){
				statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select c.clientname,p.projectname,p.projectbudget from project p,client c where c.clientnumber=p.clientnumber and p.inactiveflag='N'");
	    		if(rs!=null){
	    			project=new Vector();
	    			while(rs.next()){
	    				String[] projectInformation=new String[9];
	    				projectInformation[0]=rs.getString("clientname");
	    				projectInformation[1]=rs.getString("projectname");
	    				projectInformation[2]=rs.getString("projectbudget");
	    				project.add(projectInformation);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }
        return project;
    }
	
	public Vector invoiceReportData(){
		Connection connection=null;
		Statement statement=null;
		Vector project=null;
		try{
			connection=dbconnection();
			if(connection!=null){
				statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select c.clientname,p.projectname,ci.date,ci.totalmoney,ci.invoicetranscationnumber,ci.clientnumber,ci.projectnumber  from companyinvoices ci,client c,project p where c.clientnumber=ci.clientnumber and p.projectnumber=ci.projectnumber and p.clientnumber=ci.clientnumber");
	    		if(rs!=null){
	    			project=new Vector();
	    			while(rs.next()){
	    				String[] projectInformation=new String[7];
	    				projectInformation[0]=rs.getString("clientname");
	    				projectInformation[1]=rs.getString("projectname");
	    				projectInformation[2]=rs.getString("date");
	    				projectInformation[3]=rs.getString("totalmoney");
	    				projectInformation[4]=rs.getString("invoicetranscationnumber");
	    				projectInformation[5]=rs.getString("clientnumber");
	    				projectInformation[6]=rs.getString("projectnumber");
	    				project.add(projectInformation);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }
        return project;
    }
	
	public Vector employeeReportData(){
		Connection connection=null;
		Statement statement=null;
		Vector project=null;
		try{
			connection=dbconnection();
			if(connection!=null){
				statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select emp.employeename,emp.employeetitle,emp.employeerole,emp.employeebillrate,dwh.date,dwh.numofhours,(dwh.numofhours*emp.employeebillrate) from employee emp,developerworkhours dwh where dwh.developername=emp.employeename and emp.inactiveflag='N'");
	    		if(rs!=null){
	    			project=new Vector();
	    			while(rs.next()){
	    				String[] projectInformation=new String[7];
	    				projectInformation[0]=rs.getString("employeename");
	    				projectInformation[1]=rs.getString("employeetitle");
	    				projectInformation[2]=rs.getString("employeerole");
	    				projectInformation[3]=rs.getString("employeebillrate");
	    				projectInformation[4]=rs.getString("date");
	    				projectInformation[5]=rs.getString("numofhours");
	    				projectInformation[6]=rs.getString("(dwh.numofhours*emp.employeebillrate)");
	    				project.add(projectInformation);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }
        return project;
    }
	
	public Vector employeeTimeAproveData(){
		Connection connection=null;
		Statement statement=null;
		Vector project=null;
		try{
			connection=dbconnection();
			if(connection!=null){
				statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from developerworkhours where pmapprovestatus='N'");
	    		if(rs!=null){
	    			project=new Vector();
	    			while(rs.next()){
	    				String[] projectInformation=new String[9];
	    				projectInformation[0]=rs.getString("workid");
	    				projectInformation[1]=rs.getString("projectnumber");
	    				projectInformation[2]=rs.getString("clientnumber");
	    				projectInformation[3]=rs.getString("developername");
	    				projectInformation[4]=rs.getString("date");
	    				projectInformation[5]=rs.getString("numofhours");
	    				projectInformation[6]=rs.getString("billrate");
	    				projectInformation[7]=""+(Integer.parseInt(rs.getString("numofhours"))*Integer.parseInt(rs.getString("billrate")));
	    				projectInformation[8]=rs.getString("pmapprovestatus");
	    				project.add(projectInformation);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }
        return project;
    }
	
	public Vector employeeTimeAprovedInformationList(String clientno,String projectno){
		Connection connection=null;
		Statement statement=null;
		Vector project=null;
		try{
			connection=dbconnection();
			if(connection!=null){
				statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from developerworkhours where clientnumber="+clientno+" and projectnumber="+projectno+" and pmapprovestatus='Y'");
	    		if(rs!=null){
	    			project=new Vector();
	    			while(rs.next()){
	    				String[] projectInformation=new String[9];
	    				projectInformation[0]=rs.getString("workid");
	    				projectInformation[1]=rs.getString("projectnumber");
	    				projectInformation[2]=rs.getString("clientnumber");
	    				projectInformation[3]=rs.getString("developername");
	    				projectInformation[4]=rs.getString("date");
	    				projectInformation[5]=rs.getString("numofhours");
	    				projectInformation[6]=rs.getString("billrate");
	    				projectInformation[7]=""+(Integer.parseInt(rs.getString("numofhours"))*Integer.parseInt(rs.getString("billrate")));
	    				projectInformation[8]=rs.getString("pmapprovestatus");
	    				project.add(projectInformation);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }
        return project;
    }
	
	public Vector totalInvoiceApprovedHours(){
		Connection connection=null;
		Statement statement=null;
		Vector project=null;
		try{
			connection=dbconnection();
			if(connection!=null){
				statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select clientnumber,projectnumber,sum(numofhours*billrate) from developerworkhours where pmapprovestatus='Y' group by clientnumber,projectnumber");
	    		if(rs!=null){
	    			project=new Vector();
	    			while(rs.next()){
	    				String[] projectInformation=new String[9];
	    				projectInformation[0]=""+rs.getString("clientnumber");
	    				projectInformation[1]=""+rs.getString("projectnumber");
	    				projectInformation[2]=""+rs.getInt("sum(numofhours*billrate)");
	    				project.add(projectInformation);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }
        return project;
    }
	
	public String[] employeeinformation(String employeename){
		Connection connection=null;
		Statement statement=null;
		String[] employeeInformation=null;
		try{
			connection=dbconnection();
			if(connection!=null){
				statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from employee where employeename='"+employeename+"' and inactiveflag='N'");
	    		if(rs!=null){
	    			while(rs.next()){
	    				employeeInformation=new String[4];
	    				employeeInformation[0]=rs.getString("employeename");
	    				employeeInformation[1]=rs.getString("employeetitle");
	    				employeeInformation[2]=rs.getString("employeerole");
	    				employeeInformation[3]=""+rs.getInt("employeebillrate");
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }
        return employeeInformation;
    }
	
	public String[] projectinformation(String clientno,String projectno){
		Connection connection=null;
		Statement statement=null;
		String[] employeeInformation=null;
		try{
			connection=dbconnection();
			if(connection!=null){
				statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from project where clientnumber="+clientno+" and projectnumber="+projectno+" and inactiveflag='N'");
	    		if(rs!=null){
	    			while(rs.next()){
	    				employeeInformation=new String[9];
	    				employeeInformation[0]=""+rs.getInt("projectnumber");
	    				employeeInformation[1]=""+rs.getInt("clientnumber");
	    				employeeInformation[2]=rs.getString("projectname");
	    				employeeInformation[3]=rs.getString("startdate");
	    				employeeInformation[4]=rs.getString("enddate");
	    				employeeInformation[5]=rs.getString("status");
	    				employeeInformation[6]=rs.getString("projectmanagername");
	    				employeeInformation[7]=rs.getString("clientcontactname");
	    				employeeInformation[8]=""+rs.getDouble("projectbudget");
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }
        return employeeInformation;
    }
	
	public String[] clientinformation(String clientnumber){
		Connection connection=null;
		Statement statement=null;
		String[] employeeInformation=null;
		try{
			connection=dbconnection();
			if(connection!=null){
				statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from client where clientnumber="+clientnumber+" and inactiveflag='N'");
	    		if(rs!=null){
	    			while(rs.next()){
	    				employeeInformation=new String[12];
	    				employeeInformation[0]=""+rs.getInt("clientnumber");
	    				employeeInformation[1]=rs.getString("clientname");
	    				employeeInformation[2]=rs.getString("addressline1");
	    				employeeInformation[3]=rs.getString("addressline2");
	    				employeeInformation[4]=rs.getString("city");
	    				employeeInformation[5]=rs.getString("state");
	    				employeeInformation[6]=""+rs.getInt("zip");
	    				employeeInformation[7]=rs.getString("email");
	    				employeeInformation[8]=rs.getString("contactperson");
	    				employeeInformation[9]=rs.getString("invoicefrequency");
	    				employeeInformation[10]=rs.getString("billingterms");
	    				employeeInformation[11]=rs.getString("invoicegrouping");
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }
        return employeeInformation;
    }
	
	public Vector developerProjectsData(String developername){
		Connection connection=null;
		Statement statement=null;
		Vector employees=null;
		try{
			connection=dbconnection();
			if(connection!=null){
				statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select projectnumber,clientnumber from assigndeveloper where developername='"+developername+"' and inactiveflag='N'");
	    		if(rs!=null){
	    			employees=new Vector();
	    			while(rs.next()){
	    				String[] assignprojects=new String[2];
	    				assignprojects[0]=""+rs.getInt("projectnumber");
	    				assignprojects[1]=""+rs.getInt("clientnumber");
	    				employees.add(assignprojects);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }
        return employees;
    }
	
	public Vector clientsData(){
		Connection connection=null;
		Statement statement=null;
		Vector employees=null;
		try{
			connection=dbconnection();
			if(connection!=null){
				statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from client where inactiveflag='N'");
	    		if(rs!=null){
	    			employees=new Vector();
	    			while(rs.next()){
	    				String[] employeeInformation=new String[12];
	    				employeeInformation[0]=""+rs.getInt("clientnumber");
	    				employeeInformation[1]=rs.getString("clientname");
	    				employeeInformation[2]=rs.getString("addressline1");
	    				employeeInformation[3]=rs.getString("addressline2");
	    				employeeInformation[4]=rs.getString("city");
	    				employeeInformation[5]=rs.getString("state");
	    				employeeInformation[6]=""+rs.getInt("zip");
	    				employeeInformation[7]=rs.getString("email");
	    				employeeInformation[8]=rs.getString("contactperson");
	    				employeeInformation[9]=rs.getString("invoicefrequency");
	    				employeeInformation[10]=rs.getString("billingterms");
	    				employeeInformation[11]=rs.getString("invoicegrouping");
	    				employees.add(employeeInformation);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }
        return employees;
    }
	
	public String[] checkEmployeeData(String employeename){
		Connection connection=null;
		Statement statement=null;
		String[] employee=null;
		try{
			connection=dbconnection();
			if(connection!=null){
				statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from employee where employeename='"+employeename+"'");
	    		if(rs!=null){
	    			while(rs.next()){
	    				employee=new String[4];
	    				employee[0]=rs.getString("employeename");
	    				employee[1]=rs.getString("employeetitle");
	    				employee[2]=rs.getString("employeerole");
	    				employee[3]=""+rs.getInt("employeebillrate");
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }
        return employee;
    }
	private BaseFont fontstyle,tempfont;
	private int pageNumber = 0;
	private void savePDF(String[] clientinformation,String[] projectinformation,Vector employeeTimeApproved,String[] invoiceInformation){
		 Document document_pdf = new Document();
		 PdfWriter document_pdf_writer = null;
		 fonts();
		 try {
			 String path = "C://Users//vamshi//Desktop//"+clientinformation[1]+".pdf";
			 document_pdf_writer = PdfWriter.getInstance(document_pdf , new FileOutputStream(path));
			 document_pdf.addAuthor("");
			 document_pdf.addCreationDate();
			 document_pdf.addProducer();
			 document_pdf.addCreator("");
			 document_pdf.addTitle("PDF");
			 document_pdf.setPageSize(PageSize.LETTER);
			 document_pdf.open();
			 PdfContentByte pdfcontentByte = document_pdf_writer.getDirectContent();	   
			 boolean starts = true;
			 pdftextdisplay(pdfcontentByte,400,760,"Eagle Consulting Invoice");
			 int height=0;
			 for(int width=0;width<employeeTimeApproved.size();width++){
				 String[] developinvoicedata=(String[])employeeTimeApproved.get(width);
				 if(starts){
					 starts = false;
					 invoicedetails(document_pdf,pdfcontentByte,invoiceInformation); 
					 companydata(pdfcontentByte,clientinformation,invoiceInformation,projectinformation);
					 height = 507; 
				 }
				 developertableformatdata(pdfcontentByte,width,height,developinvoicedata);
				 height = height - 15;
				 if(height < 50){
					 displaypageNumber(pdfcontentByte);
					 document_pdf.newPage();
					 starts = true;
				 }
			 }
			 pdftextdisplay(pdfcontentByte,50,150,"Remit Payment To:");
			 pdftextdisplay(pdfcontentByte,75,135,"Eagle Consulting");
			 pdftextdisplay(pdfcontentByte,75,120,"2501 E Memorial Road");
			 pdftextdisplay(pdfcontentByte,75,105,"Edmond, Ok 73013");			 
			 displaypageNumber(pdfcontentByte);
		 }catch(DocumentException dex){
			 dex.printStackTrace();
		 }
		 catch(Exception ex){
			 ex.printStackTrace();
		 }finally{
			 if(document_pdf != null){
				 document_pdf.close();
			 }
			 if(document_pdf_writer != null){
				 document_pdf_writer.close();
			 }
		 }
	 }
	 private void invoicedetails(Document documentpdf, PdfContentByte cb,String[] invoiceinformation){
		 try{
			 cb.setLineWidth(1f);
			 cb.rectangle(40,615,510,120);
			 cb.moveTo(275,735);
			 cb.lineTo(275,615);
			 cb.stroke();
			 pdftextdisplay(cb,375,723,"Invoice Number: "+invoiceinformation[0]);
			 pdftextdisplay(cb,375,703,"Invoice Date: "+new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
			 pdftextdisplay(cb,375,683,"Payment Terms: ");
			 pdftextdisplay(cb,375,663,"Billing Frequency: ");
			 pdftextdisplay(cb,375,643,"Total Amount Due: $");
			 cb.rectangle(20,50,550,410); 
			 pdftextdisplay(cb,50,525,"Date");
			 pdftextdisplay(cb,150,525,"Description");
			 pdftextdisplay(cb,400,525,"Rate");
			 pdftextdisplay(cb,450,525,"Hours");
			 pdftextdisplay(cb,500,525,"Amount");
			 Image companyLogo = Image.getInstance(System.getProperty("user.dir")+"\\src\\eagles_logo.jpg");
			 companyLogo.setAbsolutePosition(50,750);
			 companyLogo.scalePercent(25);
			 documentpdf.add(companyLogo);
		 }catch (Exception dex){
			 dex.printStackTrace();
		 }
	 }
	 
	 private void companydata(PdfContentByte contentbyte,String[] clientinformation,String[] invoiceinformation,String[] projectinformation){
		 try{
			 pdftextdisplay(contentbyte,75,723,clientinformation[1]);
			 pdftextdisplay(contentbyte,75,708,clientinformation[2]);
			 pdftextdisplay(contentbyte,75,693,clientinformation[3]);
			 pdftextdisplay(contentbyte,75,678,clientinformation[4]+","+clientinformation[5]+" - "+clientinformation[6]);
			 pdftextdisplay(contentbyte,75,663,"United States");
			 pdftextdisplay(contentbyte,75,648,"Client ID#: "+clientinformation[0]);
			 pdftextdisplay(contentbyte,75,633,projectinformation[2]);			 
			 pdftextdisplay(contentbyte,475,683,clientinformation[10]);
			 pdftextdisplay(contentbyte,475,663,clientinformation[9]);
			 pdftextdisplay(contentbyte,475,643,invoiceinformation[4]);
		 }catch (Exception ex){
			 ex.printStackTrace();
		 }
	 }
	 
	 private void developertableformatdata(PdfContentByte contentbyte,int index,int y,String[] developinvoicedata){
		 DecimalFormat df = new DecimalFormat("0.00");
		 try{
			 int rightside=PdfContentByte.ALIGN_RIGHT;
			 int leftside=PdfContentByte.ALIGN_LEFT;
			 content(contentbyte,110,y,developinvoicedata[4],rightside);
			 content(contentbyte,150,y,developinvoicedata[3],leftside);
			 content(contentbyte,400,y,developinvoicedata[5],leftside);
			 content(contentbyte,465,y,developinvoicedata[6],rightside);
			 content(contentbyte,520,y,""+((Integer.parseInt(developinvoicedata[6])*(Integer.parseInt(developinvoicedata[5])))),PdfContentByte.ALIGN_RIGHT);
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }
	 }

	 private void pdftextdisplay(PdfContentByte contentbyte, float x, float y, String text){
		 contentbyte.beginText();
		 contentbyte.setFontAndSize(fontstyle, 9);
		 contentbyte.setTextMatrix(x,y);
		 contentbyte.showText(text.trim());
		 contentbyte.endText();
	 }
	 
	 private void displaypageNumber(PdfContentByte contentbyte){
		 contentbyte.beginText();
		 contentbyte.setFontAndSize(fontstyle, 8);
		 contentbyte.showTextAligned(PdfContentByte.ALIGN_RIGHT, "Page No. " + (pageNumber+1), 570 , 25, 0);
		 contentbyte.endText();
		 pageNumber++;	  
	 }
	 
	 private void content(PdfContentByte contentbyte,float xcord,float ycord,String displaytext,int position){
		 contentbyte.beginText();
		 contentbyte.setFontAndSize(tempfont, 8);
		 contentbyte.showTextAligned(position, displaytext.trim(),xcord,ycord, 0);
		 contentbyte.endText(); 
	 }

	 private void fonts(){
		 try {
			 fontstyle=BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			 tempfont = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
		 }catch(DocumentException e){
			 e.printStackTrace();
		 }catch(IOException e){
			 e.printStackTrace();
		 }
	}	
	public void saveInvoicePdf(String[] clientinformation,String[] projectinformation,Vector employeeTimeApproved,String[] invoiceInformation){
		savePDF(clientinformation,projectinformation,employeeTimeApproved,invoiceInformation);
	}
}
