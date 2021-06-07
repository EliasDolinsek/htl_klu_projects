package at.htlklu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Exercise {

	private static ArrayList<Book> books = new ArrayList<Book>();
	
	public static void fill() {
		for(int i = 0; i<6; i++) {
			books.add(new Book("A" + i, "A" + i * Math.random(), "I" + i));
		}
	}
	
	public static void main(String[] args) {
		fill();
		
		printUnsorted();

		System.out.println("\n");
		printSorted();
		
		System.out.println("\n");
		printSortedReversed();
		
		System.out.println("\n\n");
		hashSetExample();
		
		System.out.println("\n\n");
		hashMapExample();
		
		System.out.println("\n\n");
		treeSetExample();
	}
	
	/*
	 * TreeSets werden nach dem Comparable vom Book sortiert
	 */
	private static void treeSetExample() {
		System.out.println("TreeSet:");
		TreeSet<Book> treeSet = new TreeSet<>();
		treeSet.addAll(books);
		treeSet.add(books.get(books.size() - 1));
		treeSet.forEach(System.out::println);
	}
	
	private static void hashSetExample() {
		System.out.println("HashSet:");
		HashSet<Book> hashSet = new HashSet<>();
		hashSet.addAll(books);
		hashSet.add(books.get(books.size() - 1));
		hashSet.forEach(System.out::println);
	}
	
	private static void hashMapExample() {
		System.out.println("HashMap:");
		HashMap<Integer, Book> hashMap = new HashMap<>();
		for(int i = 0; i<books.size(); i++) {
			hashMap.put(i, books.get(i));
		}
		
		hashMap.entrySet().forEach(e -> System.out.println(e.getValue()));
	}
	
	private static void printUnsorted() {
		System.out.println("UNSORTED");
		books.forEach(System.out::println);
	}
	
	private static void printSorted() {
		System.out.println("SORTED");
		Collections.sort(books);
		books.forEach(System.out::println);
	}
	
	private static void printSortedReversed() {
		System.out.println("SORTED REVERSED");
		Collections.sort(books);
		Collections.reverse(books);
		books.forEach(System.out::println);
	}
}
