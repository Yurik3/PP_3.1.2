package com.example.pp_3_1_2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "usert")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "secondName")
    private String secondName;
    @Column(name = "old")
    private int old;

    public User() {
    }

    public User(String name, String secondName, int old) {
        this.name = name;
        this.secondName = secondName;
        this.old = old;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }
}
