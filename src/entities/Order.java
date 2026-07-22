package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	private Client client;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private List<OrderItem> item = new ArrayList<>();

	public Order() {
		
	}

	

	public Order(Date moment, OrderStatus status, Client client) {
		super();
		this.moment = moment;
		this.status = status;
		this.client = client;
	}



	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrderitem() {
		return item;
	}
	public void addItem(OrderItem oderitem) {
		item.add(oderitem);
		
	}
	public void removeItem(OrderItem oderitem) {
		item.remove(oderitem);
	}
	public Double total() {
		Double sum = 0.0;
		for (OrderItem items: item) {
			sum += items.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment: " + sdf.format(moment));
		sb.append("\n");
		sb.append("Order status: " + status);
		sb.append("\n");
		sb.append(client);
		sb.append("\n");
		for(OrderItem oi : item) {
			sb.append(oi.getProduct().getName());
			sb.append(String.format(" $%.2f",oi.getPrice()));
			sb.append(", quantity: " + oi.getQuantity());
			sb.append(String.format(", subtotal: %.2f\n", oi.subTotal()));
		}
		sb.append(String.format("Total price: %.2f",total()));
		return sb.toString();
	}
	

}
