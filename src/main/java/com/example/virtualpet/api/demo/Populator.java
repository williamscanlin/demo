package com.example.virtualpet.api.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner{

    private VirtualPetRepository petRepo;

    public Populator(VirtualPetRepository petRepo){
        this.petRepo = petRepo;
    }
    @Override
    public void run(String... args) throws Exception {
        VirtualPet pet1 = new VirtualPet("Maggie", "Dog",1,1,1);
        VirtualPet pet2 = new VirtualPet("Scout", "Dog",1,1,1);
        VirtualPet pet3 = new VirtualPet("Whiskers","Cat",1,1,1);
        VirtualPet pet4 = new VirtualPet("Bones","Cat",1,1,1);

        petRepo.save(pet1);
        petRepo.save(pet2);
        petRepo.save(pet3);
        petRepo.save(pet4);

    }
}
