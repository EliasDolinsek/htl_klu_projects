package at.htlklu.oopzoo;

public interface Flyable extends Printable {

	default void takeOff() {
		System.out.println(getDetails("takeOff()"));
	}
	
	default void fly() {
		System.out.println(getDetails("fly()"));
	}
	
	default void land() {
		System.out.println("land()");
	}
	
}
