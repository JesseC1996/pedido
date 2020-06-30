package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Prog {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 Locale.setDefault(Locale.US);
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter client data: ");
		 System.out.print("Name: ");
		 String name = sc.nextLine();
		 System.out.print("Email: @");
		 String email = sc.nextLine();
		 System.out.print("Birth date (DD/MM/YYYY)");
		 Date birthDate = sdf.parse(sc.next());
		 
		 Client client = new Client(name,email,birthDate);
		 
		 
		 System.out.println("Enter order data: ");
		 System.out.print("Status:'PENDING_PAYMENT,\r\n" + 
		 		"	PROCESSING,\r\n" + 
		 		"	SHIPPED,\r\n" + 
		 		"	DELIVERED;' ");
		 OrderStatus status = OrderStatus.valueOf(sc.next());
		 
		 Order order = new Order(new Date(),status,client);
		 
		 System.out.println("How many items to this order? ");
		 int n = sc.nextInt();
		
		 
		for(int i = 0;i<n;i++) {
			 System.out.println("Enter #"+i+ "item data: ");
			 System.out.print("Product name: ");
			 sc.nextLine();
			 String prodName = sc.nextLine();
			 System.out.print ("Product price: ");
			 Double prodPrice = sc.nextDouble();
			 Product product = new Product (prodName,prodPrice);
			 
			 System.out.print ("Quantity: ");
			 Integer quantity =  sc.nextInt();
			 
			 OrderItem orderitem = new OrderItem(quantity,prodPrice,product);
			order.addItem(orderitem);
		}
		 
		 System.out.println("Order summary: ");
		 System.out.println(order);
		 sc.close();

	}

}
