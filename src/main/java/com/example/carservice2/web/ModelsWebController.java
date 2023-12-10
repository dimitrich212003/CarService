package com.example.carservice2.web;

import com.example.carservice2.services.BrandsService;
import com.example.carservice2.services.ModelsService;
import com.example.carservice2.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class ModelsWebController {

    private ModelsService modelsService;

    private BrandsService brandsService;

    private UsersService usersService;

    @Autowired
    public void setModelsService(ModelsService modelsService) {
        this.modelsService = modelsService;
    }

    @Autowired
    public void setBrandsService(BrandsService brandsService) {
        this.brandsService = brandsService;
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/models/{brandId}")
    public String modelPage(@PathVariable("brandId") String brandId, Model model) {
        model.addAttribute("brand", brandsService.getBrandById(UUID.fromString(brandId)));
        model.addAttribute("models", modelsService.getModelsByBrandId(UUID.fromString(brandId)));
        model.addAttribute("headerUser", usersService.getUsersByUsername("dimi_trich"));
        return "models";
    }

}
