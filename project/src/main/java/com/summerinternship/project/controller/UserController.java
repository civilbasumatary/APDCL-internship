package com.summerinternship.project.controller;

import com.summerinternship.project.model.User;
import com.summerinternship.project.model.Offices;
import com.summerinternship.project.service.UserService;
import com.summerinternship.project.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {   

    @Autowired
    private UserService userService;

    @Autowired
    private OfficeService officeService;

    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users/list";
    }

    @GetMapping("/new")
    public String createUserForm(Model model) {
        List<Offices> offices = officeService.getAllOffices();
        model.addAttribute("user", new User());
        model.addAttribute("offices", offices);
        return "users/create";
    }

    @PostMapping
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        List<Offices> offices = officeService.getAllOffices();
        model.addAttribute("user", user);
        model.addAttribute("offices", offices);
        return "users/edit";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        user.setId(id.intValue()); // Convert Long to int
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
