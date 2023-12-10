package com.example.carservice2.web;

import com.example.carservice2.models.Roles;
import com.example.carservice2.services.RolesService;
import com.example.carservice2.services.UsersService;
import com.example.carservice2.services.dto.OffersDTO;
import com.example.carservice2.services.dto.RolesDTO;
import com.example.carservice2.services.dto.UsersDTO;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
public class UsersWebController {

    private UsersService usersService;
    private RolesService rolesService;
    private ModelMapper modelMapper;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setRolesService(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("user")
    public UsersDTO initUser() {
        return new UsersDTO();
    }

    @GetMapping("/authorization")
    public String auntifRegPage(Model model) {
        model.addAttribute("headerUser", usersService.getUsersByUsername("dimi_trich"));
        return "auntifReg";
    }

    @PostMapping("/authorization")
    public String addUser(@Valid UsersDTO user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("user", user);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
            return "redirect:/authorization";
        }
        RolesDTO role = rolesService.findByRoleType(Roles.RoleType.USER);
        user.setRole(role.getId());
        usersService.createUser(user);
        return "redirect:/";
    }


    @GetMapping("/profile")
    public String userPage(Model model) {
        model.addAttribute("headerUser", usersService.getUsersByUsername("dimi_trich"));
        return "user";
    }

    @GetMapping("/profile/update")
    public String updateUser(Model model) {
        model.addAttribute("headerUser", usersService.getUsersByUsername("dimi_trich"));
        return "updateUser";
    }

    @PostMapping("/profile/update")
    public String changeUser(@Valid UsersDTO headerUser, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("headerUser", headerUser);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.headerUser", bindingResult);
            return "redirect:/profile/update";
        }
        UUID headerUserId = usersService.getUsersByUsername("dimi_trich").getId();
        usersService.updateUser(headerUserId, headerUser);
        return "redirect:/profile";
    }
}
