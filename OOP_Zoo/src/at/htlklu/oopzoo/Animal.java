package at.htlklu.oopzoo;

public abstract class Animal implements Printable {

	protected int age;
	protected String name;
	
	public Animal(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public void eat() {
		System.out.println(getDetails("eat()"));
	}
	
	@Override
	public void printDetails() {
		System.out.println(getBaseDetails());
	}
	
	private String getBaseDetails() {
		return getClass().getName() + " - " + name + " - " + age;
	}
	
	@Override
	public String getDetails(String methodName) {
		return getBaseDetails() + " - " + methodName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
}
