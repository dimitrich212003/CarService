package com.example.carservice2.web;

import com.example.carservice2.services.BrandsService;
import com.example.carservice2.services.ModelsService;
import com.example.carservice2.services.OffersService;
import com.example.carservice2.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class HomeController {
    private BrandsService brandsService;
    private ModelsService modelsService;
    private UsersService usersService;

    @Autowired
    public void setBrandsService(BrandsService brandsService) {
        this.brandsService = brandsService;
    }

    @Autowired
    public void setModelsService(ModelsService modelsService) {
        this.modelsService = modelsService;
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/")
    public String home(@RequestParam(name = "brandId", required = false) UUID brandId, Model model) {
        model.addAttribute("brands", brandsService.getAllBrands());
        if (brandId != null) {
            model.addAttribute("models", modelsService.getModelsByBrandId(brandId));
        }
        model.addAttribute("headerUser", usersService.getUsersByUsername("dimi_trich"));
        return "home";
    }
}
