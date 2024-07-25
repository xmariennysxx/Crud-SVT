package com.eval.crud.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Unit {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    public Unit() {
    }

    public Unit(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
    }

}
