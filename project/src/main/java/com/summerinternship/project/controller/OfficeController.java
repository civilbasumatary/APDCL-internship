package com.summerinternship.project.controller;

import com.summerinternship.project.model.Office;
import com.summerinternship.project.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/offices")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @GetMapping
    public String listOffices(Model model) {
        List<Office> offices = officeService.getAllOffices();
        model.addAttribute("offices", offices);
        return "offices/list";
    }

    @GetMapping("/new")
    public String createOfficeForm(Model model) {
        model.addAttribute("office", new Office());
        return "offices/create";
    }

    @PostMapping
    public String saveOffice(@ModelAttribute Office office) {
        officeService.saveOffice(office);
        return "redirect:/offices";
    }

    @GetMapping("/edit/{id}")
    public String editOfficeForm(@PathVariable Long id, Model model) {
        Office office = officeService.getOfficeById(id);
        model.addAttribute("office", office);
        return "offices/edit";
    }

    @PostMapping("/{id}")
    public String updateOffice(@PathVariable Long id, @ModelAttribute Office office) {
        office.setId(id);
        officeService.saveOffice(office);
        return "redirect:/offices";
    }

    @GetMapping("/delete/{id}")
    public String deleteOffice(@PathVariable Long id) {
        officeService.deleteOffice(id);
        return "redirect:/offices";
    }
}

