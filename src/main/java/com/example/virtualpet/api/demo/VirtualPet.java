package com.example.virtualpet.api.demo;

import javax.persistence.*;

@Entity
public class VirtualPet {
    @Id
    @GeneratedValue
    private Long id;
    private String petName;
    private String petDesc;
    private int hunger;
    private int boredom;
    private int thirst;

    public VirtualPet(){}

    public VirtualPet(String petName, String petDesc,int hunger,int boredom,int thirst){
        this.petName = petName;
        this.petDesc = petDesc;
        this.hunger = hunger;
        this.boredom = boredom;
        this.thirst = thirst;
    }

    public Long getId(){
        return id;
    }
    public String getPetName(){
        return petName;
    }
    public String getPetDesc(){
        return petDesc;
    }
    public int getHunger(){
        return hunger;
    }
    public int getBoredom(){
        return boredom;
    }
    public int getThirst(){
        return thirst;
    }
}