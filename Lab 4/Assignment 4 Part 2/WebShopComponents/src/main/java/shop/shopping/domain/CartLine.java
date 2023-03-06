package shop.shopping.domain;

import org.springframework.data.mongodb.core.mapping.Document;

//@Document
public class CartLine {  // value are immutable we dont need setters and getters
	int quantity;
	Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}