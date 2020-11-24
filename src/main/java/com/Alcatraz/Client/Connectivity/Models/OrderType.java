package com.Alcatraz.Client.Connectivity.Models;

import javax.persistence.*;

@Entity
@Table(name = "order_type")
public class OrderType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

//    @OneToOne(mappedBy = "orderType")
//    private Order order;

    public OrderType() {
    }

    public OrderType( String name) {

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

    @Override
    public String toString() {
        return "OrderType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
