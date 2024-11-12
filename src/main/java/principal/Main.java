package principal;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        OrderItem orderItem = new OrderItem();
        Scanner sca = new Scanner(System.in);
        SimpleDateFormat formatation = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        System.out.println("Enter cliente data:");
        System.out.print("name: ");
        String name = sca.next();
        System.out.print("Email: ");
        String email = sca.next().toString();
        System.out.print("Birth date (DD/MM/YYYY):");
        Date birthDate = sdf.parse(sca.next());
        System.out.println("Enter order data:");
        System.out.print("Status ");
        String status = sca.next().toString();
        Order order = new Order(OrderStatus.valueOf(status), new Client(name,email, birthDate));

        System.out.print("How many items to this order? ");
        int a = sca.nextInt();

        for(int i= 0; i < a; i++){
            System.out.println("Enter #"+(i+1)+" item data:");
            System.out.print("Product name: ");
            String productName = sca.next();
            System.out.print("Product price: ");
            double price = sca.nextDouble();
            System.out.print("Quantity: ");
            int quantity= sca.nextInt();
            orderItem = new OrderItem(new Product(productName,price),price,quantity);
            order.addItem(orderItem);
        }

        System.out.println("ORDER SUMMARY:");
        System.out.print("Order moment: ");
        Date date= new Date();
        String moment = formatation.format(date);
        System.out.println("Order status:"+order.getStatus());
        System.out.println("Client: "+order.getCliente());
        System.out.println("Order items:");

        List<OrderItem> orderItemsList = order.getItens();
        for (int i = 0; i < orderItemsList.toArray().length; i++) {
            System.out.println(orderItemsList.get(i).toString());
        }
        System.out.println("Total Price: $"+order.total());


    }
}