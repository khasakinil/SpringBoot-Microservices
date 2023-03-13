package com.functional;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FunctionalProgramming {

	public static void main(String args[]) {

		List<Integer> numberList = List.of(12, 9, 13, 4, 6, 2, 15);

		List<String> courseList = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure",
				"Docker", "Kubernetes");

		List<String> fruits = List.of("Apple", "Banana", "Mango");

		String filter = "Spring";
		int courseLength = 4;

		printAllNumbersInListUsingStructured(numberList);
		printAllNumbersInListUsingFunctional(numberList);
		printAllNumbersInListUsingLambdaExpressionnumberList(numberList);
		printOddlNumbersInListUsingLambdaExpressionnumberList(numberList);

		printAllCourses(courseList);
		printAllCourses(courseList, filter);
		printAllCourses(courseList, courseLength);
		printSquareOfEvenNumbers(numberList);
		printCubesOfOddNumbers(numberList);
		printLengthOfEachCourse(courseList);

		optionalClassUsage(fruits);

	}

	private static void optionalClassUsage(List<String> fruits) {
		System.out.println("OptionalClass usage");
		Predicate<? super String> predicate = fruit -> fruit.startsWith("BM");
		Optional<String> optional = fruits.stream().filter(predicate).findFirst();

		System.out.println("optional.isEmpty() : " + optional.isEmpty());
		System.out.println("optional.isPresent() : " + optional.isPresent());
		System.out.println("optional.get() : " + optional.get());

	}

	private static void printLengthOfEachCourse(List<String> courseList) {
		System.out.println("\n\nPrinting length of Each course : ");

		courseList.stream().map(course -> course + " : " + course.length()).forEach(System.out::println);

	}

	private static void printCubesOfOddNumbers(List<Integer> numberList) {

		System.out.println("\n\nPrinting Cubes of odd numbers: ");

		numberList.stream().filter(num -> num % 2 != 0).map(num -> num * num * num).forEach(System.out::println);
	}

	private static void printSquareOfEvenNumbers(List<Integer> numberList) {
		System.out.println("\n\nPrinting square of even numbers: ");
//		numberList.stream().filter(num -> num % 2 == 0)
//				.forEach(num -> System.out.println("Square of " + num + " : " + num * num));

		numberList.stream().filter(num -> num % 2 == 0).map(num -> num * num).forEach(System.out::println);
	}

	private static void printAllCourses(List<String> courseList, int courseLength) {
		System.out.println("\n\nPrinting all courses with filter length: ");
		courseList.stream().filter(course -> course.length() > courseLength).forEach(System.out::println);

	}

	private static void printAllCourses(List<String> courseList, String filter) {
		System.out.println("\n\nPrinting all courses with filter : ");
		courseList.stream().filter(course -> course.contains(filter)).forEach(System.out::println);

	}

	private static void printAllCourses(List<String> courseList) {
		System.out.println("\n\nPrinting all courses : ");
		courseList.stream().forEach(System.out::println);

	}

	private static void printOddlNumbersInListUsingLambdaExpressionnumberList(List<Integer> numberList) {
		System.out.println("Printing Odd numbers from the list");
		numberList.stream().filter(num -> num % 2 != 0).forEach(num -> System.out.print(num + " "));

	}

	private static void printAllNumbersInListUsingLambdaExpressionnumberList(List<Integer> numbers) {
		// Lambda expression approach
		System.out.println("\nUsing all numbersLambda expression approach");
		// numbers.stream().forEach(o -> print(o));
		numbers.stream().forEach(o -> System.out.println(o));
		System.out.println("\nPrinting even numbers using Lambda expression approach");
		numbers.stream().filter(num -> num % 2 == 0).forEach(System.out::println);

	}

	private static void printAllNumbersInListUsingStructured(List<Integer> numbers) {

		// Structured approach
		System.out.println("\nUsing structured approach");
		System.out.println("\nPrinting all numbers using structured approach");
		for (int number : numbers) {
			System.out.print(number + " ");
		}

		System.out.println("\nPrinting even numbers using structured approach");
		for (int number : numbers) {
			if (isEven(number)) {
				System.out.print(number + " ");
			}
		}

	}

	private static boolean isEven(int number) {
		return number % 2 == 0;
	}

	private static void printAllNumbersInListUsingFunctional(List<Integer> numbers) {

		// functional approach
		System.out.println("\nUsing functional approach");
//		numbers.stream().forEach(o -> print(o));
//		numbers.stream().forEach(o-> System.out.println(o));
//		numbers.stream().forEach(FunctionalProgramming::print);
		System.out.println("\nPrinting all numbers using functional approach");
		numbers.stream().forEach(System.out::println);
		System.out.println("\nPrinting even numbers using functional approach");
//		numbers.stream().filter(num -> num % 2 == 0).forEach(System.out::println);
		numbers.stream().filter(FunctionalProgramming::isEven).forEach(System.out::println);
	}

	private static void print(int number) {
		System.out.println(number);
	}
}
