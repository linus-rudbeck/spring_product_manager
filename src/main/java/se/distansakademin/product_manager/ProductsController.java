package se.distansakademin.product_manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.distansakademin.business_logic.CategoriesService;
import se.distansakademin.business_logic.ProductsService;

@Controller
public class ProductsController {

    @GetMapping("/products")
    public String getProducts(Model model){
        var products = ProductsService.GetAll();

        model.addAttribute("products", products);

        return "products/home";
    }

    @GetMapping("/products/create")
    public String showCreateProductForm(Model model){
        var categories = CategoriesService.GetAll();

        model.addAttribute("categories", categories);

        return "products/create";
    }
}
