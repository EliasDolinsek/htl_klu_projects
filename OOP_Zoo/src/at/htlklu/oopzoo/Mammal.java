package at.htlklu.oopzoo;

public abstract class Mammal extends Animal {

	public Mammal(int age, String name) {
		super(age, name);
	}
	
	public void run() {
		System.out.println(super.getDetails("run()"));
	}

}
