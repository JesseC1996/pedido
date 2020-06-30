package entities;

public class OrderItem {
	private Integer quantity;
	private Double price;
	Product product;
	
	public OrderItem() {
		
	}
	public OrderItem(Integer quantity,Double price,Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity =  quantity;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double price() {
		return price;
	}
	
	public Double subTotal() {
		return price * quantity;
	 
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(product.getName()+"\n");
		sb.append("\n"+price);
		sb.append("\nQuantity: "+quantity);
		sb.append("\nSubtotal: "+subTotal());
		
		return sb.toString();
	}
}
