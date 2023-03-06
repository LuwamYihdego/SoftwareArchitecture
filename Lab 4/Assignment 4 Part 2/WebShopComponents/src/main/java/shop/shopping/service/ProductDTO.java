package shop.shopping.service;

public class ProductDTO { // we dont need @Document as we dont need to persist this in out db.
	String productnumber;
	double price;
	String description;


	public ProductDTO(String productnumber, String description, double price) {
		super();
		this.productnumber = productnumber;
		this.price = price;
		this.description = description;
	}
	

	public ProductDTO() {
	}


	public String getProductnumber() {
		return productnumber;
	}

	public void setProductnumber(String productnumber) {
		this.productnumber = productnumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
