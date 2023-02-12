package com.example.pp_3_1_2.controllers;

import com.example.pp_3_1_2.models.User;
import com.example.pp_3_1_2.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public String getUser(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        return "user";
    }

    @GetMapping( "/addUser")
    public String addUser(Model model) {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUsers(@RequestParam String name, @RequestParam String secondName, @RequestParam int old, Model model) {
        User user = new User(name, secondName, old);
      userRepository.save(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable(value = "id") long id, Model model) {
       User user = userRepository.findById(id).orElseThrow();
       userRepository.delete(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable(value = "id") long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        ArrayList<User> res = new ArrayList<>();
        user.ifPresent(res::add);
        model.addAttribute("user", res);
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String editUsers(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String secondName, @RequestParam int old, Model model) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(name);
        user.setSecondName(secondName);
        user.setOld(old);
        userRepository.save(user);
        return "redirect:/user";
    }
}
