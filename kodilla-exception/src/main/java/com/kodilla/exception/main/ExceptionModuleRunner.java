package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;

import java.io.IOException;

public class ExceptionModuleRunner {
    public static void main(String[] args) throws IOException {
        FileReaderWithoutHandling fileReader= new FileReaderWithoutHandling();
        fileReader.readFile();

        FileReader sampleFileReader = new FileReader();
        try {
            sampleFileReader.readFile();
        } catch (FileReaderException e) {
                System.out.println("Problem while reading file!");
        }
    }
}
