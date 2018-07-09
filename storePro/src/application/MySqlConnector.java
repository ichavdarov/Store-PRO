package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.CallableStatement;

public class MySqlConnector {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private  String accessLevel;
	private int userId=0;
	private boolean logIn=true;
		public void setLogIn(boolean logIn) {
		this.logIn = logIn;
	}
		public int getUserId() {
		return userId;
	}
		public Connection getConnection() throws Exception{
		try{
			String url="jdbc:mysql://localhost:3306/storepro?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";//using local host, IP can be used
		    String username= "root";
		    String password="root";
	
		    Connection conn=DriverManager.getConnection(url,username,password);
		    System.out.println("connected");
		    return conn;
		}
		catch(Exception e){
			System.out.println("not connected");
			System.out.println(e);
		}
		return null;
	}
		public boolean LogIn(String user,String  passwordStr){
			Boolean bl=true;
			PreparedStatement st = null;
		    ResultSet rs;
		    java.sql.CallableStatement cs = null;
		    
			//String passwordStr= new String(passwordStr);
		    try(Connection con=getConnection()){
		    	cs = con.prepareCall("{call logIn(?,?)}");

		        cs.setString(1, user);

		        cs.setString(2, passwordStr);  

		        rs = cs.executeQuery();	            				         		       		            
		        int cnt = 0;
		        while( rs.next()){
		        userId=rs.getInt("id");    
		        accessLevel=rs.getString("accessLevel");
		        cnt+=1;
		         }
		         		
		         		
		       	if(cnt==1){
		       	//  if(logIn)
		       	bl=true;
		       	}
		       	else{
		    	bl=false; 
		    	}
		        }catch(Exception ex){
		        	 System.out.println("hahah2");
		        }
			return bl; 
		      }
		public boolean getProductInThisStrore(){
			Boolean bl=true;
			PreparedStatement st = null;
		    ResultSet rs;
		    java.sql.CallableStatement cs = null;
		    
			//String passwordStr= new String(passwordStr);
		    try(Connection con=getConnection()){
		    //	cs = con.prepareCall("{call logIn(?,?)}");

		 //       cs.setString(1, user);

		     //   cs.setString(2, passwordStr);  

		        rs = cs.executeQuery();	            				         		       		            
		        int cnt = 0;
		        while( rs.next()){
		        userId=rs.getInt("id");    
		        accessLevel=rs.getString("accessLevel");
		        cnt+=1;
		         }
		         		
		         		
		       	if(cnt==1){
		       	//  if(logIn)
		       	bl=true;
		       	}
		       	else{
		    	bl=false; 
		    	}
		        }catch(Exception ex){
		        	 System.out.println("hahah2");
		        }
			return bl; 
		      }

}
