package at.htlklu.coffeemachine;

public abstract class CoffeeMachine {

	private final String brand;
	private final int maxCups;
	private final int maxWater;
	private final int maxCoffee;
	private boolean isFilled;

	public CoffeeMachine(String brand, int maxCups, int maxWater, int maxCoffee, boolean isFilled) {
		this.brand = brand;
		this.maxCups = maxCups;
		this.maxWater = maxWater;
		this.maxCoffee = maxCoffee;
		this.isFilled = isFilled;
	}

	public void fill() {
		isFilled = true;
	}

	public void cook() {
		if (isFilled) {
			isFilled = false;
			System.out.println("Die " + getClass().getSimpleName() + " " + brand + " bereitet " + maxCups + " Tassen zu");
		} else {
			System.out.println("Die Kaffeemaschine " + brand + " ist nicht befüllt.");
		}
	}

	public String getBrand() {
		return brand;
	}

	public int getMaxCups() {
		return maxCups;
	}

	public int getMaxWater() {
		return maxWater;
	}

	public int getMaxCoffee() {
		return maxCoffee;
	}

	public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}

}
