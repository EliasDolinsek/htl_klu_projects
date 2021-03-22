package at.htlklu.oopzoo.impl.mammals;

import at.htlklu.oopzoo.Mammal;

public class Elephant extends Mammal {

	public Elephant(int age, String name) {
		super(age, name);
	}

	public void trumpet() {
		System.out.println(super.getDetails("trumpet()"));
	}
	
	@Override
	public void eat() {
		System.out.println(super.getDetails("eat() with trunk"));
	}
}
