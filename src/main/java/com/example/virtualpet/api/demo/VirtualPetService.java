package com.example.virtualpet.api.demo;

import org.springframework.stereotype.Service;

@Service
public class VirtualPetService {
    private VirtualPetRepository petRepo;

    public VirtualPetService(VirtualPetRepository petRepo){
        this.petRepo = petRepo;
    }

    public Iterable<VirtualPet> findAll(){
        return petRepo.findAll();
    }
    public void addPet(VirtualPet pet){
        petRepo.save(pet);
    }
    public void deletePet(Long id){
        petRepo.deleteById(id);
    }
    
}
