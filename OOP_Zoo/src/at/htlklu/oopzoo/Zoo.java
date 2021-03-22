package at.htlklu.oopzoo;

import java.util.ArrayList;
import java.util.Iterator;

import at.htlklu.oopzoo.impl.mammals.Elephant;

public class Zoo {

	private ArrayList<Animal> animals = new ArrayList<Animal>();
	private ArrayList<Flyable> flightEnclosure = new ArrayList<Flyable>();
	
	public void addAnimal(Animal animal) {
		animals.add(animal);
	}
	
	public void addAnimalToFlightEnclosure(Flyable flyable) {
		flightEnclosure.add(flyable);
	}
	
	public void trompetAll() {
		for(Animal animal:animals) {
			if(animal instanceof Elephant) {
				((Elephant) animal).trumpet();
			}
		}
	}
	
	public void flyAll() {
		for(Flyable flyable:flightEnclosure) {
			flyable.fly();
		}
	}
	
	public void layEggsAll() {
		for(Flyable flyable:flightEnclosure) {
			if(flyable instanceof Bird) {
				((Bird) flyable).layEggs();
			}
		}
		
		for(Animal animal:animals) {
			if(animal instanceof Bird) {
				((Bird) animal).layEggs();
			}
		}
	}
	
	public void printAll() {
		for(Animal animal:animals) {
			animal.printDetails();
		}
		
		for(Flyable flyable:flightEnclosure) {
			flyable.printDetails();
		}
	}
}
