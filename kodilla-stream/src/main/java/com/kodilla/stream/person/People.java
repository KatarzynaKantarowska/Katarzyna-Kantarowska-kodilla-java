package com.kodilla.stream.person;

import java.util.ArrayList;
import java.util.List;

public final class People {
    public static List<String> getList() {
        final List<String> theList = new ArrayList<>();

        theList.add("John Smith");
        theList.add("John Smit");
        theList.add("John Smi");
        theList.add("Joh Smith");
        theList.add("Jo Smith");
        theList.add("Jo Sm");
        theList.add("John Sh");
        theList.add("John S");
        theList.add("J S");
        theList.add("Jo S");

        return new ArrayList<>(theList);
    }

}
