package com.Alcatraz.Client.Connectivity.Models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ticker_name;
    private Long quantity;

    @CreationTimestamp
    private LocalDateTime created;

    private String marketOrderId;

    @ManyToOne
    @JoinColumn(name = "client_id",referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "portfolio_id",referencedColumnName = "id")
    Portfolio portfolio;

    @OneToOne
    @JoinColumn(name = "order_type_id", referencedColumnName = "id")
    OrderType orderType;

    @OneToOne
    @JoinColumn(name="status_id",referencedColumnName = "id")
    OrderStatus orderStatus;

    protected  Order() {
        this.created = LocalDateTime.now();
    }

    public Order(String ticker_name, Long quantity ) {
        this.ticker_name = ticker_name;
        this.quantity = quantity;
        this.marketOrderId = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicker_name() {
        return ticker_name;
    }

    public void setTicker_name(String ticker_name) {
        this.ticker_name = ticker_name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getMarketOrderId() {
        return marketOrderId;
    }

    public void setMarketOrderId(String marketOrderId) {
        this.marketOrderId = marketOrderId;
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

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ticker_name='" + ticker_name + '\'' +
                ", quantity=" + quantity +
                ", created=" + created +
                ", marketOrderId='" + marketOrderId + '\'' +
                '}';
    }
}
