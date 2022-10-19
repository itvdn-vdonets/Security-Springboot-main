package com.example.security.controller;

import com.example.security.Entity.Role;
import com.example.security.Entity.User;
import com.example.security.repository.RoleRepository;
import com.example.security.repository.UserRepository;
import com.example.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {

    final RoleRepository roleRepository;

    final UserService userService;

    public LoginController(RoleRepository roleRepository, UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @RequestMapping("/register")
    public String signupPage(@ModelAttribute User user) {
        Role roles = roleRepository.findById(1L).orElseThrow(() -> new RuntimeException("Default role isn't found!"));
        user.setRoleList(List.of(roles));
        userService.saveUser(user);
        System.out.println(user);
        return "redirect:/login";
    }

}
