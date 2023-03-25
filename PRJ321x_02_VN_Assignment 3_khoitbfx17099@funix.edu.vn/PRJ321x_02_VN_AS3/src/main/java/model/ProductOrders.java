package model;

public class ProductOrders {

	int orderId;
	int productId;
	int amountProduct;
	String nameProduct;

	public ProductOrders() {

	}

	public ProductOrders(int orderId, int productId, int amountProduct, String nameProduct) {

		this.orderId = orderId;
		this.productId = productId;
		this.amountProduct = amountProduct;
		this.nameProduct = nameProduct;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAmountProduct() {
		return amountProduct;
	}

	public void setAmountProduct(int amountProduct) {
		this.amountProduct = amountProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}



}
