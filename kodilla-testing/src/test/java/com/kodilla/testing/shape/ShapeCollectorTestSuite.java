package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.List;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for square")
    public class TestSquare {
        @Test
        void addSquareFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square();

            //When
            shapeCollector.addFigure(square);

            //Then
            List<Shape> collectorCollection = shapeCollector.getCollectorCollection();
            Assertions.assertEquals(1, collectorCollection.size());
            Assertions.assertTrue(collectorCollection.get(0) instanceof Square);
        }

        @Test
        void removeFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square();

            //When
            shapeCollector.removeFigure(square);

            //Then
            Assertions.assertEquals(0, shapeCollector.getCollectorCollection().size());
            Assertions.assertTrue(shapeCollector.getCollectorCollection().isEmpty());
        }

        @Test
        void getFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square expected = new Square();
            List<Shape> collectorCollection = shapeCollector.getCollectorCollection();
            collectorCollection.add(expected);

            //When
            Shape actual = shapeCollector.getFigure(0);

            //Then
            Assertions.assertFalse(collectorCollection.isEmpty());
            Assertions.assertEquals(1, collectorCollection.size());
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Tests for triangle")
    class TestTriangle {
        @Test
        void addFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle();

            //When
            shapeCollector.addFigure(triangle);

            //Then
            List<Shape> collectorCollection = shapeCollector.getCollectorCollection();
            Assertions.assertEquals(1, shapeCollector.getCollectorCollection().size());
            Assertions.assertTrue(collectorCollection.get(0) instanceof Triangle);
        }

        @Test
        void removeFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle();

            //When
            shapeCollector.removeFigure(triangle);

            //Then
            Assertions.assertEquals(0, shapeCollector.getCollectorCollection().size());
            Assertions.assertTrue(shapeCollector.getCollectorCollection().isEmpty());
        }

        @Test
        void getFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle expected = new Triangle();
            List<Shape> collectorCollection = shapeCollector.getCollectorCollection();
            collectorCollection.add(expected);

            //When
            Shape actual = shapeCollector.getFigure(0);

            //Then
            Assertions.assertFalse(collectorCollection.isEmpty());
            Assertions.assertEquals(1, collectorCollection.size());
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Tests for circle")
    class TestCircle {
        @Test
        void addFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle();

            //When
            shapeCollector.addFigure(circle);

            //Then
            List<Shape> collectorCollection = shapeCollector.getCollectorCollection();
            Assertions.assertEquals(1, shapeCollector.getCollectorCollection().size());
            Assertions.assertTrue(collectorCollection.get(0) instanceof Circle);
        }

        @Test
        void removeFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle();

            //When
            shapeCollector.removeFigure(circle);

            //Then
            Assertions.assertEquals(0, shapeCollector.getCollectorCollection().size());
            Assertions.assertTrue(shapeCollector.getCollectorCollection().isEmpty());
        }

        @Test
        void getFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle expected = new Circle();
            List<Shape> collectorCollection = shapeCollector.getCollectorCollection();
            collectorCollection.add(expected);

            //When
            Shape actual = shapeCollector.getFigure(0);

            //Then
            Assertions.assertFalse(collectorCollection.isEmpty());
            Assertions.assertEquals(1, collectorCollection.size());
            Assertions.assertEquals(expected, actual);
        }
    }

    @Test
    void showFigures() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        List<Shape> collectorCollection = shapeCollector.getCollectorCollection();
        Square square = new Square();
        Triangle triangle = new Triangle();
        Circle circle = new Circle();
        collectorCollection.add(square);
        collectorCollection.add(triangle);
        collectorCollection.add(circle);

        //When
        String s = shapeCollector.showFigures();

        //Then
        Assertions.assertEquals(3, shapeCollector.getCollectorCollection().size());
        Assertions.assertTrue(collectorCollection.contains(square));
        Assertions.assertTrue(collectorCollection.contains(triangle));
        Assertions.assertTrue(collectorCollection.contains(circle));
        Assertions.assertEquals("SquareTriangleCircle", s);
    }
}