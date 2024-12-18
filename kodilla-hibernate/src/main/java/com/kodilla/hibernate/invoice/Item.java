package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "ITEMS")
public class Item {
    private int id;
    private Product product;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;

    public Item(){
    }

    public Item(Product product, BigDecimal price, int quantity, BigDecimal value) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.value = value;
    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ITEM_ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @NotNull
    @JoinColumn(name = "PRODUCT")
    @ManyToOne(cascade = CascadeType.ALL)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    @NotNull
    @Column(name = "ITEM_PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @NotNull
    @Column(name = "ITEM_QUANTITY")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @NotNull
    @Column(name = "ITEM_VALUE")
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}