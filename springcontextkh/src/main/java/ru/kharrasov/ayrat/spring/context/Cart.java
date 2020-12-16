package ru.kharrasov.ayrat.spring.context;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Scope(scopeName = "prototype")
public class Cart {
    private List<Product> cartProducts;
    private ProductRepository productRepository;

    public Cart(List<Product> cartProducts, ProductRepository productRepository){
        this.cartProducts = cartProducts;
        this.productRepository = productRepository;
    }

    public void addToCart(Long productId){
        Product prod = productRepository.getProductsById(productId);
        if(prod != null){
            cartProducts.add(prod);
        }
        else {
            System.out.println("Товар для добавления не найден");
        }
    }

    public void removeFromCart(Long productId){
        boolean find = false;
        for (Product p: cartProducts) {
            if(p.getId() == productId){
                cartProducts.remove(p);
                find = true;
                break;
            }
        }
        if(!find){
            System.out.println("Товар для удаления не найден");
        }
    }

    public List<Product> getCart(){
        return Collections.unmodifiableList(cartProducts);
    }
}