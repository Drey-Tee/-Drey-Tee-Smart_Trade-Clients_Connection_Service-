package com.Alcatraz.Client.Connectivity.Models;

import javax.persistence.*;

@Entity
@Table(name = "order_status")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
//    @OneToOne(mappedBy = "orderstatus")
//    private Order order;

    public OrderStatus() {
    }

    public OrderStatus( String name) {
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
        return "OrderStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
