package shopit.shop.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shopit.shop.security.beans.Products;
import shopit.shop.security.database.ProductsRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductsRepository productRepository;

    @GetMapping("/all")
    public List<Products> getAllProducts() {
        System.out.println(productRepository.findAllProducts());
        return productRepository.findAllProducts();
    }

    @GetMapping("/{id}")
    public Products getProductById(@PathVariable int id) {
        return productRepository.findById(id).orElse(null);
    }

    @PostMapping("/products")
public Products addProduct(@RequestBody Products product) {
    return productRepository.save(product);
}

}
