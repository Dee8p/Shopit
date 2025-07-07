
package shopit.shop.security.database;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import shopit.shop.security.beans.Cart;
import shopit.shop.security.beans.Products;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductsRepository {

    private final Cart cart;

    private final JdbcTemplate jdbcTemplate;

    public ProductsRepository(JdbcTemplate jdbcTemplate, Cart cart) {
        this.jdbcTemplate = jdbcTemplate;
        this.cart = cart;
    }

    // RowMapper to map ResultSet to Product entity
    private static final class ProductsRowMapper implements RowMapper<Products> {
        @Override
        public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
            Products product = new Products();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getLong("price"));
            product.setStock(rs.getInt("stock"));
            product.setDescription(rs.getString("description"));
            return product;
        }
    }

    // Save or update a product
    public Products save(Products product) {
        if (product.getId() == 0) {
            // Insert new product
           int rowsAff =  jdbcTemplate.update("INSERT INTO product (name, price, stock, description, images) VALUES (?, ?, ?, ?, ?)",
                    product.getName(), product.getPrice(), product.getStock(), product.getDescription(), product.getImages());

System.out.println(rowsAff);
        } else {
            // Update existing product
            jdbcTemplate.update("UPDATE product SET name = ?, price = ?, stock = ?, description = ? WHERE id = ?",
                    product.getName(), product.getPrice(), product.getStock(), product.getDescription(), product.getId());
        }
        return product;
    }

    public Products addToCart(Products product) {
        if (product.getId() != -1) {
            // Check if the product is in stock before adding to the cart
            Optional<Products> existingProduct = findById(product.getId());
            if (existingProduct.isPresent() && existingProduct.get().getStock() > 0) {
                // Insert new product into cart
                jdbcTemplate.update("INSERT INTO cart (name, price, quantity, description) VALUES (?, ?, ?, ?)",
                        product.getName(), product.getPrice(), product.getStock(), product.getDescription()); // Always add quantity as 1
                // Reduce stock after adding to cart
                jdbcTemplate.update("UPDATE product SET stock = stock - ? WHERE id = ?", product.getStock(),product.getId());
            } else {
                System.out.println("Product is out of stock or does not exist!");
            }
        } else {
            // Update existing product in cart (optional)
            jdbcTemplate.update("UPDATE cart SET name = ?, price = ?, quantity = ?, description = ? WHERE id = ?",
                    product.getName(), product.getPrice(), product.getStock(), product.getDescription(), product.getId());
        }
        return product;
    }

    // Find by id
    public Optional<Products> findById(int id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        return jdbcTemplate.query(sql, new ProductsRowMapper(), id).stream().findFirst();
    }

    // Find all products
    public List<Products> findAllProducts() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new ProductsRowMapper());
    }

    // Get cart list
    public List<Products> getCartList() {
        String sql = "SELECT id, name, price, quantity AS stock, description FROM cart";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Products.class));
    }
    

    // Delete product by id
    public void deleteById(Long id) {
        String sql = "DELETE FROM product WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // Delete product from cart by id
    public void deleteByIdCart(int id) {
        String sql = "UPDATE cart SET quantity = quantity -1 WHERE id = ?";
        jdbcTemplate.update(sql, id);          
    }

    public void deleteByIdCartWholeItem(int id){
        String sql = "DELETE FROM cart WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
