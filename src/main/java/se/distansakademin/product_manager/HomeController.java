package se.distansakademin.product_manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.distansakademin.business_logic.ProductsService;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getHome(){
        return "home";
    }


    @GetMapping("/summary")
    public String getSummary(Model model){
        int totalSum = ProductsService.GetTotalSum();
        model.addAttribute("totalSum", totalSum);

        float averagePrice = ProductsService.GetAveragePrice();
        model.addAttribute("averagePrice", averagePrice);


        return "summary";
    }

}
