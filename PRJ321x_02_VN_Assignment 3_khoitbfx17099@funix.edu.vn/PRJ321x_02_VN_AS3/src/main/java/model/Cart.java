package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.ListProductDAO;

public class Cart {

	private List<Product> items;
	
	private int size;

	public Cart() {
		items = new ArrayList<>();
		
	}
	
	
	
	public int getSize() {
		int s = 0;
		for(Product p : items) {
			s +=  p.getNumber();
		}
		return s;
	}


	public Product getItemId(int id) {
		for(Product p : items) {
			if(p.getId()==id) {
				return p;
			}
		}
		return null;
	}
	
	public int getQuantily(int id) {
		return getItemId(id).getNumber();
	}
	
	public void addItem(Product p) {
		
		if(getItemId(p.getId())!=null) {
			Product pr = getItemId(p.getId());
			
			pr.setNumber(pr.getNumber()+p.getNumber());
		}else {
			items.add(p);
		}
	
	}
	
	public void add(Product ci) {
		for (Product x : items) {
			if (ci.getId() == x.getId()) {
				x.setNumber(x.getNumber() + 1);
				return;
			}
		}
		items.add(ci);
	}

	public void remove(int id) {
		for (Product p : items) {
			if (p.getId() == id) {
				items.remove(p);
				return;
			}
		}
	}
	
	public double getAmount() {
		double s = 0;
		for(Product p : items) {
			s = p.getPrice() * p.getNumber();
		}
		return Math.round(s*100.0)/100.0;
	}

	public double getTotal() {
		double s = 0;
		for(Product p : items) {
			s += p.getPrice() * p.getNumber();
		}
		return Math.round(s*100.0)/100.0;
	}
	
	
	
	
	public List<Product> getItems(){
		return items;
	}

	public static void main (String[] arg) {
		ListProductDAO dao = new ListProductDAO();
		Cart c = new Cart();
		try {
			List<Product> pl = dao.getListProduct();
			for(Product p : pl) {
				c.add(p);
			}
			List<Product> l = c.getItems();
//			for(Product p : l) {
//				System.out.println(p.getId());
//			}
			
			for(Product p : l) {
				c.remove(p.getId());
			}
			int d= l.size();
			
			System.out.println(d);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
