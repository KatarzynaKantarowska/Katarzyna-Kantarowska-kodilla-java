package com.kodilla.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public final class Library {

    private final List<String> books = new ArrayList<>();
    private LibraryDBController libraryDBController;

    public Library(final LibraryDBController libraryDBController) {
        this.libraryDBController = libraryDBController;
    }
    public Library() {}

    public void saveToDb(){
        libraryDBController.saveData();
    }
    public void loadFromDb(){
        libraryDBController.loadData();
    }
}
