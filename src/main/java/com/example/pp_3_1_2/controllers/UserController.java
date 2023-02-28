package com.example.pp_3_1_2.controllers;

import com.example.pp_3_1_2.models.User;
import com.example.pp_3_1_2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class UserController {

    private final UserServiceImpl userServiceImpl;
    @Autowired
    public UserController (UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/user")
    public String getUsers(Model model) {
        Iterable<User> users = userServiceImpl.findAll();
        model.addAttribute("users",users);
        return "user";
    }

    @GetMapping( "/addUser")
    public String addUser(Model model) {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userServiceImpl.save(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable(value = "id") long id, Model model) {
       User user = userServiceImpl.findById(id).orElseThrow();
        userServiceImpl.delete(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable(value = "id") long id, Model model) {
        Optional<User> user = userServiceImpl.findById(id);
        ArrayList<User> res = new ArrayList<>();
        user.ifPresent(res::add);
        model.addAttribute("user", res);
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String editUser(@PathVariable(value = "id") long id, @ModelAttribute("user") User user) {
        userServiceImpl.save(user);
        return "redirect:/user";
    }
}
