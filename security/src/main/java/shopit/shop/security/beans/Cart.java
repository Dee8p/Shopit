package shopit.shop.security.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data

@Component
public class Cart {

    private ArrayList<Products> CartList;

    public Cart(){
        CartList = new ArrayList<>();
    }

    public void addProduct(Products product) {
        // Check if the product already exists in the cart
        for (Products p : CartList) {
            if (p.getId() == product.getId()) {
                p.setStock( (int)( p.getPrice() + product.getStock()));
                return;
            }
        }
        CartList.add(product); // Add new product if not already in the cart
    }

    // Remove product from the cart
    public void removeProduct(int productId) {
        CartList.removeIf(p -> p.getId() == productId);
    }

    public void clearCart() {
        CartList.clear();
    }

    // Get total price of the cart
    public double getTotalPrice() {
        double total = 0;
        for (Products p : CartList) {
            total += p.getPrice() * p.getStock();
        }
        return total;
    }

    // Get total items count in the cart
    public int getItemCount() {
        int itemCount = 0;
        for (Products p : CartList) {
            itemCount += p.getStock();
        }
        return itemCount;
    }

    public List<Products> getProducts(){
        return CartList;
    }
}
