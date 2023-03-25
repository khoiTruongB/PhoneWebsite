package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Product;
import model.User;

public class ListProductDAO {

	private final Connection conn;

	public ListProductDAO() {
		conn = new DBContext().getConnection();
	}
	
	
	public List<Product> searchProduct(String name) throws Exception {

		List<Product> pl = new ArrayList();

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Products where product_name like '%"+name+"%'");
		
		
		while (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("product_id"));
			p.setName(rs.getNString("product_name"));
			p.setDescription(rs.getString("product_des"));
			p.setPrice(rs.getFloat("product_price"));
			p.setSrc(rs.getString("product_img_source"));
			p.setType(rs.getString("product_type"));
			p.setBrand(rs.getString("product_brand"));
			pl.add(p);
		}

		return pl;
	}

	public List<Product> getListProduct() throws Exception {

		List<Product> pl = new ArrayList();

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Products ");
		while (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("product_id"));
			p.setName(rs.getNString("product_name"));
			p.setDescription(rs.getString("product_des"));
			p.setPrice(rs.getFloat("product_price"));
			p.setSrc(rs.getString("product_img_source"));
			p.setType(rs.getString("product_type"));
			p.setBrand(rs.getString("product_brand"));
			pl.add(p);
		}

		return pl;
	}

	/** lấy số trang trên sản phẩm */
	public int numberPages() throws SQLException {

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select count(*) from Products");
		int total = 0;
		int page = 0;
		while (rs.next()) {
			total = rs.getInt(1);
			page = total / 6;
			if (total % 6 != 0) {
				page++;
			}
		}

		return page;
	}
	
	public int numberPagesOfCategory(String type) throws SQLException {

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select count(*) from Products where product_brand = '"+type+"'");
		int total = 0;
		int page = 0;
		while (rs.next()) {
			total = rs.getInt(1);
			page = total / 6;
			if (total % 6 != 0) {
				page++;
			}
		}

		return page;
	}

	/** hiển thị số sản phẩm trên 1 trang */
	public List<Product> getListOfPage(int page) throws Exception {

		List<Product> pl = new ArrayList();

		int pNum = (page - 1) * 6;

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(
				"select * from Products order by product_id offset " +pNum +" rows fetch first 6 rows only");
		while (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("product_id"));
			p.setName(rs.getNString("product_name"));
			p.setDescription(rs.getString("product_des"));
			p.setPrice(rs.getFloat("product_price"));
			p.setSrc(rs.getString("product_img_source"));
			p.setType(rs.getString("product_type"));
			p.setBrand(rs.getString("product_brand"));
			pl.add(p);
		}

		return pl;
	}

	/** lấy danh sách category */
	public List<Product> productCategory() throws SQLException {
		List<Product> pl = new ArrayList();

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select distinct product_brand from Products ");
		while (rs.next()) {
			Product p = new Product();
			p.setBrand(rs.getString("product_brand"));
			pl.add(p);
		}

		return pl;
	}

	public List<Product> getListOfPageWithCategory(int page, String type) throws Exception {

		List<Product> pl = new ArrayList();

		int pNum = (page - 1) * 6;

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(
				"select * from Products where product_brand = '"+type+"' order by product_id offset " +pNum +" rows fetch first 6 rows only");
		while (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("product_id"));
			p.setName(rs.getNString("product_name"));
			p.setDescription(rs.getString("product_des"));
			p.setPrice(rs.getFloat("product_price"));
			p.setSrc(rs.getString("product_img_source"));
			p.setType(rs.getString("product_type"));
			p.setBrand(rs.getString("product_brand"));
			pl.add(p);
		}

		return pl;
	}
	
	public Product getInfoProduct(int id) throws SQLException {
		Product p = new Product();

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Products where product_id = "+id);
		if(rs.next()) {
		p.setId(rs.getInt("product_id"));
		p.setName(rs.getNString("product_name"));
		p.setDescription(rs.getString("product_des"));
		p.setPrice(rs.getFloat("product_price"));
		p.setSrc(rs.getString("product_img_source"));
		p.setType(rs.getString("product_type"));
		p.setBrand(rs.getString("product_brand"));
		}
		return p;
	}


		
	public static void main(String[]arg) {
		ListProductDAO dao = new ListProductDAO();
		
		try {
			List<Product>p=dao.searchProduct("sa");
			if(p.isEmpty()) {
				System.out.println("loi");
			}
			for(Product l :p) {
				if(p==null) {
					System.out.println("loi");
				}
				System.out.println(l);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
