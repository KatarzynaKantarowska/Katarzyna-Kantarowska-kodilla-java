package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain extends FunctionalCalculator {
    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Elo,Elo",text->"320" + text + "320");
        poemBeautifier.beautify("Elo, Elo", text -> text.toUpperCase());
        poemBeautifier.beautify("Elo, Elo", text -> text.toLowerCase());
        poemBeautifier.beautify("Elo, Elo", text -> "*****" + text + "*****");

        Processor processor = new Processor();
        processor.execute(() ->System.out.println("This is an example"));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();       // [5]

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
    }
}
