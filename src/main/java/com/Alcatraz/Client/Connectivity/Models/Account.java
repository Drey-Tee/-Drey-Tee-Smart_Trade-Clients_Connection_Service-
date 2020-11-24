package com.Alcatraz.Client.Connectivity.Models;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    Client client;

    @ManyToOne
    @JoinColumn(name = "portfolio_id",referencedColumnName = "id")
    Portfolio portfolio;

    public Account() {
    }

    public Account(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                '}';
    }
}
