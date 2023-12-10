package com.example.carservice2.web;

import com.example.carservice2.services.BrandsService;
import com.example.carservice2.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrandsWebController {

    private BrandsService brandsService;

    private UsersService usersService;

    @Autowired
    public void setBrandsService(BrandsService brandsService) {
        this.brandsService = brandsService;
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/brands")
    public String brandsPage(Model model) {
        model.addAttribute("brands", brandsService.getAllBrands());
        model.addAttribute("headerUser", usersService.getUsersByUsername("dimi_trich"));
        return "brands";
    }

}
