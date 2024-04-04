package com.example.kursDip.controllers;

import com.example.kursDip.models.Phone;
import com.example.kursDip.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @Autowired
    private PhoneRepository phoneRepository;

    @GetMapping("/phone")
    public String phone(Model model){
        Iterable<Phone> phones = phoneRepository.findAll();
        model.addAttribute("phones", phones);
        return "phone";
    }

    @GetMapping("/phone/{id}")
    public String phoneDetails(@PathVariable(value = "id") long id, Model model){
        Optional<Phone> phone = phoneRepository.findById(id);
        ArrayList<Phone> res = new ArrayList<>();
        phone.ifPresent(res::add);
        model.addAttribute("phone", res);
        return  "phone-details";
    }
}
