package com.example.virtualpet.api.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.dao.EmptyResultDataAccessException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class VirtualPetController {
    private final VirtualPetService petService;

    public VirtualPetController(VirtualPetService petService){
        this.petService = petService;
    }

    @GetMapping("/home")
    public String home(Model page){
        var virtualPets = petService.findAll();
        page.addAttribute("pets", virtualPets);
        return "index.html";
    }

    @PostMapping("/home")
    public String addPet(
        @RequestParam String petName,
        @RequestParam String petDesc,
        @RequestParam int hunger,
        @RequestParam int boredom,
        @RequestParam int thirst,
        Model page){
            if(petName.isBlank() || petDesc.isBlank() || hunger == 0 || boredom == 0 || thirst == 0){
                page.addAttribute("invalidInfo", "Please Enter correct information to add Pet");
                return "errorAddPet.html";
            }
            VirtualPet pet = new VirtualPet(petName,petDesc,hunger,boredom,thirst);
            petService.addPet(pet);
            var virtualPets = petService.findAll();
            page.addAttribute("pets", virtualPets);
            return "index.html";
    }

    @PostMapping("/delete")
    public String deletePet(
        @RequestParam Long deleteId,
        Model page){
            petService.deletePet(deleteId);
            var virtualPets = petService.findAll();
            page.addAttribute("pets", virtualPets);
            return "index.html";
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public String errorOnDelete(HttpServletRequest request, Exception ex, Model page){
        String invalidId = request.getParameter("deleteId");
        page.addAttribute("invalidId", invalidId);
        return "errorID.html";
    }
    
    
}
