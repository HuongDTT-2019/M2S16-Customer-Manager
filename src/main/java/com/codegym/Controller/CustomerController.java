package com.codegym.Controller;

import com.codegym.Persistence.CustomerPersistenceImpl;
import com.codegym.Service.GeneralService;
import com.codegym.Service.CustomerServiceImpl;
import com.codegym.Model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomerController {
    @Autowired
    private CustomerPersistenceImpl customerPersistence;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("customers",customerPersistence.findAll());
        return "index";
    }
    @GetMapping("/customer/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }
    @PostMapping("/customer/save")
    public String save(@ModelAttribute Customer customer, RedirectAttributes redirect) {
        customer.setId((int)(Math.random() * 10000));
        customerPersistence.save(customer);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/";
    }
    @GetMapping("/customer/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("customer",customerPersistence.findById(id));
        return "edit";
    }
    @PostMapping("/customer/update")
    public String update(@ModelAttribute Customer customer, RedirectAttributes redirect){
        customerPersistence.update(customer.getId(),customer);
        redirect.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/";
    }
    @GetMapping("/customer/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("customer",customerPersistence.findById(id));
        return "delete";
    }
    @PostMapping("/customer/remove")
    public String remove(@ModelAttribute Customer customer,RedirectAttributes redirect){
        customerPersistence.remove(customer.getId());
        redirect.addFlashAttribute("success","Deleted!");
        return "redirect:/";
    }
    @GetMapping("/customer/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("customer",customerPersistence.findById(id));
        return "views";
    }
    @GetMapping("/customer/search")
    public String search(@RequestParam String name, Model model){
        model.addAttribute("customer",customerPersistence.findByName(name));
        return "result";
    }
}
