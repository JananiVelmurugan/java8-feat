package com.janani.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ex2 {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		// Simple Loop
		for (Object it : l) {
			System.out.println(it);
		}

		// Storing a Simple Loop in Java 8
		Consumer<Iterable> printObjects2 = list -> {
			for (Object it : list) {
				System.out.println(it);
			}
		};

		// For the record, this is the same result in more idiomatic Java 8 code:
		Consumer<Iterable> printObjects3 = list -> list.forEach(System.out::println);
	}

}
