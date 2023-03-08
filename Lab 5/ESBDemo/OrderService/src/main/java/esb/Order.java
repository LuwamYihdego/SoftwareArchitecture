package esb;

public class Order {
	private String orderNumber;
	private double amount;
	private boolean isInternational;

	public Order(String orderNumber, double amount, boolean isInternational) {
		super();
		this.orderNumber = orderNumber;
		this.amount = amount;
		this.isInternational = isInternational;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isInternational() {
		return isInternational;
	}

	public void setInternational(boolean international) {
		isInternational = international;
	}

	@Override
	public String toString() {
		return "Order{" +
				"orderNumber='" + orderNumber + '\'' +
				", amount=" + amount +
				", isInternational=" + isInternational +
				'}';
	}

}
