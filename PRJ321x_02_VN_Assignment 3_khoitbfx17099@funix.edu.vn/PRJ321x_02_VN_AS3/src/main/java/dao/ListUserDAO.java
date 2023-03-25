package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.User;

public class ListUserDAO {
	
	private Connection conn;
	
	
	
	public ListUserDAO() {
		conn = new DBContext().getConnection();
	}

	public List<User> getAllUser() throws SQLException{
		List<User> ul = new ArrayList<>();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Account ");
		
		while(rs.next()) {
			User user = new User();
			
			user.setMail(rs.getString("user_mail"));
			user.setPassword(rs.getString("password"));
			user.setRole(rs.getInt("account_role"));
			user.setName(rs.getString("user_name"));
			user.setAddress(rs.getString("user_address"));
			user.setPhone(rs.getString("user_phone"));
			ul.add(user);
		}
		return ul;
		
	}

	public User getUser(String mail, String password) throws SQLException {
		User user = new User();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Account where user_mail ="+"'"+mail+"'"+"and password = "+"'"+password+"'");
		if(rs.next()) {
		user.setMail(rs.getString("user_mail"));
		user.setPassword(rs.getString("password"));
		user.setRole(rs.getInt("account_role"));
		user.setName(rs.getString("user_name"));
		user.setAddress(rs.getString("user_address"));
		user.setPhone(rs.getString("user_phone"));
		return user;
		}else {
			return null;	
		}
		
		
	}
	
	/*
	 * INSERT [dbo].[Account] ([user_mail], [password], [account_role], [user_name], [user_address], [user_phone]) 
		VALUES (N'duongdt@fpt.com.vn', N'123', 1, N'Đinh Tùng Dương', N'Đại học FPT', N'0765870407')
	 */
	
	public void createUser(User u) throws SQLException {
		
		
		try {
		
			String sql = "INSERT [dbo].[Account] ([user_mail], [password], [account_role], [user_name], [user_address], [user_phone]) \r\n"
						+ "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement stm = conn.prepareStatement(sql);
			
			stm.setString(1, u.getMail());
			stm.setString(2, u.getPassword());
			stm.setInt(3, u.getRole());
			stm.setString(4, u.getName());
			stm.setString(5, u.getAddress());
			stm.setString(6, u.getPhone());
			
			stm.executeUpdate();
			stm.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[]arg) {
		ListUserDAO dao = new ListUserDAO();
		
		try {
			List<User> u = dao.getAllUser();
			for(User p : u) {
				System.out.println(p.toString());
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
