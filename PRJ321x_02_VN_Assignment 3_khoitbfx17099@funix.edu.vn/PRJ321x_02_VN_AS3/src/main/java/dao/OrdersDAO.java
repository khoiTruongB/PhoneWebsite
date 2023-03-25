package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import context.DBContext;
import model.Cart;
import model.Orders;
import model.Product;

public class OrdersDAO {

	public void insertOrder(Orders o, Cart c) throws SQLException {
		
		Connection conn = new DBContext().getConnection();
		try {
			
			List<Product> pl = c.getItems();
			int amount = (int) c.getTotal();
			String sql = "insert into Orders_detail values(?, ?, ?, ?)";
			
			Statement tm = conn.createStatement();
			ResultSet rs = tm.executeQuery("select top 1 order_id from Orders order by order_id DESC");
			
			int id = 0;
			if(rs.next()) {
				id = rs.getInt("order_id");
			}
			id = id + 1;
			
			String sql2 = "set identity_insert Orders on "
						+ "insert into Orders (user_mail,order_id,order_status,order_date,order_discount_code,order_address) values (?, ?, ?, ?, ?, ?)"
						+ " set identity_insert Orders off";
			
			PreparedStatement stm2 = conn.prepareStatement(sql2);
			
			stm2.setString(1, o.getUserMail());
			stm2.setString(2, ""+id);
			stm2.setString(3, ""+o.getStatus());
			
			Date date = new Date(Calendar.getInstance().getTime().getTime());
			
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			String vali = f.format(date);
			stm2.setString(4, vali);
			stm2.setString(5, "" + o.getDiscount());
			stm2.setString(6, o.getAddress());
			
			stm2.executeUpdate();
			stm2.close();
			
			PreparedStatement stm = conn.prepareStatement(sql);
			
			for(Product p : pl) {
				stm.setInt(1, id);
				stm.setInt(2, p.getId());
				stm.setInt(3, (int) (p.getPrice()*p.getNumber()));
				stm.setInt(4,  (int) p.getPrice());
				stm.executeUpdate();
			}
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/*
	 * 
	 * set identity_insert Orders on insert into
	 * Orders(user_mail,order_id,order_status,order_date,order_discount_code,
	 * order_address) values('khoi',2,2,'2023-03-15','','5556') set identity_insert
	 * Orders off
	 * 
	 * select * from Orders
	 * 
	 * delete from Orders
	 * 
	 */

}
