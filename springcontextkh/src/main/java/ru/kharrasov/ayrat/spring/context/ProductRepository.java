package ru.kharrasov.ayrat.spring.context;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope(scopeName = "singleton")
public class ProductRepository {
    private List<Product> products;

    public void addProduct(Product product){
        products.add(product);
    }

    public void delProduct(Product product){
        products.remove(product);
    }

    public List<Product> getProducts(){
        return Collections.unmodifiableList(products);
    }

    public Product getProductsById(Long id){
        Product find = null;
        for (Product p: products) {
            if(p.getId() == id){
                find = p;
                break;
            }
        }
        return find;
    }

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            products.add(new Product(i+3L, "product"+((int)Math.random()*3+i), Math.random()*(i+1)+2*i));
        }
    }
}