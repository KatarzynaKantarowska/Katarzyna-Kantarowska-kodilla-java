package com.kodilla.stream.beautifier;

import java.util.function.Function;

public class PoemBeautifier{
    public void beautify(String text, Function<String, String> beautifier) {
        String result = beautifier.apply(text);
        System.out.println(result);
    }
}
