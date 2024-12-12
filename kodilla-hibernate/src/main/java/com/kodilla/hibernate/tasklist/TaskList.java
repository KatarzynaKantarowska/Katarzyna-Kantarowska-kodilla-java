package com.kodilla.hibernate.tasklist;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "TASKLISTS")
public class TaskList {
    private int id;
    private String listName;
    private String description;

    public TaskList(){
    }

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    public int getId() {
        return id;
    }
    @NotNull
    @Column(name = "LISTNAME")
    public String getDescription() {
        return description;
    }

    @Column(name = "DESCRIPTION")
    public String getListName() {
        return listName;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setListName(String listName) {
        this.listName = listName;
    }

    private void setDescription(String description) {
        this.description = description;
    }
}
