package ru.kharrasov.ayrat.spring.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        ProductRepository repository = context.getBean("productRepository", ProductRepository.class);
        Cart cart = context.getBean("cart", Cart.class);
        System.out.println(repository.getProducts());

        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (true) {
            command = scanner.nextLine();
            if (command.startsWith("/add")) {
                String[] token = command.split(" ");
                cart.addToCart(Long.parseLong(token[1]));
            }
            if (command.startsWith("/rmv")) {
                String[] token = command.split(" ");
                cart.removeFromCart(Long.parseLong(token[1]));
            }
            if (command.equals("/show")) {
                System.out.println(cart.getCart());
            }
            if (command.equals("/q")) {
                break;
            }
        }
        context.close();
    }
}
