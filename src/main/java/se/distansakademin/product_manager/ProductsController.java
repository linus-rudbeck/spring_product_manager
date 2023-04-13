package se.distansakademin.product_manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import se.distansakademin.business_logic.CategoriesService;
import se.distansakademin.business_logic.ProductsService;
import se.distansakademin.models.Category;
import se.distansakademin.models.Product;

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

    @PostMapping("/products/create")
    public String createProduct(@ModelAttribute("product") Product product){
        ProductsService.Create(product);

        return "redirect:/products";
    }

    @GetMapping("/products/{id}/edit")
    public String showEditProductForm(@PathVariable int id, Model model){

        var categories = CategoriesService.GetAll();
        var product = ProductsService.GetOneById(id);

        model.addAttribute("categories", categories);
        model.addAttribute("product", product);

        return "products/edit";
    }

    @PostMapping("/products/{id}/edit")
    public String editProduct(@PathVariable int id, @ModelAttribute("product") Product product){
        ProductsService.Edit(id, product);

        return "redirect:/products";
    }

    @PostMapping("/products/{id}/delete")
    public String deleteProducts(@PathVariable int id){
        ProductsService.Delete(id);

        return "redirect:/products";
    }
}
