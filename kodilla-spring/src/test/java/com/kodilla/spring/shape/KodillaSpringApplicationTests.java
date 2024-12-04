package com.kodilla.spring.shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class KodillaSpringApplicationTests {

	@Test
	void testCircleLoadedIntoContainer() {
		//Given
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");
		Shape shape = (Shape)context.getBean("circle");

		//When
		String name = shape.getShapeName();

		//Then
		Assertions.assertEquals("This is a circle.", name);
	}
	@Test
	void testTriangleLoadedIntoContainer() {
		//Given
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");
		Shape shape = (Shape) context.getBean("triangle");

		//When
		String name = shape.getShapeName();

		//Then
		Assertions.assertEquals("This is a triangle.", name);
	}

	@Test
	void testSquareLoadedIntoContainer() {
		//Given
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");
		Shape shape = (Shape)context.getBean("createSquare");

		//When
		String name = shape.getShapeName();

		//Then
		Assertions.assertEquals("This is a square.", name);
	}

	@Test
	void contextLoads() {

	}
}
