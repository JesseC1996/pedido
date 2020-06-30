package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private OrderStatus status;
	
	Client client;
	
	
	private List<OrderItem> list = new ArrayList<>();
	
	public Order() {
		
	}
	public Order(Date moment,OrderStatus status,Client client) {
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
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void addItem(OrderItem item) {
		list.add(item);
	}
	public void removeItem(OrderItem item) {
		list.remove(item);
	}
		
	public List<OrderItem> getList() {
		return list;
	}
	
	
	
	public Double total() {
		double soma = 0.0;
		for(OrderItem item : list ) {
			soma += item.subTotal();
		}
		return soma;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: \n");
		sb.append(sdf.format(moment)+"\n");
		sb.append("Order status: ");
		sb.append(status+"\n");
		sb.append("Client: \n");
		sb.append(client.getName()+"\n");
		sb.append("Order items: \n");
		for(OrderItem item : list) {
			sb.append(item+"\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f",total()));
		
		return sb.toString();
	}
	
}
