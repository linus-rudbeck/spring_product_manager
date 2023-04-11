package se.distansakademin.product_manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import se.distansakademin.business_logic.CategoriesService;
import se.distansakademin.models.Category;

@Controller
public class CategoriesController {

    @GetMapping("/categories")
    public String getCategories(Model model){
        var categories = CategoriesService.GetAll();

        model.addAttribute("categories", categories);

        return "categories/home";
    }

    @GetMapping("/categories/create")
    public String showCreateCategoryForm(){
        return "categories/create";
    }

    @PostMapping("/categories/create")
    public String createCategory(@ModelAttribute("category")Category category){
        CategoriesService.Create(category);

        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}/edit")
    public String showEditCategoryForm(@PathVariable int id, Model model){
        var category = CategoriesService.GetOneById(id);

        model.addAttribute("category", category);

        return "categories/edit";
    }

    @PostMapping("/categories/{id}/edit")
    public String editCategory(@PathVariable int id, @ModelAttribute("category")Category category){
        CategoriesService.Edit(id, category);

        return "redirect:/categories";
    }

    @PostMapping("/categories/{id}/delete")
    public String deleteCategory(@PathVariable int id){
        CategoriesService.Delete(id);

        return "redirect:/categories";
    }
}


// categoryId = 3
// /categories/3/edit