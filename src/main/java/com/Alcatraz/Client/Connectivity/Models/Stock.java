package com.Alcatraz.Client.Connectivity.Models;

import javax.persistence.*;

@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ticker;
    private int quantity;

    @ManyToOne
    @JoinColumn(name="portfolio_id",referencedColumnName = "id")
    Portfolio portfolio;


    public Stock() {
    }

    public Stock(Long id, String ticker, int quantity) {
        this.id = id;
        this.ticker = ticker;
        this.quantity = quantity;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", ticker='" + ticker + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
