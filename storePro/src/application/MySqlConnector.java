package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.CallableStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MySqlConnector {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private  String accessLevel;
	private static int userId=0;
	private static int shop_id=0;
	private boolean logIn=true;
	private static Connection conn;
	public MySqlConnector() {
		try {
			MySqlConnector.conn=getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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
	
		     conn=DriverManager.getConnection(url,username,password);
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
		    try{
		    	cs = conn.prepareCall("{call logIn(?,?)}");

		        cs.setString(1, user);

		        cs.setString(2, passwordStr);  

		        rs = cs.executeQuery();	            				         		       		            
		        int cnt = 0;
		        
		        while( rs.next()){
		        userId=rs.getInt("id");    
	       	

		        accessLevel=rs.getString("accessLevel");
		     
		        shop_id=rs.getInt("shop_id"); 
	
		        cnt+=1;
		         }
		        
		       	if(cnt==1){
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
		public ObservableList<Product> getProductsInThisStrore(){
			Boolean bl=true;
			ObservableList<Product> products=FXCollections.observableArrayList();
			PreparedStatement st = null;
		    ResultSet rs;
		    java.sql.CallableStatement cs = null;
		    try{
		    	cs = conn.prepareCall("{call getProductsFromStore(?)}");
		    	cs.setString(1, Integer.toString(shop_id));
   		        rs = cs.executeQuery();	            				         		       		            
		        int cnt = 0;
		        while(rs.next()){
		        Product product=new Product();
		        product.setStorageId(rs.getInt("id"));
		        product.setName(rs.getString("name")); 
		        product.setCategory(rs.getString("category")); 
		        product.setBarcode(rs.getString("barcode"));
		        product.setClientPrice(rs.getBigDecimal(("clientPrice")));
		        product.setDescription(rs.getString("description"));
		        product.setQuantity(rs.getInt("quantity"));
		        products.add(product);
		        cnt+=1;
		         }

		        }catch(Exception ex){
		        	 System.out.println("hahah2");
		        }
		
			return products; 
		      }

}
