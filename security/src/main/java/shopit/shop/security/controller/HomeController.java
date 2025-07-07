
package shopit.shop.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import shopit.shop.security.beans.Cart;
import shopit.shop.security.beans.Products;
import shopit.shop.security.beans.User;
import shopit.shop.security.database.ProductsRepository;
import shopit.shop.security.database.UserData;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class HomeController {

    private final ProductController productController;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProductsRepository prepo;

    @Autowired
    private Cart cart;

    @Autowired
    private UserData ud;

    HomeController(ProductController productController) {
        this.productController = productController;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }


    // for the customer side page
    @GetMapping("/products")
    public String products(Model model) {

        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = "Welcome, " + auth.getName() + "!";

        System.out.println(username);
        model.addAttribute("products", prepo.findAllProducts());
        model.addAttribute("username", username);
        return "products";
    }

    @GetMapping("/products/{id}")
    public String productDetails(@PathVariable("id") int id, Model model) {
        Products product = prepo.findById(id).orElse(null); // Fetches the product by ID
        if (product != null) {
            model.addAttribute("product", product);
            model.addAttribute("products", prepo.findAllProducts()); // Adds the product to the model
            return "productDetails"; // Renders the 'productDetails.html' page
        } else {
            return "error"; // Renders an error page if the product is not found
        }
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("price") Long price,
            @RequestParam("description") String description,
            @RequestParam("stock") int quantity,
            RedirectAttributes redirectAttributes, Model model) {
        Products product = new Products();
        product.setId(id); // Set this if you're updating an existing item
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setStock(quantity); // Use 'quantity' for cart quantity

        System.out.println(quantity);

        prepo.addToCart(product);
        System.out.println(product.toString());

        // Set alert message
        redirectAttributes.addFlashAttribute("alertMessage", "Product added to cart successfully!");
        model.addAttribute("products", prepo.findAllProducts());

        // Redirect to the product details page
        return "redirect:/products"; // Adjust the path as necessary
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        List<Products> cartList = prepo.getCartList();
        // for (Products products : cartList) {
        //     System.out.println(products.getName());
        // }
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = "Welcome, " + auth.getName() + "!";

        model.addAttribute("cartList", cartList);
        model.addAttribute("username", username);
        return "cart"; // Thymeleaf template for cart
    }

    @GetMapping("/removeItem/{id}")
    public String removeFromCart(@PathVariable("id") int id, Model model) {
        prepo.deleteByIdCart(id);
        return viewCart(model);
    }

    @GetMapping("/removeAllItems/{id}")
    public String getMethodName(@PathVariable("id") int id, Model model) {
        prepo.deleteByIdCartWholeItem(id);
        return viewCart(model);
    }


    // for the user login page or the whole system
    @GetMapping("/access-denied")
    public String permissionDenied() {

        return "/access-denied";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("register", new User());
        return "register";
    }

  

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("register") User user, RedirectAttributes redirectAttributes) {
        // Add user to the database using UserData
        ud.addUser(user, passwordEncoder);

        // Redirect to login page after successful registration
        redirectAttributes.addFlashAttribute("successMessage", "Registration successful! Please log in.");
        return "redirect:/login"; // Redirect to login page after registration
    }

    @GetMapping("/login")
    public String processLogin() {

        return "login";
    }

    @GetMapping("/logout")
    public String processLogout() {

        return "login?logout";
    }


    // for the seller part
    @GetMapping("/seller/products")
    public String sellerSideProductsPage(Model model) {
        Products prod = new Products();
        model.addAttribute("products", prod);
        return "sellerpage";
    }
    
    @PostMapping("/seller/addproducts")
    public String sellerSideProductsPagePost(@ModelAttribute("products") Products products) {
        Products prod  = prepo.save(products);
       
        return "redirect:/seller/products";
    }
    

}
