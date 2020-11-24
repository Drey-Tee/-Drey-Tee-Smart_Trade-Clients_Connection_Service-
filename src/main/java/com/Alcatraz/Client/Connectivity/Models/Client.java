package com.Alcatraz.Client.Connectivity.Models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

//package com.example.User_Service.models;
@Entity
@Table(name = "clients")
public class Client{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String first_name;
    private String last_name;
    private String other_name;

//    @ElementCollection
//    @OneToMany(mappedBy = "client")
//    private List<Order> orders;

    @Column(unique = true)
    private String email;

    private String password;
    private Double bank_balance;
    private LocalDateTime created;



    public Client() {
    }

    public Client(Long id,
                  String first_name,
                  String last_name,
                  String other_name,
                  String email,
                  String password) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.other_name = other_name;
        this.email = email;
        this.password = password;
//        this.bank_balance = new Random().nextDouble() * 1000;
        this.bank_balance = 1000.0;
        this.created = LocalDateTime.now();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOther_name() {
        return other_name;
    }

    public void setOther_name(String other_name) {
        this.other_name = other_name;
    }

    public Double getBank_balance() {
        return bank_balance;
    }

    public void setBank_balance(Double bank_balance) {
        this.bank_balance = bank_balance;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", Other_name='" + other_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", bank_balance=" + bank_balance +
                '}';
    }
}

