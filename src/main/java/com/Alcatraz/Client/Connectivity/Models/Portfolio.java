package com.Alcatraz.Client.Connectivity.Models;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    Client client;

//    @OneToMany(mappedBy = "portfolio")
//    private Order order;


    public Portfolio() {
    }

    public Portfolio( String name) {
        this.name = name;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
