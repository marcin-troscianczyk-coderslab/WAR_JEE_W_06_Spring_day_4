package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.model.Cart;
import pl.coderslab.model.CartItem;
import pl.coderslab.model.Product;

import java.util.Random;

@Controller
class CartController {

    private Cart cart;

    @Autowired
    public CartController(Cart cart) {
        this.cart = cart;
    }

    @GetMapping("/addtocart")
    @ResponseBody
    public String addtocart() {

        Random rand = new Random();
        String productName = "prod" + rand.nextInt(10);
        double productPrice = rand.nextDouble();
        Product product = new Product(productName, productPrice);
        cart.addToCart(new CartItem(product, 1));

        return "Cart " + cart;
    }

    @GetMapping(path = "/cart")
    public String showCart(Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }
}
