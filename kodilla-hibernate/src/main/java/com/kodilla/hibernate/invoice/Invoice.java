package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
@Entity
@Table(name = "INVOICES")
public class Invoice {
    private Integer id;
    private String number;
    private List<Item> items;

    public Invoice(){
    }

    public Invoice(String number, List<Item> items) {
        this.number = number;
        this.items = items;
    }

    @Id
    @GeneratedValue
    @Column(name = "INVOICE_ID")
    @NotNull
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "INVOICE_NUMBER")
    @NotNull
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    @Column(name = "INVOICE_ITEMS")
    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
