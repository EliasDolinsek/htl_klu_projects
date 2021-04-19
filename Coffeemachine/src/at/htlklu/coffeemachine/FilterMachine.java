package at.htlklu.coffeemachine;

public class FilterMachine extends CoffeeMachine {

	public FilterMachine(String brand, boolean isFilled) {
		super(brand, 10, 1000, 150, isFilled);
	}
	
	public FilterMachine(String brand) {
		this(brand, true);
	}

}
