package com.development.Main;

import com.development.Entities.Client;
import com.development.Enums.OrderStatus;
import com.development.Entities.Order;
import com.development.Entities.OrderItem;
import com.development.Entities.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ClientDataApp {
    public static void main(String... args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Birth date (dd/mm/yyyy): ");
        Date birthDate = sdf.parse(sc.nextLine());

        Client client = new Client(name, email, birthDate);

        System.out.println("ORDER DATA: ");
        System.out.println("Status: ");
        String status = sc.nextLine().toUpperCase();

        OrderStatus os = OrderStatus.valueOf(status);

        Order order = new Order(new Date(), os, client);

        System.out.println("How many items to this order: ");
        int orderValue = sc.nextInt();

        for (int i = 0; i < orderValue; i++){
            System.out.println("Enter #" + (i+1) + " item data: ");
            sc.nextLine();
            System.out.println("Product name: ");
            String nameProd = sc.nextLine();

            System.out.println("Product price R$");
            double priceProd = sc.nextDouble();

            sc.nextLine();
            System.out.println("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(nameProd, priceProd);
            OrderItem orderItem = new OrderItem(quantity, priceProd, product);
            order.addItem(orderItem);

        }

        sc.nextLine();

        System.out.println("Order Summary: ");
        System.out.println(order);

        sc.close();
    }
}
