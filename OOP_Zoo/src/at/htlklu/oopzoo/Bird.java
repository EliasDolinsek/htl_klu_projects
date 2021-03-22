package at.htlklu.oopzoo;

public abstract class Bird extends Animal implements Flyable {

	public Bird(int age, String name) {
		super(age, name);
	}
	
	public void hops() {
		System.out.println(super.getDetails("hops()"));
	}

	public void layEggs() {
		System.out.println(getDetails("layEggs"));
	}
	
}
