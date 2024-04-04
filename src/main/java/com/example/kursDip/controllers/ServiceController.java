package com.example.kursDip.controllers;

import com.example.kursDip.models.Phone;
import com.example.kursDip.models.Service;
import com.example.kursDip.repository.PhoneRepository;
import com.example.kursDip.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;


@Controller
public class ServiceController {
    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("/services")
    public String services(Model model){
        Iterable<Service> services = serviceRepository.findAll();
        model.addAttribute("services", services);
        return "service";
    }

    @GetMapping("/services/{id}")
    public String serviceDetails(@PathVariable(value = "id") long id, Model model){
        Optional<Service> service = serviceRepository.findById(id);
        ArrayList<Service> res = new ArrayList<>();
        service.ifPresent(res::add);
        model.addAttribute("service", res);
        return  "service-details";
    }
}