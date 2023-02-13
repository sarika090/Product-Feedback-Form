package product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import product.bo.AddFeedback_bo;
import product.bo.Product_bo;

public class Product_dao {
	
	public static Connection getConnection() {
		

		Connection con=null;
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_feedback","root","sarika");
		
		}catch(Exception e) {
			System.out.println(e);
			
		}
		
		return con;
	}
	
		public static int signup(Product_bo pr) {
			
			int status=0;
			
			try {
				Connection con = Product_dao.getConnection();
				String sql="insert into signup(name,email,phone,password) values(?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, pr.getName());
				ps.setString(2, pr.getEmail());
				ps.setString(3, pr.getPhone());
				ps.setString(4, pr.getPass());
				
				status = ps.executeUpdate();
				
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
			return status;
		
		
	}
		
		public static boolean userLogin(String email,String pass) {
			boolean status=false;
			
			try {
				
				Connection con=Product_dao.getConnection();
				String sql="select * from signup where email=? And password=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,email);
				ps.setString(2,pass);
				
				ResultSet rs=ps.executeQuery();
				status=rs.next();
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return status;
		}
		
		public static int AddFeedback(AddFeedback_bo fb) {
			int status =0;
			
			try {
				

				Connection con=Product_dao.getConnection();
				String query = "insert into addfeedback(name,email,phone,comment,rating) values(?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(query);
				
				ps.setString(1, fb.getName());
				ps.setString(2, fb.getEmail());
				ps.setString(3, fb.getPhone());
				ps.setString(4, fb.getComment());
				ps.setString(5, fb.getRating());
				
				status = ps.executeUpdate();
					} catch (Exception e) {
				System.out.println(e);
			}
			
			return status;
			
		}
		
		public static List getAllEmployee() {
			
			List list=new ArrayList();
			try {
				
				
				Connection con=Product_dao.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from addfeedback");
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					AddFeedback_bo fb=new AddFeedback_bo();
					
					fb.setId(rs.getInt(1));
					fb.setName(rs.getString(2));
					fb.setEmail(rs.getString(3));
					fb.setPhone(rs.getString(4));
					fb.setComment(rs.getString(5));
					fb.setRating(rs.getString(6));
					
					list.add(fb);
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
			return list;
			
		}
			
		public static AddFeedback_bo getMemberById(int id) {
			   AddFeedback_bo fb=new AddFeedback_bo();
			   try {
				   Connection con=Product_dao.getConnection();
				   String query="select * from addfeedback where id=?";
				   
				   PreparedStatement ps=con.prepareStatement(query);
				   ps.setInt(1, id);
				   
				   ResultSet rs=ps.executeQuery();
				   
				  if(rs.next()) {
					  
					   fb.setId(rs.getInt(1)); 
					   fb.setName(rs.getString(2));
					   fb.setEmail(rs.getString(3));
					   fb.setPhone(rs.getString(4));
					   fb.setComment(rs.getString(5));
					   fb.setRating(rs.getString(6));
					  
					   }
				   
			   }catch(Exception e) {
				   System.out.println(e);
			   }
			   
		   
		   return fb;
			   
		   }
		
		public static int Update(AddFeedback_bo fb) {
			int status=0;
			
			try {
				
				Connection con=Product_dao.getConnection();
				
				String query="update addfeedback set name=?, email=?,phone=?,comment=?,rating=? where id=?";
				PreparedStatement ps=con.prepareStatement(query);
				
				ps.setString(1, fb.getName());
				ps.setString(2, fb.getEmail());
				ps.setString(3, fb.getPhone());
				ps.setString(4, fb.getComment());
				ps.setString(5, fb.getRating());
				ps.setInt(6, fb.getId());
				status=ps.executeUpdate();
				
				
			} catch (Exception e) {
				System.out.println(e);
			}
			return status;
		}
		
		
		public static int delete(int id) {
			int status=0;
			
			try {
				
				Connection con= Product_dao.getConnection();
				String query="Delete from addfeedback where id=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setInt(1, id);
				status=ps.executeUpdate();
				
			} catch (Exception e) {
			System.out.println(e);
			}
			return status;
			
		}

}
