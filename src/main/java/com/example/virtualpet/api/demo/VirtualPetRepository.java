package com.example.virtualpet.api.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirtualPetRepository extends CrudRepository<VirtualPet, Long>{
    
}
