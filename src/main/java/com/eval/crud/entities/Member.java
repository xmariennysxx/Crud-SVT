package com.eval.crud.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Member {

    @GeneratedValue
    @Id
    private int id;

    private String name;

    private int age;

    private String gender;

    @ManyToOne
    private Unit unit;

    @ManyToOne
    private Position position;

    public Member() {
    }

    public Member(String name, int age, String gender, Unit unit, Position position) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.unit = unit;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

}
