package ru.dns_shop.pages.utils;

import java.util.ArrayList;
import java.util.List;
import static ru.dns_shop.pages.utils.WarrantyEnum.WARRANTY_NO;

/**
 *
 * @author vadim
 */
public class Product {
    private String name;
    private WarrantyEnum warranty;
    private float warrantyPrice;
    private float price;
    
    private static List<Product> productList = new ArrayList<>();
    
    /*public static List<Product> getProductList() {
        return productList;
    }*/

    /*public static Product getProductByName(String name) {
        //return productList.stream().filter((p) -> p.getName().equals(name)).count();
        for(Product p: productList) {
            if(p.getName().contains(name) || name.contains(p.getName()))
                return p;            
        }
        return null;
    }*/

    public Product() {
        name = "";
        warranty = WARRANTY_NO;
        warrantyPrice = 0.0f;
        price = 0.0f;
    }

    public Product(String name, WarrantyEnum warranty, float warrantyPrice, float price) {
        this.name = name;
        this.warranty = warranty;
        this.warrantyPrice = warrantyPrice;
        this.price = price;
    }

    public Product(String name, float price) {
        this.name = name;
        this.warranty = WARRANTY_NO;
        this.warrantyPrice = 0.0f;
        this.price = price;
    }
    
    public static float getPriceShoppingList() {
        float price = 0;
        for(Product p: productList) {
            price += p.getPriceToWarranty();
        }
        return price;
    }
    
    private float getPriceToWarranty() {
        if(warrantyPrice == 0.0f)
            return price;
        else
            return warrantyPrice;
    }
    
    private String getName() {
        return name;
    }
    
    public static void saveProduct(String name, float price) {
        if(productList.isEmpty()) {
            productList.add(new Product(name, price));
        } else {
            int i = 0;
            for(Product p: productList) {
                if(p.getName().equals(name)) {
                    productList.set(i, new Product(name, price));
                }
                i++;
            }
        }
    }
        
    public static void saveProduct(String name, WarrantyEnum warranty,
            float warrantyPrice) {
        int i = 0;
        for(Product p: productList) {
            if(p.getName().equals(name)) {
                productList.set(i, new Product(name, warranty, warrantyPrice, p.price));
            }
            i++;
        }
    }
}
